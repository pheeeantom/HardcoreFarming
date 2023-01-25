package com.pheeeantom.hardcore_farming.common.item;

import com.pheeeantom.hardcore_farming.HardcoreFarmingMod;
import com.pheeeantom.hardcore_farming.common.handler.HardcoreFarmingTab;
import com.pheeeantom.hardcore_farming.common.handler.ModItems;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class WateringCanItem extends Item {
	/*@SideOnly(Side.CLIENT)
	protected final RenderItem renderItem = RenderItem.getInstance();*/
	
	public WateringCanItem() {
		setUnlocalizedName("watering_can");
	    setTextureName(HardcoreFarmingMod.MODID + ":watering_can");
	    setMaxStackSize(1);
	    //setMaxDamage(100);
	    setCreativeTab(HardcoreFarmingTab.INSTANCE);
	}
	
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
    	/*if (!Minecraft.getMinecraft().thePlayer.getEntityWorld().isRemote) {
    		renderItem.renderItemAndEffectIntoGUI(Minecraft.getMinecraft().fontRenderer,
    				Minecraft.getMinecraft().getTextureManager(), p_77659_1_, 0, 0);
	    	renderItem.renderItemOverlayIntoGUI(Minecraft.getMinecraft().fontRenderer, 
	        	Minecraft.getMinecraft().getTextureManager(), p_77659_1_, 0, 0, null);
    	}*/
    	NBTTagCompound filling0;
    	byte fillingByte0;
    	if(p_77659_1_.hasTagCompound()) {
			filling0 = p_77659_1_.getTagCompound();
			fillingByte0 = filling0.getByte("filling");
    	}
    	else {
    		filling0 = new NBTTagCompound();
            filling0.setByte("filling", (byte)0);
            p_77659_1_.setTagCompound(filling0);
            fillingByte0 = 0;
            p_77659_1_.setItemDamage(0);
    	}
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, fillingByte0 < 100 || filling0 == null);

        if (movingobjectposition == null) {
            return p_77659_1_;
        } else {
            FillBucketEvent event = new FillBucketEvent(p_77659_3_, p_77659_1_, p_77659_2_, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event)) {
                return p_77659_1_;
            }

            if (event.getResult() == Event.Result.ALLOW) {
                if (p_77659_3_.capabilities.isCreativeMode) {
                    return p_77659_1_;
                }

                if (--p_77659_1_.stackSize <= 0) {
                    return event.result;
                }

                if (!p_77659_3_.inventory.addItemStackToInventory(event.result)) {
                    p_77659_3_.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return p_77659_1_;
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!p_77659_2_.canMineBlock(p_77659_3_, i, j, k)) {
                    return p_77659_1_;
                }

                if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_)) {
                    return p_77659_1_;
                }

                Material material = p_77659_2_.getBlock(i, j, k).getMaterial();
                int l = p_77659_2_.getBlockMetadata(i, j, k);

                if (material == Material.water && l == 0) {
                    p_77659_2_.setBlockToAir(i, j, k);
                    NBTTagCompound filling;
                    if(p_77659_1_.hasTagCompound())
    					filling = p_77659_1_.getTagCompound();
    				else
    					filling = new NBTTagCompound();
                    filling.setByte("filling", (byte)100);
                    p_77659_1_.setTagCompound(filling);
                    p_77659_1_.setItemDamage(100);
                    return p_77659_1_;
                } else {
                	NBTTagCompound filling;
                	byte fillingByte;
					filling = p_77659_1_.getTagCompound();
					fillingByte = filling.getByte("filling");
					
					//System.out.println(fillingByte);
                	
                	if (fillingByte == 0) {
                        return p_77659_1_;
                    }

                    /*if (movingobjectposition.sideHit == 0) {
                        --j;
                    }

                    if (movingobjectposition.sideHit == 1) {
                        ++j;
                    }

                    if (movingobjectposition.sideHit == 2) {
                        --k;
                    }

                    if (movingobjectposition.sideHit == 3) {
                        ++k;
                    }

                    if (movingobjectposition.sideHit == 4) {
                        --i;
                    }

                    if (movingobjectposition.sideHit == 5) {
                        ++i;
                    }*/

                    if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_)) {
                    	//System.out.println(1000);
                        return p_77659_1_;
                    }

                    if (this.water(p_77659_2_, i, j, k)/* && !p_77659_3_.capabilities.isCreativeMode*/) {
                    	fillingByte -= 5;
                    	//System.out.println(fillingByte);
                    	filling.setByte("filling", (byte)fillingByte);
                        p_77659_1_.setTagCompound(filling);
                        p_77659_1_.setItemDamage(fillingByte);
                        if (fillingByte == 0) {
                            return p_77659_1_;
                        }
                        if (this.water(p_77659_2_, i - 1, j, k)) {
                        	fillingByte -= 5;
                        	//System.out.println(fillingByte);
                        	filling.setByte("filling", (byte)fillingByte);
                            p_77659_1_.setTagCompound(filling);
                            p_77659_1_.setItemDamage(fillingByte);
                            if (fillingByte == 0) {
                                return p_77659_1_;
                            }
                        }
                        if (this.water(p_77659_2_, i + 1, j, k)) {
                        	fillingByte -= 5;
                        	//System.out.println(fillingByte);
                        	filling.setByte("filling", (byte)fillingByte);
                            p_77659_1_.setTagCompound(filling);
                            p_77659_1_.setItemDamage(fillingByte);
                            if (fillingByte == 0) {
                                return p_77659_1_;
                            }
                        }
                        if (this.water(p_77659_2_, i - 1, j, k - 1)) {
                        	fillingByte -= 5;
                        	//System.out.println(fillingByte);
                        	filling.setByte("filling", (byte)fillingByte);
                            p_77659_1_.setTagCompound(filling);
                            p_77659_1_.setItemDamage(fillingByte);
                            if (fillingByte == 0) {
                                return p_77659_1_;
                            }
                        }
                        if (this.water(p_77659_2_, i - 1, j, k + 1)) {
                        	fillingByte -= 5;
                        	//System.out.println(fillingByte);
                        	filling.setByte("filling", (byte)fillingByte);
                            p_77659_1_.setTagCompound(filling);
                            p_77659_1_.setItemDamage(fillingByte);
                            if (fillingByte == 0) {
                                return p_77659_1_;
                            }
                        }
                        if (this.water(p_77659_2_, i + 1, j, k - 1)) {
                        	fillingByte -= 5;
                        	//System.out.println(fillingByte);
                        	filling.setByte("filling", (byte)fillingByte);
                            p_77659_1_.setTagCompound(filling);
                            p_77659_1_.setItemDamage(fillingByte);
                            if (fillingByte == 0) {
                                return p_77659_1_;
                            }
                        }
                        if (this.water(p_77659_2_, i + 1, j, k + 1)) {
                        	fillingByte -= 5;
                        	//System.out.println(fillingByte);
                        	filling.setByte("filling", (byte)fillingByte);
                            p_77659_1_.setTagCompound(filling);
                            p_77659_1_.setItemDamage(fillingByte);
                            if (fillingByte == 0) {
                                return p_77659_1_;
                            }
                        }
                        if (this.water(p_77659_2_, i, j, k - 1)) {
                        	fillingByte -= 5;
                        	//System.out.println(fillingByte);
                        	filling.setByte("filling", (byte)fillingByte);
                            p_77659_1_.setTagCompound(filling);
                            p_77659_1_.setItemDamage(fillingByte);
                            if (fillingByte == 0) {
                                return p_77659_1_;
                            }
                        }
                        if (this.water(p_77659_2_, i, j, k + 1)) {
                        	fillingByte -= 5;
                        	//System.out.println(fillingByte);
                        	filling.setByte("filling", (byte)fillingByte);
                            p_77659_1_.setTagCompound(filling);
                            p_77659_1_.setItemDamage(fillingByte);
                            if (fillingByte == 0) {
                                return p_77659_1_;
                            }
                        }
                        return p_77659_1_;
                    }
                }  
            }

            return p_77659_1_;
        }
    }
    
    private ItemStack func_150910_a(ItemStack p_150910_1_, EntityPlayer p_150910_2_, Item p_150910_3_) {
        if (p_150910_2_.capabilities.isCreativeMode) {
            return p_150910_1_;
        } else if (--p_150910_1_.stackSize <= 0) {
            return new ItemStack(p_150910_3_);
        } else {
            if (!p_150910_2_.inventory.addItemStackToInventory(new ItemStack(p_150910_3_))) {
                p_150910_2_.dropPlayerItemWithRandomChoice(new ItemStack(p_150910_3_, 1, 0), false);
            }

            return p_150910_1_;
        }
    }
    
    public boolean water(World p_77875_1_, int p_77875_2_, int p_77875_3_, int p_77875_4_) {
    	/*System.out.println(p_77875_1_.getBlock(p_77875_2_ + 1, p_77875_3_, p_77875_4_) instanceof BlockFarmland);
    	System.out.println(p_77875_1_.getBlock(p_77875_2_, p_77875_3_ + 1, p_77875_4_) instanceof BlockFarmland);
    	System.out.println(p_77875_1_.getBlock(p_77875_2_, p_77875_3_, p_77875_4_ + 1) instanceof BlockFarmland);
    	System.out.println(p_77875_1_.getBlock(p_77875_2_ - 1, p_77875_3_, p_77875_4_) instanceof BlockFarmland);
    	System.out.println(p_77875_1_.getBlock(p_77875_2_, p_77875_3_ - 1, p_77875_4_) instanceof BlockFarmland);
    	System.out.println(p_77875_1_.getBlock(p_77875_2_, p_77875_3_, p_77875_4_ - 1) instanceof BlockFarmland);
    	System.out.println(p_77875_1_.getBlockMetadata(p_77875_2_, p_77875_3_, p_77875_4_ - 1));*/
    	if (p_77875_1_.getBlock(p_77875_2_, p_77875_3_, p_77875_4_) instanceof BlockFarmland &&
    			p_77875_1_.getBlockMetadata(p_77875_2_, p_77875_3_, p_77875_4_) < 7) {
    		//Максимальное значение для метадаты - если засунуть 20 то получится 4 из-за обрезки битов
	    	p_77875_1_.setBlockMetadataWithNotify(p_77875_2_, p_77875_3_, p_77875_4_, 15, 2);
	    	//System.out.println(p_77875_1_.getBlockMetadata(p_77875_2_, p_77875_3_, p_77875_4_));
	    	return true;
    	}
    	else if (p_77875_1_.getBlock(p_77875_2_, p_77875_3_ - 1, p_77875_4_) instanceof BlockFarmland &&
    			p_77875_1_.getBlockMetadata(p_77875_2_, p_77875_3_ - 1, p_77875_4_) < 7) {
    		p_77875_1_.setBlockMetadataWithNotify(p_77875_2_, p_77875_3_ - 1, p_77875_4_, 15, 2);
	    	//System.out.println(p_77875_1_.getBlockMetadata(p_77875_2_, p_77875_3_ - 1, p_77875_4_));
	    	return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Queries the percentage of the 'Durability' bar that should be drawn.
     *
     * @param stack The current ItemStack
     * @return 1.0 for 100% 0 for 0%
     */
    public double getDurabilityForDisplay(ItemStack stack) {
    	//System.out.println((double)stack.getItemDamageForDisplay() / (double)stack.getMaxDamage());
    	NBTTagCompound filling;
    	byte fillingByte;
    	if(stack.hasTagCompound()) {
			filling = stack.getTagCompound();
			fillingByte = filling.getByte("filling");
			return 1.0D - ((double)fillingByte / 100.0D);
    	}
    	else {
    		return 1.0D;
    	}
    }
    
    /**
     * Determines if the durability bar should be rendered for this item.
     * Defaults to vanilla stack.isDamaged behavior.
     * But modders can use this for any data they wish.
     *
     * @param stack The current Item Stack
     * @return True if it should render the 'durability' bar.
     */
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }
    
    /*@SideOnly(Side.CLIENT)
    private void renderFilling(ItemStack stack) {
    	renderItem.renderItemOverlayIntoGUI(Minecraft.getMinecraft().fontRenderer, 
        		Minecraft.getMinecraft().getTextureManager(), stack, 10000, 10000, null);
    }*/
}
