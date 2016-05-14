package si.meansoft.traincraft.tileEntities;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTank;
import si.meansoft.traincraft.Util;
import si.meansoft.traincraft.api.recipes.DistilleryRecipes;
import si.meansoft.traincraft.blocks.BlockDistillery;

/**
 * @author canitzp
 */
public class TileEntityDistillery extends TileEntityInventory implements ITickable {

    public FluidTank tank = new FluidTank(16000);
    public int currentBurn = 0, currentCookTime = 0, maxBurnTime = 0, maxCookTime = 0;
    public ItemStack currentBurnStack = null;

    private int lastCurrentBurn;
    private int lastCurrentCookTime;
    private int lastMaxBurnTime;
    private int lastMaxCookTime;

    public TileEntityDistillery() {
        super("InventoryDistillery", 6);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return index == 0 || (TileEntityFurnace.isItemFuel(itemStackIn) && index == 1) && direction != EnumFacing.DOWN;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return index != 0 && index != 1 && index != 2 && direction == EnumFacing.DOWN;
    }

    /*@Override
    public int getField(int id) {
        switch (id){
            case 0: return currentBurn;
            case 1: return currentCookTime;
            case 2: return maxBurnTime;
            case 3: return maxCookTime;
            case 4: return this.tank.getFluidAmount();
            default: return 0;
        }
    }

    @Override
    public void setField(int id, int value) {
        switch (id){
            case 0: this.currentBurn = value; break;
            case 1: this.currentCookTime = value; break;
            case 2: this.maxBurnTime = value; break;
            case 3: this.maxCookTime = value; break;
            case 4: {
                if(this.tank.getFluid() != null){
                    this.tank.getFluid().amount = value;
                } else {
                    getWorld().notifyBlockUpdate(getPos(), getWorld().getBlockState(getPos()), getWorld().getBlockState(getPos()), 3);
                    this.markDirty();
                }
            } break;
        }
    }*/

    public boolean isBurning(){
        return currentBurn > 0;
    }

    public boolean isCooking(){
        return currentCookTime > 0;
    }

    private boolean isTankFull(){
        return this.tank.getFluidAmount() >= this.tank.getCapacity();
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    @Override
    public void update() {
        if(!this.worldObj.isRemote){
            ItemStack input = this.getStackInSlot(0);
            ItemStack fuel = this.getStackInSlot(1);
            ItemStack output = this.getStackInSlot(4);
            DistilleryRecipes.RecipeHandler recipe = DistilleryRecipes.getRecipe(input);

            if(recipe != null){
                //Burn
                if((fuel != null || this.currentBurnStack != null || this.currentBurn > 0)){
                    if(currentBurn <= 0 && !this.isTankFull()){
                        this.decrStackSize(1, 1);
                        this.currentBurn = this.maxBurnTime = TileEntityFurnace.getItemBurnTime(fuel);
                    } else {
                        this.currentBurn--;
                    }
                }

                //Distill
                if (!this.isCooking() && input != null && isBurning()) {
                    if (this.tank.getFluidAmount() + recipe.outputFluid.amount <= this.tank.getCapacity()) {
                        this.decrStackSize(0, 1);
                        this.currentCookTime = this.maxCookTime = recipe.burnTime;
                        this.currentBurnStack = recipe.outputStack.copy();
                    }
                } else {
                    if (this.currentCookTime == 1 && this.isBurning()) {
                        if (output == null) {
                            if(this.currentBurnStack != null)
                                this.setInventorySlotContents(4, this.currentBurnStack.copy());
                            if(recipe.outputFluid != null){
                                this.tank.fill(recipe.outputFluid.copy(), true);
                            }
                            this.currentBurnStack = null;
                            this.currentCookTime--;
                            dropXP(getWorld(), getPos(), recipe.outputExp);
                        } else if (output.isItemEqual(this.currentBurnStack)) {
                            if (output.copy().stackSize + this.currentBurnStack.copy().stackSize <= this.getInventoryStackLimit()) {
                                this.incrStackSize(4, this.currentBurnStack.copy().stackSize);
                                this.currentBurnStack = null;
                                this.currentCookTime--;
                                if(recipe.outputFluid != null){
                                    this.tank.fill(recipe.outputFluid.copy(), true);
                                }
                                dropXP(getWorld(), getPos(), recipe.outputExp);
                            }
                        }
                        this.markDirty();
                    } else if(this.isBurning()) {
                        this.currentCookTime--;
                    } else {
                        this.currentCookTime++;
                    }
                }
            } else {
                //Burn
                if(this.currentBurn > 0){
                    this.currentBurn--;
                }
            }
            setState(this.isBurning(), BlockDistillery.ACTIVE, getWorld(), getPos());

            if(this.maxBurnTime != this.lastMaxBurnTime || this.maxCookTime != this.lastMaxCookTime || this.currentCookTime != this.lastCurrentCookTime || this.currentBurn != this.lastCurrentBurn){
                this.lastCurrentBurn = this.currentBurn;
                this.lastMaxBurnTime = this.maxBurnTime;
                this.lastMaxCookTime = this.maxCookTime;
                this.lastCurrentCookTime = this.currentCookTime;

                this.syncToClient();
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound, boolean isForSyncing) {
        super.readFromNBT(compound, isForSyncing);

        this.tank.readFromNBT(compound);
        this.currentCookTime = compound.getInteger("currentCookTime");
        this.currentBurn = compound.getInteger("currentBurnTime");
        if(isForSyncing){
            this.maxBurnTime = compound.getInteger("maxBurnTime");
            this.maxCookTime = compound.getInteger("maxCookTime");
        }
        else if(this.isCooking()){
            this.currentBurnStack = ItemStack.loadItemStackFromNBT(compound);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound, boolean isForSyncing) {
        super.writeToNBT(compound, isForSyncing);

        this.tank.writeToNBT(compound);
        compound.setInteger("currentCookTime", this.currentCookTime);
        compound.setInteger("currentBurnTime", this.currentBurn);
        if(isForSyncing){
            compound.setInteger("maxBurnTime", this.maxBurnTime);
            compound.setInteger("maxCookTime", this.maxCookTime);
        }
        else if(this.currentBurnStack != null){
            this.currentBurnStack.writeToNBT(compound);
        }
    }

    public static void setState(boolean active, PropertyBool property, World world, BlockPos pos){
        IBlockState iblockstate = world.getBlockState(pos);
        world.setBlockState(pos, iblockstate.getBlock().getDefaultState().withProperty(property, active).withProperty(BlockDistillery.FACING, iblockstate.getValue(BlockDistillery.FACING)), 3);
    }

    public static void dropXP(World world, BlockPos pos, float xp){
        if (!world.isRemote) {
            int i = 1;

            if (xp == 0.0F) {
                i = 0;
            }
            else if (xp < 1.0F) {
                int j = MathHelper.floor_float((float)i * xp);
                if (j < MathHelper.ceiling_float_int((float)i * xp) && Math.random() < (double)((float)i * xp - (float)j)) {
                    ++j;
                }
                i = j;
            }

            while (i > 0) {
                int k = EntityXPOrb.getXPSplit(i);
                i -= k;
                world.spawnEntityInWorld(new EntityXPOrb(world, pos.getX(), pos.getY() + 0.5D, pos.getZ() + 0.5D, k));
            }
        }
    }

}
