package com.pheeeantom.hardcore_farming.common.handler;

import com.pheeeantom.hardcore_farming.common.block.WeedBlock;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static final WeedBlock WEED = new WeedBlock();

    public static void register() {
        GameRegistry.registerBlock(WEED, "weed");
    }
}