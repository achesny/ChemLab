package mod.chemlab.common;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mod.chemlab.BlockSide;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockAtomFuser extends BlockWorkbench{

    @SideOnly(Side.CLIENT)
	private Icon frontIcon;
    @SideOnly(Side.CLIENT)
	private Icon sideIcon;
    @SideOnly(Side.CLIENT)
	private Icon topIcon;
    @SideOnly(Side.CLIENT)
	private Icon bottomIcon;
	public static int blockID;
	
	public BlockAtomFuser(int blockId) {
		super(blockId);
		blockID = blockId;
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public String getTextureFile() {
		return "/mod/chemlab/chemlab.png";
	}

    @SideOnly(Side.CLIENT)
	public void func_94332_a(IconRegister iconRegister)
	{
	         this.frontIcon = iconRegister.func_94245_a("chemLab:fuser_front");
	         this.sideIcon = iconRegister.func_94245_a("chemLab:fuser_side");
	         this.topIcon = iconRegister.func_94245_a("chemLab:fuser_top");
	         this.bottomIcon = iconRegister.func_94245_a("chemLab:fuser_bottom");
	}

    @SideOnly(Side.CLIENT)
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int sideIndex, int metadata) {
		BlockSide side = BlockSide.valueOf(sideIndex);
		switch (side) {
		case FRONT:
			return frontIcon;
		case TOP:
			return topIcon;
		case BOTTOM:
			return bottomIcon;
		default:
			return sideIcon;
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int idk, float what, float these, float are) {
		if (player.isSneaking()) {
			return false;
		}
		player.openGui(ChemLab.instance, 0, world, x, y, z);
		return true;
	}

}
