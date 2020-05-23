package traincraft.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import train.common.Traincraft;

public class ItemChunkLoaderActivator extends Item {

	public ItemChunkLoaderActivator() {
		this.setRegistryName(Traincraft.MOD_ID, "chunk_loader_activator");
		
		this.maxStackSize = 1;
		this.setCreativeTab(Traincraft.TAB);
		this.setMaxDamage(10);
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00a77" + "Right click on a Locomotive");
		tooltip.add("\u00a77" + " to start/stop chunk loading.");
		tooltip.add("\u00a77" + "Locomotives will load chunks");
		tooltip.add("\u00a77" + "around attached carts.");
	}
	
}
