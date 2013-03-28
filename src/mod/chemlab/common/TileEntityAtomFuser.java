package mod.chemlab.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityAtomFuser extends TileEntity implements IInventory {

	private ItemStack[] inventory;
	private IInventory craftResult;

	public TileEntityAtomFuser() {
		inventory = new ItemStack[10];
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
		return "container.atom_fuser";
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
		fuseItem();
	}

	private boolean canFuse() {
		if (inventory[0] == null || !inventory[0].isItemEqual(new ItemStack(ChemLab.proton))) {
			return false;
		}
		if (inventory[1] != null && !inventory[1].isItemEqual(new ItemStack(ChemLab.nuetron))) {
			return false;
		}
		for (int i=0;i<6;i++) {
			if (inventory[2+i] != null && !inventory[2+i].isItemEqual(new ItemStack(ChemLab.electron))) {
				return false;
			}
		}
		return true;
	}

	private void fuseItem() {
		FuserRecipes recipes = ChemLab.getFuserRecipes();
		if (canFuse()) {
			List<Integer> electrons = new ArrayList<Integer>();
			for (int i=0;i<6;i++) {
				if (inventory[2+i] != null && inventory[2+i].stackSize > 0) {
					electrons.add(inventory[2+i].stackSize);
				}
			}
			
			int nuetrons = 0;
			if (inventory[1] != null) {
				nuetrons = inventory[1].stackSize;
			}
			AtomRecipe atomRecipe = new AtomRecipe(null, inventory[0].stackSize, nuetrons, (Integer[])electrons.toArray(new Integer[0]));
			Item itemForRecipe = recipes.getItemForRecipe(atomRecipe);
			if (itemForRecipe != null) {
				ItemStack outputItem = new ItemStack(itemForRecipe);
				if (outputItem != null && inventory[9] == null) {
					craftResult.setInventorySlotContents(0, outputItem.copy());
				} 
			} else {
				craftResult.setInventorySlotContents(0, null);
			}
		}
	}
	
	public void setCraftResult(IInventory craftResult) {
		this.craftResult = craftResult;
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
