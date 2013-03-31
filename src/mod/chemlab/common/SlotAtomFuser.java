package mod.chemlab.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

public class SlotAtomFuser extends SlotCrafting {

	public SlotAtomFuser(EntityPlayer player, IInventory craftInventory, IInventory craftResult, int slotIndex, int pos_x, int pos_y) {
		super(player, craftInventory, craftResult, slotIndex, pos_x, pos_y);
	}

	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack) {
        GameRegistry.onItemCrafted(player, itemStack, craftMatrix);
        this.onCrafting(itemStack);

        for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i)
        {
        	ItemStack stackInSlot = craftMatrix.getStackInSlot(i);
			if (stackInSlot != null) {
        		stackInSlot = craftMatrix.decrStackSize(i, stackInSlot.stackSize);
        	}
        }

	}
}
