package com.pheeeantom.hardcore_farming.common.handler;

import com.pheeeantom.hardcore_farming.common.item.ScytheItem;
import com.pheeeantom.hardcore_farming.common.item.WateringCanItem;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    public static final WateringCanItem WATERING_CAN = new WateringCanItem();
    public static final ScytheItem SCYTHE = new ScytheItem(Item.ToolMaterial.IRON);

    public static void register() {
        GameRegistry.registerItem(WATERING_CAN, "watering_can");
        GameRegistry.registerItem(SCYTHE, "scythe");
    }
}
