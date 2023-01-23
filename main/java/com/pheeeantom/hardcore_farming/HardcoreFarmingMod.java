package com.pheeeantom.hardcore_farming;

import com.pheeeantom.hardcore_farming.common.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = HardcoreFarmingMod.MODID, version = HardcoreFarmingMod.VERSION)
public class HardcoreFarmingMod
{
    public static final String MODID = "hardcorefarming";
    public static final String VERSION = "0.1";
    
    @SidedProxy(
            clientSide = "com.pheeeantom.hardcore_farming.client.ClientProxy",
            serverSide = "com.pheeeantom.hardcore_farming.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
