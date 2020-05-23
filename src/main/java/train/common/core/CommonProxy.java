package train.common.core;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import train.common.core.handlers.WorldEvents;
import train.common.core.util.MP3Player;

public class CommonProxy {
	public static List<MP3Player> playerList = new ArrayList<>();
	public static boolean debug = false;

	public void setKeyBinding(String name, int value) {}

	public void registerRenderInformation() {}

	public void registerEvents(FMLPreInitializationEvent event){
		WorldEvents worldEvents = new WorldEvents();
		//ChunkEvents chunkEvents = new ChunkEvents();

		registerEvent(worldEvents);
		//registerEvent(chunkEvents);
		//ForgeChunkManager.setForcedChunkLoadingCallback(Traincraft.instance, chunkEvents);

	}

	public void registerEvent(Object o){
		FMLCommonHandler.instance().bus().register(o);
		MinecraftForge.EVENT_BUS.register(o);
	}

	public void registerTileEntities() {
		/*GameRegistry.registerTileEntity(TileCrafterTierI.class, "TileCrafterTierI");
		GameRegistry.registerTileEntity(TileCrafterTierII.class, "TileCrafterTierII");
		GameRegistry.registerTileEntity(TileCrafterTierIII.class, "TileCrafterTierIII");
		GameRegistry.registerTileEntity(TileTrainWbench.class, "TileTrainWbench");
		GameRegistry.registerTileEntity(TileEntityDistil.class, "Tile Distil");
		GameRegistry.registerTileEntity(TileEntityOpenHearthFurnace.class, "Tile OpenHearthFurnace");
		GameRegistry.registerTileEntity(TileStopper.class, "TileStopper");
		GameRegistry.registerTileEntity(TileSignal.class, "TileTrainSignal");
		GameRegistry.registerTileEntity(TileSwitchStand.class, "tileSwitchStand");
		GameRegistry.registerTileEntity(TileWaterWheel.class, "tileWaterWheel");
		GameRegistry.registerTileEntity(TileWindMill.class, "tileWindMill");
		GameRegistry.registerTileEntity(TileGeneratorDiesel.class, "tileGeneratorDiesel");*/
	}
	
	//@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		/*
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		Entity ridingEntity = player.getRidingEntity();

		Entity stationaryEntity = null;
		if (y == -1) {
			stationaryEntity = getEntity(world, x);
		}

		switch (ID) {
		case (GuiIDs.CRAFTER_TIER_I):
			return te instanceof TileCrafterTierI ? new ContainerTier(player.inventory, (TileCrafterTierI) te) : null;
		case (GuiIDs.CRAFTER_TIER_II):
			return te instanceof TileCrafterTierII ? new ContainerTier(player.inventory, (TileCrafterTierII) te) : null;
		case (GuiIDs.CRAFTER_TIER_III):
			return te instanceof TileCrafterTierIII ? new ContainerTier(player.inventory, (TileCrafterTierIII) te) : null;
		case (GuiIDs.DISTIL):
			return te instanceof TileEntityDistil ? new ContainerDistil(player.inventory, (TileEntityDistil) te) : null;
		case (GuiIDs.GENERATOR_DIESEL):
			return te instanceof TileGeneratorDiesel ? new ContainerGeneratorDiesel(player.inventory, (TileGeneratorDiesel) te) : null;
		case (GuiIDs.OPEN_HEARTH_FURNACE):
			return te instanceof TileEntityOpenHearthFurnace ? new ContainerOpenHearthFurnace(player.inventory, (TileEntityOpenHearthFurnace) te) : null;
		case (GuiIDs.TRAIN_WORKBENCH):
			return te instanceof TileTrainWbench ? new ContainerTrainWorkbench(player.inventory, player.getEntityWorld(), (TileTrainWbench) te) : null;
		case (GuiIDs.LOCO):
			return new InventoryLoco(player.inventory, (EntityRollingStock) ridingEntity);
		case (GuiIDs.FORNEY):
			return new InventoryForney(player.inventory, (EntityRollingStock) ridingEntity);
		case (GuiIDs.CRAFTING_CART):
			return new ContainerWorkbenchCart(player.inventory, player.getEntityWorld());
		case (GuiIDs.FURNACE_CART):
			return new InventoryWorkCart(player.inventory, ridingEntity);
		case (GuiIDs.ZEPPELIN):
			return new InventoryZepp(player.inventory, (AbstractZeppelin) ridingEntity);
		case (GuiIDs.DIGGER):
			return new InventoryRotativeDigger(player.inventory, (EntityRotativeDigger) ridingEntity);
		case (GuiIDs.FREIGHT):
			//System.out.println("Freight: " + ID + " | " + stationaryEntity.getEntityName() + " | " + x + ":" + y + ":" + z);
			return stationaryEntity instanceof Freight ? new InventoryFreight(player.inventory, (Freight) stationaryEntity) : null;
		case (GuiIDs.JUKEBOX):
			return stationaryEntity instanceof EntityJukeBoxCart ? new InventoryJukeBoxCart(player.inventory, (EntityJukeBoxCart) stationaryEntity) : null;
		case (GuiIDs.TENDER):
			return stationaryEntity instanceof Tender ? new InventoryTender(player.inventory, (Tender) stationaryEntity) : null;
		case (GuiIDs.BUILDER):
			return stationaryEntity instanceof EntityTracksBuilder ? new InventoryBuilder(player.inventory, (EntityTracksBuilder) stationaryEntity) : null;
		case (GuiIDs.LIQUID):
			return stationaryEntity instanceof LiquidTank ? new InventoryLiquid(player.inventory, (LiquidTank) stationaryEntity) : null;
		default:
			return null;
		}*/
		return null;
	}

	//@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public static Entity getEntity(World world, int entityId) {
		if ((world != null) && (world instanceof WorldServer)) {
			return world.getEntityByID(entityId);
		}
		return null;
	}

	public int addArmor(String armor) {
		return 0;
	}

	public Minecraft getClientInstance() {
		return FMLClientHandler.instance().getClient();
	}

	public GuiScreen getCurrentScreen() {
		return null;
	}

	public void registerTextureFX() {}

	public void registerSounds() {}

	public void registerBookHandler() {}

	public Minecraft getMinecraft() {
		return null;
	}

	public void registerVillagerSkin(int villagerId, String textureName) {}

	public static void killAllStreams() {
		for (MP3Player p : playerList) {
			p.stop();
		}
	}

	public void openadmingui(String data){}

	public static boolean checkJukeboxEntity(World world, int id) {
		return  world.getEntityByID(id)!=null;
	}

	public void doNEICheck(ItemStack stack) {}

	public EntityPlayer getPlayer() {
		return null;
	}

	public float getJukeboxVolume() {
		return 0;
	}

	public void registerKeyBindingHandler() {}

	public void setHook() {}
	
}