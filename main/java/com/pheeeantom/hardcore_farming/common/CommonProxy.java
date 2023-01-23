package com.pheeeantom.hardcore_farming.common;

import com.pheeeantom.hardcore_farming.common.handler.FMLEventListener;
import com.pheeeantom.hardcore_farming.common.handler.ModBlocks;
import com.pheeeantom.hardcore_farming.common.handler.ModItems;
import com.pheeeantom.hardcore_farming.common.handler.ModRecipes;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
    	FMLEventListener listener = new FMLEventListener();
    	FMLCommonHandler.instance().bus().register(listener);
    	MinecraftForge.EVENT_BUS.register(listener);
    	ModItems.register();
    	ModBlocks.register();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {
    	ModRecipes.registerRecipes();
    }
}
