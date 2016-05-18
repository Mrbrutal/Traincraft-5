package si.meansoft.traincraft.tile.crafter;

import si.meansoft.traincraft.blocks.BlockCrafter;

public class TileEntityCrafterElectro extends TileEntityCrafterBase{

    public TileEntityCrafterElectro(){
        super("crafterElectro");
    }

    @Override
    public BlockCrafter.CrafterTier getTier(){
        return BlockCrafter.CrafterTier.ELECTRO;
    }
}
