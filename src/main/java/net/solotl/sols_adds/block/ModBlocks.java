package net.solotl.sols_adds.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MossBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.solotl.sols_adds.SolotlsAdditions;

public class ModBlocks {
    public static final Block SOUL_SHALE = registerBlock("soul_shale",
            new Block(FabricBlockSettings.copyOf(Blocks.BASALT)));
    
    public static final Block SPHAGNUM_MOSS = registerBlock("sphagnum_moss",
            new MossBlock(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK)));




private static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return  Registry.register(Registries.BLOCK, new Identifier(SolotlsAdditions.MOD_ID,name), block);
}
private static Item registerBlockItem(String name, Block block) {
    return Registry.register(Registries.ITEM, new Identifier(SolotlsAdditions.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
}

public static void registerModBlocks() {
    SolotlsAdditions.LOGGER.info("Registering ModBlocks for " + SolotlsAdditions.MOD_ID);
}
}
