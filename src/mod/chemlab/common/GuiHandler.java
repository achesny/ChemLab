package mod.chemlab.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiHandler implements IGuiHandler {
	// returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityAtomSplitter) {
			return new ContainerAtomSplitter(player.inventory,
					(TileEntityAtomSplitter) tileEntity);
		}
		int blockId = world.getBlockId(x, y, z);
		if (blockId == ChemLab.atomFuser.blockID) {
			return new ContainerAtomFuser(player.inventory, world, x, y, z);
		}
		return null;
	}

	// returns an instance of the Gui you made earlier
    @SideOnly(Side.CLIENT)
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		int blockId = world.getBlockId(x, y, z);
		if (tileEntity instanceof TileEntityAtomSplitter) {
			return new GuiAtomSplitter(player.inventory,(TileEntityAtomSplitter) tileEntity);
		}
		if (blockId == ChemLab.atomFuser.blockID) {
			return new GuiAtomFuser(player.inventory, world, x, y, z);
		}
		return null;

	}
}