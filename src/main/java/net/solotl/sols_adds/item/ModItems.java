package net.solotl.sols_adds.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.solotl.sols_adds.SolotlsAdditions;
import net.solotl.sols_adds.block.ModBlocks;

public class ModItems {
    public static final Item BANANA = registerItem("banana",
            new Item(new FabricItemSettings()));






    private static Item registerItem(String name, Item item ) {
        return Registry.register(Registries.ITEM, new Identifier(SolotlsAdditions.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(BANANA);
        entries.add(ModBlocks.SOUL_SHALE);
    }
    public static void registerModItems() {
        SolotlsAdditions.LOGGER.info("Registering Mod Items for " + SolotlsAdditions.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}