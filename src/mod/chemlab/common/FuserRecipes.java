package mod.chemlab.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuserRecipes {

	Map<Integer, AtomRecipe> recipeMap;
	
	FuserRecipes() {
		recipeMap = new HashMap<Integer, AtomRecipe>();
	}
	
	public void addRecipe(int itemId, AtomRecipe recipe) {
		recipeMap.put(itemId, recipe);
	}

	public AtomRecipe getRecipe(int itemId) {
		return recipeMap.get(itemId);
	}
	
	public Item getItemForRecipe(AtomRecipe recipe) {
		for (Entry<Integer, AtomRecipe> recipeEntry: recipeMap.entrySet()) {
			AtomRecipe fuserRecipe = recipeEntry.getValue();
			if (fuserRecipe.equals(recipe)) {
				return fuserRecipe.getItem();
			}
		}
		return null;
	}

}
