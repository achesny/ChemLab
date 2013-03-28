package mod.chemlab.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

public class ContainerAtomFuser extends Container {

	protected TileEntityAtomFuser tileEntity;
	public IInventory craftResult;

	public ContainerAtomFuser(InventoryPlayer inventoryPlayer,
			TileEntityAtomFuser te) {
		tileEntity = te;
		craftResult = new InventoryCraftResult();
		te.setCraftResult(craftResult);

		// the Slot constructor takes the IInventory and the slot number in that
		// it binds to
		// and the x-y coordinates it resides on-screen
		addSlotToContainer(new Slot(tileEntity, 0, 64, 8));
		addSlotToContainer(new Slot(tileEntity, 1, 96, 8));
		addSlotToContainer(new Slot(tileEntity, 2, 8, 32));
		addSlotToContainer(new Slot(tileEntity, 3, 32, 32));
		addSlotToContainer(new Slot(tileEntity, 4, 56, 32));
		addSlotToContainer(new Slot(tileEntity, 5, 80, 32));
		addSlotToContainer(new Slot(tileEntity, 6, 104, 32));
		addSlotToContainer(new Slot(tileEntity, 7, 128, 32));
		addSlotToContainer(new SlotAtomFuser(inventoryPlayer.player, tileEntity,
				craftResult, 0, 80, 57));
		// addSlotToContainer(new Slot(tileEntity, 8, 152, 32));

		// commonly used vanilla code that adds the player's inventory
		bindPlayerInventory(inventoryPlayer);

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileEntity.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
						8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		ItemStack stack = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);

		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slot != null && slot.getHasStack()) {
			ItemStack stackInSlot = slot.getStack();
			stack = stackInSlot.copy();

			// merges the item into player inventory since its in the tileEntity
			if (slotIndex < 8) {
				if (!this.mergeItemStack(stackInSlot, 8, 45, true)) {
					return null;
				}
			} else if (slotIndex == 8) {
				if (!this.mergeItemStack(stackInSlot, 9, 45, true)) {
					return null;
				}

				slot.onSlotChange(stackInSlot, stack);
			}

			if (stackInSlot.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slot.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}
}
