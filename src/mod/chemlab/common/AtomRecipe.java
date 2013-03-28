package mod.chemlab.common;

import net.minecraft.item.Item;

public class AtomRecipe {
	
	private int protons;
	private int nuetrons;
	private Integer[] electrons;
	private Item atomItem;
	
	AtomRecipe(Item atomItem, int protons, int nuetrons, Integer[] electrons) {
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

	public Integer[] getElectrons() {
		return electrons;
	}

	public void setElectrons(Integer[] electrons) {
		this.electrons = electrons;
	}

	public Item getItem() {
		return atomItem;
	}

	public void setItem(Item atomItem) {
		this.atomItem = atomItem;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof AtomRecipe) {
			AtomRecipe atom = (AtomRecipe)o;
			if (protons == atom.getProtons() && nuetrons == atom.getNuetrons()) {
				if (electrons.length != atom.getElectrons().length) {
					return false;
				}
				for (int i=0;i<electrons.length;i++) {
					if (electrons[i] != atom.getElectrons()[i]) {
						return false;
					}
				}
				for (int i=0;i<atom.getElectrons().length;i++) {
					if (electrons[i] != atom.getElectrons()[i]) {
						return false;
					}
				}
				return true;
			}
		}			
		return false;
	}
}
