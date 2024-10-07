package net.solotl.sols_adds.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.solotl.sols_adds.world.ModPlacedFeatures;

public class ModOreGeneration {
    public static void generateOres() {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SOUL_SAND_VALLEY),
                    GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.SOUL_SHALE_PLACED_KEY);}
    }
