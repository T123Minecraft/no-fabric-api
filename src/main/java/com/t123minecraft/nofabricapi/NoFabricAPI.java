package com.t123minecraft.nofabricapi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoFabricAPI implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("nofabricapi");

	private static final String TARGET_MOD_ID = "fabric-api";

	@Override
	public void onInitialize() {
		if (FabricLoader.getInstance().isModLoaded(TARGET_MOD_ID)) {
			LOGGER.error("Incompatible mod [{}] detected, game will force stop! Do not install Fabric API", TARGET_MOD_ID);

			throw new RuntimeException("Severe incompatibility error: This mod cannot run with [" + TARGET_MOD_ID + "]. Do not install Fabric API");
		}

		LOGGER.info("It's OK.");
	}
}
