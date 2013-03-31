package mod.chemlab.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerAtomFuser extends ContainerWorkbench {
	
	private World worldObj;
	private InventoryPlayer inventoryPlayer;
	int objX;
	int objY;
	int objZ;
	private FuserRecipes fuserRecipes = new FuserRecipes();

	public ContainerAtomFuser(InventoryPlayer inventoryPlayer, World world, int objX, int objY, int objZ) {
		super(inventoryPlayer, world, objX, objY, objZ);
		this.worldObj = world;
		this.objX = objX;
		this.objY = objY;
		this.objZ = objZ;
		this.inventoryPlayer = inventoryPlayer;
		
		craftResult = new InventoryCraftResult();

		this.inventorySlots.set(0, new SlotAtomFuser(inventoryPlayer.player, craftMatrix, craftResult, 0, 124, 35));
	}

	@Override
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
		if (fuserRecipes == null) {
			fuserRecipes = new FuserRecipes();
		}
        this.craftResult.setInventorySlotContents(0, fuserRecipes.findMatchingRecipe(this.craftMatrix));
    }
    
	@Override
	public boolean canInteractWith(EntityPlayer player) {
        return this.worldObj.getBlockId(this.objX, this.objY, this.objZ) != BlockAtomFuser.blockID ? false : player.getDistanceSq((double)this.objX + 0.5D, (double)this.objY + 0.5D, (double)this.objZ + 0.5D) <= 64.0D;
	}

}
