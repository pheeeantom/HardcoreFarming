package com.pheeeantom.hardcore_farming.common.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void registerRecipes() {
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.WATERING_CAN),
                "S  ", "SBS", " S ",
                'B', Items.bucket,
                'S', Items.iron_ingot);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.SCYTHE),
                "II ", " SS", " S ",
                'I', Items.iron_ingot,
                'S', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.WATERING_CAN),
                "  S", "SBS", " S ",
                'B', Items.bucket,
                'S', Items.iron_ingot);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.SCYTHE),
                " II", "SS ", " S ",
                'I', Items.iron_ingot,
                'S', Items.stick);
    }
}
