package mod.chemlab.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityAtomSplitter extends TileEntity implements IInventory {

	private ItemStack[] inventory;

	public TileEntityAtomSplitter() {
		inventory = new ItemStack[4];
	}

	@Override
	public int getSizeInventory() {
		return this.inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int stackIndex) {
		return this.inventory[stackIndex];
	}

	@Override
	public ItemStack decrStackSize(int stackIndex, int stackSize) {
		if (this.inventory[stackIndex] != null) {
			ItemStack guiItemStack;

			if (this.inventory[stackIndex].stackSize <= stackSize) {
				guiItemStack = this.inventory[stackIndex];
				this.inventory[stackIndex] = null;
				return guiItemStack;
			} else {
				guiItemStack = this.inventory[stackIndex].splitStack(stackSize);

				if (this.inventory[stackIndex].stackSize == 0) {
					this.inventory[stackIndex] = null;
				}

				return guiItemStack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int stackIndex) {
		if (this.inventory[stackIndex] != null) {
			ItemStack guiItemStack = this.inventory[stackIndex];
			this.inventory[stackIndex] = null;
			return guiItemStack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int stackIndex, ItemStack itemStack) {
		this.inventory[stackIndex] = itemStack;

		if (itemStack != null
				&& itemStack.stackSize > this.getInventoryStackLimit()) {
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "container.atom_splitter";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord,
				this.zCoord) != this ? false : player.getDistanceSq(
				(double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
				(double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory");
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inventory.length) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inventory.length; i++) {
			ItemStack stack = inventory[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
	}

	@Override
	public void updateEntity() {
		splitItem();
	}

	private boolean canSplit() {
		if (inventory[0] == null || inventory[1] != null || inventory[2] != null || inventory[3] != null) {
			return false;
		} else {
			return true;
		}
	}

	private void splitItem() {
		if (canSplit()) {
			this.inventory[1] = new ItemStack(ChemLab.proton, 64);
			this.inventory[2] = new ItemStack(ChemLab.nuetron, 64);
			this.inventory[3] = new ItemStack(ChemLab.electron, 64);

			--this.inventory[0].stackSize;

			if (this.inventory[0].stackSize <= 0) {
				this.inventory[0] = null;
			}
		}
	}

	@Override
	public boolean func_94042_c() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean func_94041_b(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}
}
