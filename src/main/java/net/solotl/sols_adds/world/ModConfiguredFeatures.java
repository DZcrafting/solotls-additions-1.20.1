package net.solotl.sols_adds.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.solotl.sols_adds.SolotlsAdditions;
import net.solotl.sols_adds.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> TESTTREE_KEY = registerKey("testtree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SOUL_SHALE_BLOB_KEY = registerKey("soul_shale_blob");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest soulSoilReplaceables = new BlockMatchRuleTest(Blocks.SOUL_SOIL);
        RuleTest soulSandReplaceables = new BlockMatchRuleTest(Blocks.SOUL_SAND);


        List<OreFeatureConfig.Target> netherSoulShale =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.SOUL_SHALE.getDefaultState()),
                        OreFeatureConfig.createTarget(soulSoilReplaceables, ModBlocks.SOUL_SHALE.getDefaultState()),
                        OreFeatureConfig.createTarget(soulSandReplaceables, ModBlocks.SOUL_SHALE.getDefaultState()));


        register(context, TESTTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SOUL_SHALE),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.SPHAGNUM_MOSS),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, SOUL_SHALE_BLOB_KEY, Feature.ORE, new OreFeatureConfig(netherSoulShale, 64));
    }










    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SolotlsAdditions.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
