package mod.chemlab.common;

import java.util.Random;

import mod.chemlab.BlockSide;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockAtomSplitter extends BlockContainer {
	
	private Icon frontIcon;
	private Icon sideIcon;
	private Icon topIcon;
	private Icon bottomIcon;

	public BlockAtomSplitter(int blockId) {
		super(blockId, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public String getTextureFile() {
		return "/mod/chemlab/chemlab.png";

	}

	public void func_94332_a(IconRegister iconRegister)
	{
	         this.frontIcon = iconRegister.func_94245_a("chemLab:splitter_front");
	         this.sideIcon = iconRegister.func_94245_a("chemLab:splitter_side");
	         this.topIcon = iconRegister.func_94245_a("chemLab:splitter_top");
	         this.bottomIcon = iconRegister.func_94245_a("chemLab:splitter_bottom");
	}

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
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAtomSplitter();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int idk, float what, float these, float are) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking()) {
			return false;
		}
		player.openGui(ChemLab.instance, 0, world, x, y, z);
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	private void dropItems(World world, int x, int y, int z) {
		Random rand = new Random();

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (!(tileEntity instanceof IInventory)) {
			return;
		}
		IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0) {
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z
						+ rz, new ItemStack(item.itemID, item.stackSize,
						item.getItemDamage()));

				if (item.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound(
							(NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}

}
