package com.pheeeantom.hardcore_farming.common.item;

import java.util.Set;

import com.google.common.collect.Sets;
import com.pheeeantom.hardcore_farming.HardcoreFarmingMod;
import com.pheeeantom.hardcore_farming.common.block.WeedBlock;
import com.pheeeantom.hardcore_farming.common.handler.HardcoreFarmingTab;
import com.pheeeantom.hardcore_farming.common.handler.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ScytheItem extends ItemTool {

	//private static final Set field_150917_c = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});
	private static final Set field_150917_c = Sets.newHashSet(new Block[] {});

    public ScytheItem(Item.ToolMaterial p_i45327_1_) {
        super(3.0F, p_i45327_1_, field_150917_c);
        setUnlocalizedName("scythe");
        setTextureName(HardcoreFarmingMod.MODID + ":scythe");
        //setCreativeTab(ModTab.INSTANCE);

        setHarvestLevel("scythe", p_i45327_1_.getHarvestLevel());
        
        //setMaxDamage(100);
        
        setCreativeTab(HardcoreFarmingTab.INSTANCE);
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
        //return p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    	return p_150893_2_.getMaterial() == Material.vine ? 1000.0F : 0.0F;
    }
    
    public boolean isDamageable() {
    	return true;
    }
    
    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
        p_150894_1_.damageItem(5, p_150894_7_);

        return true;
    }
    
    /*public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
    	if (!p_150894_2_.isRemote) {
	    	System.out.println("onBlockDestroyed");
	    	if (p_150894_2_.getBlock(p_150894_4_ - 1, p_150894_5_, p_150894_6_) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ - 1, p_150894_5_, p_150894_6_);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ + 1, p_150894_5_, p_150894_6_) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ + 1, p_150894_5_, p_150894_6_);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ - 1, p_150894_5_, p_150894_6_ - 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_ - 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_ - 1, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ - 1, p_150894_5_, p_150894_6_ - 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ - 1, p_150894_5_, p_150894_6_ + 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_ + 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_ + 1, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ - 1, p_150894_5_, p_150894_6_ + 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ + 1, p_150894_5_, p_150894_6_ - 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_ - 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_ - 1, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ + 1, p_150894_5_, p_150894_6_ - 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ + 1, p_150894_5_, p_150894_6_ + 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_ + 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_ + 1, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ + 1, p_150894_5_, p_150894_6_ + 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_, p_150894_5_, p_150894_6_ - 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_ - 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_ - 1, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_, p_150894_5_, p_150894_6_ - 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_, p_150894_5_, p_150894_6_ + 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_ + 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_ + 1, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_, p_150894_5_, p_150894_6_ + 1);
	    		System.out.println("break");
	    	}
    	}
    	return false;
    }*/
    
    /*public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
    	System.out.println("onBlockDestroyed");
    	System.out.println(itemstack != null);
    	System.out.println(itemstack.getItem() != null);
    	if (player.worldObj.getBlock(X, Y, Z) instanceof WeedBlock) {
	    	if (player.worldObj.getBlock(X - 1, Y, Z) instanceof WeedBlock) {
	    		player.worldObj.getBlock(X - 1, Y, Z).dropBlockAsItem(player.worldObj, X - 1, Y, Z, player.worldObj.getBlockMetadata(X - 1, Y, Z), 0);
	    		player.worldObj.setBlockToAir(X - 1, Y, Z);
	    		System.out.println("break");
	    	}
	    	if (player.worldObj.getBlock(X + 1, Y, Z) instanceof WeedBlock) {
	    		player.worldObj.getBlock(X + 1, Y, Z).dropBlockAsItem(player.worldObj, X + 1, Y, Z, player.worldObj.getBlockMetadata(X + 1, Y, Z), 0);
	    		player.worldObj.setBlockToAir(X + 1, Y, Z);
	    		System.out.println("break");
	    	}
	    	if (player.worldObj.getBlock(X - 1, Y, Z - 1) instanceof WeedBlock) {
	    		player.worldObj.getBlock(X - 1, Y, Z - 1).dropBlockAsItem(player.worldObj, X - 1, Y, Z - 1, player.worldObj.getBlockMetadata(X - 1, Y, Z - 1), 0);
	    		player.worldObj.setBlockToAir(X - 1, Y, Z - 1);
	    		System.out.println("break");
	    	}
	    	if (player.worldObj.getBlock(X - 1, Y, Z + 1) instanceof WeedBlock) {
	    		player.worldObj.getBlock(X - 1, Y, Z + 1).dropBlockAsItem(player.worldObj, X - 1, Y, Z + 1, player.worldObj.getBlockMetadata(X - 1, Y, Z + 1), 0);
	    		player.worldObj.setBlockToAir(X - 1, Y, Z + 1);
	    		System.out.println("break");
	    	}
	    	if (player.worldObj.getBlock(X + 1, Y, Z - 1) instanceof WeedBlock) {
	    		player.worldObj.getBlock(X + 1, Y, Z - 1).dropBlockAsItem(player.worldObj, X + 1, Y, Z - 1, player.worldObj.getBlockMetadata(X + 1, Y, Z - 1), 0);
	    		player.worldObj.setBlockToAir(X + 1, Y, Z - 1);
	    		System.out.println("break");
	    	}
	    	if (player.worldObj.getBlock(X + 1, Y, Z + 1) instanceof WeedBlock) {
	    		player.worldObj.getBlock(X + 1, Y, Z + 1).dropBlockAsItem(player.worldObj, X + 1, Y, Z + 1, player.worldObj.getBlockMetadata(X + 1, Y, Z + 1), 0);
	    		player.worldObj.setBlockToAir(X + 1, Y, Z + 1);
	    		System.out.println("break");
	    	}
	    	if (player.worldObj.getBlock(X, Y, Z - 1) instanceof WeedBlock) {
	    		player.worldObj.getBlock(X, Y, Z - 1).dropBlockAsItem(player.worldObj, X, Y, Z - 1, player.worldObj.getBlockMetadata(X, Y, Z - 1), 0);
	    		player.worldObj.setBlockToAir(X, Y, Z - 1);
	    		System.out.println("break");
	    	}
	    	if (player.worldObj.getBlock(X, Y, Z + 1) instanceof WeedBlock) {
	    		player.worldObj.getBlock(X, Y, Z + 1).dropBlockAsItem(player.worldObj, X, Y, Z + 1, player.worldObj.getBlockMetadata(X, Y, Z + 1), 0);
	    		player.worldObj.setBlockToAir(X, Y, Z + 1);
	    		System.out.println("break");
	    	}
	    	return false;
    	}
    	else {
    		return true;
    	}
    }*/
    
    /*public boolean canHarvestBlock(Block par1Block, ItemStack itemStack) {
        return par1Block instanceof WeedBlock;
    }*/
    
    /*public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
    	if (p_150894_2_.getBlock(p_150894_4_, p_150894_5_, p_150894_6_) instanceof WeedBlock) {
	    	if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D) {
	            p_150894_1_.damageItem(10, p_150894_7_);
	        }
	    	if (p_150894_2_.getBlock(p_150894_4_ - 1, p_150894_5_, p_150894_6_) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_, p_150894_2_.getBlockMetadata(p_150894_4_ - 1, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ - 1, p_150894_5_, p_150894_6_);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ + 1, p_150894_5_, p_150894_6_) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_, p_150894_2_.getBlockMetadata(p_150894_4_ + 1, p_150894_5_, p_150894_6_), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ + 1, p_150894_5_, p_150894_6_);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ - 1, p_150894_5_, p_150894_6_ - 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_ - 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_ - 1, p_150894_2_.getBlockMetadata(p_150894_4_ - 1, p_150894_5_, p_150894_6_ - 1), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ - 1, p_150894_5_, p_150894_6_ - 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ - 1, p_150894_5_, p_150894_6_ + 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_ + 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ - 1, p_150894_5_, p_150894_6_ + 1, p_150894_2_.getBlockMetadata(p_150894_4_ - 1, p_150894_5_, p_150894_6_ + 1), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ - 1, p_150894_5_, p_150894_6_ + 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ + 1, p_150894_5_, p_150894_6_ - 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_ - 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_ - 1, p_150894_2_.getBlockMetadata(p_150894_4_ + 1, p_150894_5_, p_150894_6_ - 1), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ + 1, p_150894_5_, p_150894_6_ - 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_ + 1, p_150894_5_, p_150894_6_ + 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_ + 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_ + 1, p_150894_5_, p_150894_6_ + 1, p_150894_2_.getBlockMetadata(p_150894_4_ + 1, p_150894_5_, p_150894_6_ + 1), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_ + 1, p_150894_5_, p_150894_6_ + 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_, p_150894_5_, p_150894_6_ - 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_ - 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_ - 1, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_ - 1), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_, p_150894_5_, p_150894_6_ - 1);
	    		System.out.println("break");
	    	}
	    	if (p_150894_2_.getBlock(p_150894_4_, p_150894_5_, p_150894_6_ + 1) instanceof WeedBlock) {
	    		//p_150894_3_.breakBlock(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_ + 1, p_150894_3_,
	    			//p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_));
	    		p_150894_3_.dropBlockAsItem(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_ + 1, p_150894_2_.getBlockMetadata(p_150894_4_, p_150894_5_, p_150894_6_ + 1), 0);
	    		p_150894_2_.setBlockToAir(p_150894_4_, p_150894_5_, p_150894_6_ + 1);
	    		System.out.println("break");
	    	}
	    	return true;
    	}
    	else {
    		return false;
    	}
    }*/

}
