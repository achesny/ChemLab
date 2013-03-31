package mod.chemlab.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;

public class FuserRecipes {

	private List<IRecipe> recipes;
	
	FuserRecipes() {
		recipes = new ArrayList();
        this.addRecipe(new ItemStack(ChemLab.hydrogen, 1),1,0,1);
        this.addRecipe(new ItemStack(ChemLab.helium, 1),2,1,2);
        this.addRecipe(new ItemStack(ChemLab.nobelium, 1),102,93,102);
	}

    public void addRecipe(ItemStack itemStack, int protons, int nuetrons, int electrons)
    {
        AtomRecipe atomRecipe = new AtomRecipe(itemStack, protons, nuetrons, electrons);
        this.recipes.add(atomRecipe);
    }

	public ItemStack findMatchingRecipe(InventoryCrafting inventoryCrafting) {
		for (IRecipe irecipe : this.recipes) {
			if (irecipe.matches(inventoryCrafting, null)) {
				return irecipe.getCraftingResult(inventoryCrafting);
			}
		}

		return null;
	}

    public List getRecipeList()
    {
        return this.recipes;
    }

}
