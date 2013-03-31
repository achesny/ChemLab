package mod.chemlab.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AtomRecipe implements IRecipe{
	
	private int protons;
	private int nuetrons;
	private int electrons;
	private ItemStack atomItem;
	
	AtomRecipe(ItemStack atomItem, int protons, int nuetrons, int electrons) {
		this.setProtons(protons);
		this.setNuetrons(nuetrons);
		this.setElectrons(electrons);
		this.setItem(atomItem);
	}

	public int getProtons() {
		return protons;
	}

	public void setProtons(int protons) {
		this.protons = protons;
	}

	public int getNuetrons() {
		return nuetrons;
	}

	public void setNuetrons(int nuetrons) {
		this.nuetrons = nuetrons;
	}

	public int getElectrons() {
		return electrons;
	}

	public void setElectrons(int electrons) {
		this.electrons = electrons;
	}

	public ItemStack getItem() {
		return atomItem;
	}

	public void setItem(ItemStack atomItem) {
		this.atomItem = atomItem;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof AtomRecipe) {
			AtomRecipe atom = (AtomRecipe)o;
			if (protons == atom.getProtons() && nuetrons == atom.getNuetrons() && electrons == atom.electrons) {
				return true;
			}
		}			
		return false;
	}

	@Override
	public boolean matches(InventoryCrafting inventorycrafting, World world) {
		int protonCount = 0;
		int nuetronCount = 0;
		int electronCount = 0;
		for (int i = 0; i<9; i++) {
			ItemStack itemStack = inventorycrafting.getStackInSlot(i);
			if (itemStack != null) {
				if (i < 3) {
					protonCount += itemStack.stackSize;
				} else if (i >= 3 && i < 6) {
					nuetronCount += itemStack.stackSize;
				} else {
					electronCount += itemStack.stackSize;
				}
			}
		}
		
		return this.equals(new AtomRecipe(null, protonCount, nuetronCount, electronCount));
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) {
		return this.atomItem.copy();
	}

	@Override
	public int getRecipeSize() {
		return 1;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.atomItem;
	}
}
