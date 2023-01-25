package com.pheeeantom.hardcore_farming.common.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void registerRecipes() {
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.WATERING_CAN),
                "S  ", "SBS", " S ",
                'B', Items.bucket,
                'S', Items.iron_ingot);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.WATERING_CAN),
                "  S", "SBS", " S ",
                'B', Items.bucket,
                'S', Items.iron_ingot);
        
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.WOODEN_SCYTHE),
                "WW ", " SS", " S ",
                'W', Blocks.planks,
                'S', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.WOODEN_SCYTHE),
                " WW", "SS ", " S ",
                'W', Blocks.planks,
                'S', Items.stick);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.STONE_SCYTHE),
                "TT ", " SS", " S ",
                'T', Blocks.cobblestone,
                'S', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.STONE_SCYTHE),
                " TT", "SS ", " S ",
                'T', Blocks.cobblestone,
                'S', Items.stick);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.IRON_SCYTHE),
                "II ", " SS", " S ",
                'I', Items.iron_ingot,
                'S', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.IRON_SCYTHE),
                " II", "SS ", " S ",
                'I', Items.iron_ingot,
                'S', Items.stick);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GOLDEN_SCYTHE),
                "GG ", " SS", " S ",
                'G', Items.gold_ingot,
                'S', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GOLDEN_SCYTHE),
                " GG", "SS ", " S ",
                'G', Items.gold_ingot,
                'S', Items.stick);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.DIAMOND_SCYTHE),
                "DD ", " SS", " S ",
                'D', Items.diamond,
                'S', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.DIAMOND_SCYTHE),
                " DD", "SS ", " S ",
                'D', Items.diamond,
                'S', Items.stick);
    }
}
