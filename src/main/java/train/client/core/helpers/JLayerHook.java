package train.client.core.helpers;

import java.io.IOException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerHook;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import train.common.Traincraft;

public class JLayerHook implements JavaLayerHook {
	private final Minecraft mc;
	public JLayerHook(Minecraft mc) {
		this.mc = mc;
	}

	@Override
	public InputStream getResourceAsStream(String name) {
		try {
			return mc.getResourceManager().getResource(new ResourceLocation(Traincraft.MOD_ID, "jlayer/" + name)).getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
