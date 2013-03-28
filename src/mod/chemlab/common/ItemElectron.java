package mod.chemlab.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemElectron extends Item {

	public ItemElectron(int itemId) {
		super(itemId);
		this.setCreativeTab(CreativeTabs.tabRedstone);
	}

	public String getTextureFile() {
		return "/mod/chemlab/chemlab.png";
	}

	public void func_94581_a(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.func_94245_a("chemLab:electron");
	}
}
