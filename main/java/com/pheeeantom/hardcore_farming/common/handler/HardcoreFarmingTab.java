package com.pheeeantom.hardcore_farming.common.handler;

import com.pheeeantom.hardcore_farming.HardcoreFarmingMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HardcoreFarmingTab extends CreativeTabs {

	public static final HardcoreFarmingTab INSTANCE = new HardcoreFarmingTab();
	
	private HardcoreFarmingTab() {
		super(HardcoreFarmingMod.MODID);
	}

	@Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ModItems.SCYTHE;
    }

}
