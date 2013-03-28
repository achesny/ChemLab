package mod.chemlab.client;

import net.minecraftforge.client.MinecraftForgeClient;
import mod.chemlab.common.CommonProxyChemLab;

public class ClientProxyChemLab extends CommonProxyChemLab{

	@Override
	public void registerRenderThings(){
		MinecraftForgeClient.preloadTexture("/mod/chemlab/chemlab.png");
	}

}
