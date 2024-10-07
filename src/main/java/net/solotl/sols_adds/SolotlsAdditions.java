package net.solotl.sols_adds;

import net.fabricmc.api.ModInitializer;

import net.solotl.sols_adds.block.ModBlocks;
import net.solotl.sols_adds.item.ModItems;
import net.solotl.sols_adds.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolotlsAdditions implements ModInitializer {
	public static final String MOD_ID = "sols_adds";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGeneration();
	}

}