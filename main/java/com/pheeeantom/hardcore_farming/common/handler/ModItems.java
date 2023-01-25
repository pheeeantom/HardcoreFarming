package com.pheeeantom.hardcore_farming.common.handler;

import com.pheeeantom.hardcore_farming.common.block.WeedBlock;
import com.pheeeantom.hardcore_farming.common.item.ScytheItem;
import com.pheeeantom.hardcore_farming.common.item.WateringCanItem;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    public static final WateringCanItem WATERING_CAN = new WateringCanItem();
    public static final ScytheItem WOODEN_SCYTHE = new ScytheItem(Item.ToolMaterial.WOOD, "wooden_scythe");
    public static final ScytheItem STONE_SCYTHE = new ScytheItem(Item.ToolMaterial.STONE, "stone_scythe");
    public static final ScytheItem IRON_SCYTHE = new ScytheItem(Item.ToolMaterial.IRON, "iron_scythe");
    public static final ScytheItem GOLDEN_SCYTHE = new ScytheItem(Item.ToolMaterial.GOLD, "golden_scythe");
    public static final ScytheItem DIAMOND_SCYTHE = new ScytheItem(Item.ToolMaterial.EMERALD, "diamond_scythe");

    public static void register() {
        GameRegistry.registerItem(WATERING_CAN, "watering_can");
        GameRegistry.registerItem(WOODEN_SCYTHE, "wooden_scythe");
        GameRegistry.registerItem(STONE_SCYTHE, "stone_scythe");
        GameRegistry.registerItem(IRON_SCYTHE, "iron_scythe");
        GameRegistry.registerItem(GOLDEN_SCYTHE, "golden_scythe");
        GameRegistry.registerItem(DIAMOND_SCYTHE, "diamond_scythe");
    }
}
