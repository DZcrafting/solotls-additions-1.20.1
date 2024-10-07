package net.solotl.sols_adds.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.solotl.sols_adds.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class TestTreeSaplingGenerator extends SaplingGenerator {
    @Override
    @Nullable
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.TESTTREE_KEY;
    }
}
