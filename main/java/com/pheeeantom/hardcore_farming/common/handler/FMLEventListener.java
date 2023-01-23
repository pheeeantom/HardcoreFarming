package com.pheeeantom.hardcore_farming.common.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.pheeeantom.hardcore_farming.common.block.WeedBlock;
import com.pheeeantom.hardcore_farming.common.item.ScytheItem;
import com.pheeeantom.hardcore_farming.common.storage.NBTPlantedCrops;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.ForgeChunkManager.ForceChunkEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.fluids.FluidEvent;
import scala.actors.threadpool.Arrays;

public class FMLEventListener {
	
	private int tickNum = 0;
	
    /*@SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        event.player.addChatMessage(new ChatComponentText(String.format("œË‚ÂÚ, %s!", event.player.getCommandSenderName())));
    }*/
	
	/*HashSet<Chunk> currentChunks = new HashSet<Chunk>();
	
	@SubscribeEvent
	public void onChunkLoad(ChunkEvent.Load event) {
		currentChunks.add(event.getChunk());
		System.out.println(currentChunks.size());
	}
	
	@SubscribeEvent
	public void onChunkUnload(ChunkEvent.Unload event) {
		currentChunks.remove(event.getChunk());
		System.out.println(currentChunks.size());
	}
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
        //for (ChunkCoordIntPair ccip : event.world.getPersistentChunks().keySet()) {
        	//event.world.getChunkFromChunkCoords(ccip.chunkXPos, ccip.chunkZPos);
        //	System.out.println(ccip.chunkXPos + ":" + ccip.chunkZPos);
        //}
		HashSet<Chunk> currentChunks2 = (HashSet<Chunk>) currentChunks.clone();
		for (Chunk chunk : currentChunks2) {
			for (int i = chunk.xPosition << 0; i < chunk.xPosition << 4; i++) {
				for (int j = 0; j < 256; j++) {
					for (int k = chunk.zPosition << 0; k < chunk.zPosition << 4; k++) {
						if (event.world.getBlock(i, j, k) instanceof BlockCrops) {
							if (Math.random() < 0.25) {
								event.world.setBlock(i, j, k, new WeedBlock());
							}
						}
					}
				}
			}
		}
    }*/
	
	/*@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		int minX = (int)Math.abs(event.player.posX) - 100;
		int maxX = (int)Math.abs(event.player.posX) + 100;
		
		int minY = 0;
		int maxY = 256;
		
		int minZ = (int)Math.abs(event.player.posZ) - 100;
		int maxZ = (int)Math.abs(event.player.posZ) + 100;
		
		for (int i = minX; i < maxX; i++) {
			for (int j = minY; j < maxY; j++) {
				for (int k = minZ; k < maxZ; k++) {
					if (event.player.worldObj.getBlock(i, j, k) instanceof BlockCrops) {
						if (Math.random() < 0.25) {
							event.player.worldObj.setBlock(i, j, k, new WeedBlock());
						}
					}
				}
			}
		}
	}*/
	
	//HashSet<List<Integer>> plantedCrops = new HashSet<List<Integer>>();
	
	//NBTPlantedCrops save;
	
	//World world1;
	//World world2;
	
	//Ã»–€ Œƒ»Õ¿ Œ¬€ ¬Œ ¬—≈’ —Œ¡€“»ﬂ’
	
	@SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.player.worldObj.isRemote) {
			NBTTagCompound plantedCrops;
			NBTPlantedCrops save = NBTPlantedCrops.get(event.player.worldObj);
			//world1 = event.player.worldObj;
			//save.writeToNBT(plantedCrops);
			if (save != null) {
				plantedCrops = save.getPlantedCrops();
				if (plantedCrops != null) {
					System.out.println(plantedCrops.toString());
				}
				else {
					System.out.println("plantedCrops == null");
				}
			}
			else {
				System.out.println("save == null");
			}
		}
	}
	
	@SubscribeEvent
	public void onBlockPlace(BlockEvent.PlaceEvent event) {
		/*world2 = event.world;
		if (world1 == world2) {
			System.out.println("aaaaa");
		}
		else if (world1.equals(world2)) {
			System.out.println("bbbbb");
		}
		else {
			System.out.println("ccccc");
		}*/
		//System.out.println(event.placedBlock.getLocalizedName());
		if (!event.world.isRemote) {
			if (event.placedBlock instanceof BlockCrops) {
				/*plantedCrops.add(Arrays.asList(new Integer[] {Integer.valueOf(event.x), Integer.valueOf(event.y),
						Integer.valueOf(event.z)}));
				System.out.println(plantedCrops.size());*/
				/*NBTTagCompound tag = data.getData();
				WorldSavedData data = new WorldSavedData("plantedCrops");
				tag.setString("5", "3");
				data.markDirty(); //Save the data to the disc. NEEDED TO WORK!*/
				//NBTTagIntArray
				
				/*NBTTagCompound plantedCrops = null;
				NBTTagList list;
				NBTTagIntArray coords = new NBTTagIntArray(new int[] {event.x, event.y, event.z});
		    	//NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				//save.writeToNBT(plantedCrops);
		    	plantedCrops = save.writeToNBT2(plantedCrops);
		    	if (plantedCrops == null) {
					plantedCrops = new NBTTagCompound();
					list = new NBTTagList();
					list.appendTag(coords);
					plantedCrops.setTag("PlantedCrops", list);
		    	}
		    	else {
		    		list = plantedCrops.getTagList("PlantedCrops", 11);
		    		list.appendTag(coords);
		    		plantedCrops.setTag("PlantedCrops", list);
		    	}
		    	System.out.println(plantedCrops.toString());
		    	save.readFromNBT(plantedCrops);
		    	save.markDirty();*/ //Õ”∆ÕŒ!!!
				
				NBTTagCompound plantedCrops;
				NBTTagList list;
				NBTTagIntArray coords = new NBTTagIntArray(new int[] {event.x, event.y, event.z});
				NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				if (save != null) {
			    	plantedCrops = save.getPlantedCrops();
			    	if (plantedCrops == null) {
						plantedCrops = new NBTTagCompound();
						list = new NBTTagList();
						list.appendTag(coords);
						plantedCrops.setTag("PlantedCrops", list);
			    	}
			    	else {
			    		list = plantedCrops.getTagList("PlantedCrops", 11);
			    		list.appendTag(coords);
			    		plantedCrops.setTag("PlantedCrops", list);
			    	}
			    	System.out.println(plantedCrops.toString());
			    	save.setPlantedCrops(plantedCrops);
				}
				else {
					System.out.println("save == null");
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onBlockHarvestDrops(BlockEvent.HarvestDropsEvent event) {
		//System.out.println(event.placedBlock.getLocalizedName());
		System.out.println("isCrops?" + (event.block instanceof BlockCrops));
		System.out.println("isWeed?" + (event.block instanceof WeedBlock));
		System.out.println("isHarvesterNull?" + (event.harvester == null));
		if (event.harvester != null) {
			System.out.println("isNotCreative?" + (!event.harvester.capabilities.isCreativeMode));
		}
		if (!event.world.isRemote) {
			if ((event.block instanceof BlockCrops || event.block instanceof WeedBlock)
					&& (event.harvester == null || !event.harvester.capabilities.isCreativeMode)) {
				/*NBTTagCompound plantedCrops = null;
				NBTTagList list;
				//NBTTagIntArray coords = new NBTTagIntArray(new int[] {event.x, event.y, event.z});
		    	//NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				//save.writeToNBT(plantedCrops);
				plantedCrops = save.writeToNBT2(plantedCrops);
		    	if (plantedCrops != null) {
		    		list = plantedCrops.getTagList("PlantedCrops", 11);
					for (int i = 0; i < list.tagCount(); i++) {
						//System.out.println(list.func_150306_c(i).toString() + "   " +
						//		coords.toString());
						if (list.func_150306_c(i)[0] == event.x && 
								list.func_150306_c(i)[1] == event.y &&
								list.func_150306_c(i)[2] == event.z) {
							list.removeTag(i);
							break;
						}
					}
					plantedCrops.setTag("PlantedCrops", list);
		    	}
		    	System.out.println(plantedCrops.toString());
		    	//System.out.println("HI");
		    	save.readFromNBT(plantedCrops);
		    	save.markDirty();*/ //Õ”∆ÕŒ!!!
				
				NBTTagCompound plantedCrops;
				NBTTagList list;
				NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				//NBTTagIntArray coords = new NBTTagIntArray(new int[] {event.x, event.y, event.z});
		    	//NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				//save.writeToNBT(plantedCrops);
				if (save != null) {
					plantedCrops = save.getPlantedCrops();
			    	if (plantedCrops != null) {
			    		list = plantedCrops.getTagList("PlantedCrops", 11);
						for (int i = 0; i < list.tagCount(); i++) {
							//System.out.println(list.func_150306_c(i).toString() + "   " +
							//		coords.toString());
							if (list.func_150306_c(i)[0] == event.x && 
									list.func_150306_c(i)[1] == event.y &&
									list.func_150306_c(i)[2] == event.z) {
								list.removeTag(i);
								break;
							}
						}
						plantedCrops.setTag("PlantedCrops", list);
						System.out.println(plantedCrops.toString());
						save.setPlantedCrops(plantedCrops);
			    	}
			    	//System.out.println("HI");
				}
				else {
					System.out.println("save == null");
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		//System.out.println(event.placedBlock.getLocalizedName());
		System.out.println("isCrops?" + (event.block instanceof BlockCrops));
		System.out.println("isWeed?" + (event.block instanceof WeedBlock));
		System.out.println("isCreative?" + (event.getPlayer().capabilities.isCreativeMode));
		if (!event.world.isRemote) {
		    if (event.getPlayer() != null) {
		    	//System.out.println(event.block.getMaterial() == Material.vine);
		        if (event.getPlayer().getHeldItem() != null && event.getPlayer().getHeldItem().getItem() instanceof ScytheItem &&
		        		event.block.getMaterial() != Material.vine) {
		            event.setCanceled(true);
		            return;
		        }
		        if (event.getPlayer().getHeldItem() != null &&
		        		event.getPlayer().getHeldItem().getItem() instanceof ScytheItem &&
		        		event.block.getMaterial() == Material.vine) {
			    	if (event.getPlayer().worldObj.getBlock(event.x - 1, event.y, event.z).getMaterial() == Material.vine) {
			    		event.getPlayer().worldObj.getBlock(event.x - 1, event.y, event.z).dropBlockAsItem(event.getPlayer().worldObj, event.x - 1, event.y, event.z, event.getPlayer().worldObj.getBlockMetadata(event.x - 1, event.y, event.z), 0);
			    		event.getPlayer().worldObj.setBlockToAir(event.x - 1, event.y, event.z);
			    		event.getPlayer().getHeldItem().damageItem(5, event.getPlayer());
			    		System.out.println("break");
			    	}
			    	if (event.getPlayer().worldObj.getBlock(event.x + 1, event.y, event.z).getMaterial() == Material.vine) {
			    	    event.getPlayer().worldObj.getBlock(event.x + 1, event.y, event.z).dropBlockAsItem(event.getPlayer().worldObj, event.x + 1, event.y, event.z, event.getPlayer().worldObj.getBlockMetadata(event.x + 1, event.y, event.z), 0);
			    	    event.getPlayer().worldObj.setBlockToAir(event.x + 1, event.y, event.z);
			    	    event.getPlayer().getHeldItem().damageItem(5, event.getPlayer());
			    	    System.out.println("break");
			    	}
			    	if (event.getPlayer().worldObj.getBlock(event.x - 1, event.y, event.z - 1).getMaterial() == Material.vine) {
			    	    event.getPlayer().worldObj.getBlock(event.x - 1, event.y, event.z - 1).dropBlockAsItem(event.getPlayer().worldObj, event.x - 1, event.y, event.z - 1, event.getPlayer().worldObj.getBlockMetadata(event.x - 1, event.y, event.z - 1), 0);
			    	    event.getPlayer().worldObj.setBlockToAir(event.x - 1, event.y, event.z - 1);
			    	    event.getPlayer().getHeldItem().damageItem(5, event.getPlayer());
			    	    System.out.println("break");
			    	}
			    	if (event.getPlayer().worldObj.getBlock(event.x - 1, event.y, event.z + 1).getMaterial() == Material.vine) {
			    	    event.getPlayer().worldObj.getBlock(event.x - 1, event.y, event.z + 1).dropBlockAsItem(event.getPlayer().worldObj, event.x - 1, event.y, event.z + 1, event.getPlayer().worldObj.getBlockMetadata(event.x - 1, event.y, event.z + 1), 0);
			    	    event.getPlayer().worldObj.setBlockToAir(event.x - 1, event.y, event.z + 1);
			    	    event.getPlayer().getHeldItem().damageItem(5, event.getPlayer());
			    	    System.out.println("break");
			    	}
			    	if (event.getPlayer().worldObj.getBlock(event.x + 1, event.y, event.z - 1).getMaterial() == Material.vine) {
			    	    event.getPlayer().worldObj.getBlock(event.x + 1, event.y, event.z - 1).dropBlockAsItem(event.getPlayer().worldObj, event.x + 1, event.y, event.z - 1, event.getPlayer().worldObj.getBlockMetadata(event.x + 1, event.y, event.z - 1), 0);
			    	    event.getPlayer().worldObj.setBlockToAir(event.x + 1, event.y, event.z - 1);
			    	    event.getPlayer().getHeldItem().damageItem(5, event.getPlayer());
			    	    System.out.println("break");
			    	}
			    	if (event.getPlayer().worldObj.getBlock(event.x + 1, event.y, event.z + 1).getMaterial() == Material.vine) {
			    	    event.getPlayer().worldObj.getBlock(event.x + 1, event.y, event.z + 1).dropBlockAsItem(event.getPlayer().worldObj, event.x + 1, event.y, event.z + 1, event.getPlayer().worldObj.getBlockMetadata(event.x + 1, event.y, event.z + 1), 0);
			    	    event.getPlayer().worldObj.setBlockToAir(event.x + 1, event.y, event.z + 1);
			    	    event.getPlayer().getHeldItem().damageItem(5, event.getPlayer());
			    	    System.out.println("break");
			    	}
			    	if (event.getPlayer().worldObj.getBlock(event.x, event.y, event.z - 1).getMaterial() == Material.vine) {
			    	    event.getPlayer().worldObj.getBlock(event.x, event.y, event.z - 1).dropBlockAsItem(event.getPlayer().worldObj, event.x, event.y, event.z - 1, event.getPlayer().worldObj.getBlockMetadata(event.x, event.y, event.z - 1), 0);
			    	    event.getPlayer().worldObj.setBlockToAir(event.x, event.y, event.z - 1);
			    	    event.getPlayer().getHeldItem().damageItem(5, event.getPlayer());
			    	    System.out.println("break");
			    	}
			    	if (event.getPlayer().worldObj.getBlock(event.x, event.y, event.z + 1).getMaterial() == Material.vine) {
			    	    event.getPlayer().worldObj.getBlock(event.x, event.y, event.z + 1).dropBlockAsItem(event.getPlayer().worldObj, event.x, event.y, event.z + 1, event.getPlayer().worldObj.getBlockMetadata(event.x, event.y, event.z + 1), 0);
			    	    event.getPlayer().worldObj.setBlockToAir(event.x, event.y, event.z + 1);
			    	    event.getPlayer().getHeldItem().damageItem(5, event.getPlayer());
			    	    System.out.println("break");
			    	}
		    	}
		    }
			
			if ((event.block instanceof BlockCrops && event.getPlayer().capabilities.isCreativeMode) 
					|| event.block instanceof WeedBlock) {
				/*NBTTagCompound plantedCrops = null;
				NBTTagList list;
				//NBTTagIntArray coords = new NBTTagIntArray(new int[] {event.x, event.y, event.z});
		    	//NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				//save.writeToNBT(plantedCrops);
				plantedCrops = save.writeToNBT2(plantedCrops);
		    	if (plantedCrops != null) {
		    		list = plantedCrops.getTagList("PlantedCrops", 11);
					for (int i = 0; i < list.tagCount(); i++) {
						//System.out.println(list.func_150306_c(i).toString() + "   " +
						//		coords.toString());
						if (list.func_150306_c(i)[0] == event.x && 
								list.func_150306_c(i)[1] == event.y &&
								list.func_150306_c(i)[2] == event.z) {
							list.removeTag(i);
							break;
						}
					}
					plantedCrops.setTag("PlantedCrops", list);
		    	}
		    	System.out.println(plantedCrops.toString());
		    	//System.out.println("HI");
		    	save.readFromNBT(plantedCrops);
		    	save.markDirty();*/ //Õ”∆ÕŒ!!!
				
				NBTTagCompound plantedCrops;
				NBTTagList list;
				NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				//NBTTagIntArray coords = new NBTTagIntArray(new int[] {event.x, event.y, event.z});
		    	//NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				//save.writeToNBT(plantedCrops);
				if (save != null) {
					plantedCrops = save.getPlantedCrops();
			    	if (plantedCrops != null) {
			    		list = plantedCrops.getTagList("PlantedCrops", 11);
						for (int i = 0; i < list.tagCount(); i++) {
							//System.out.println(list.func_150306_c(i).toString() + "   " +
							//		coords.toString());
							if (list.func_150306_c(i)[0] == event.x && 
									list.func_150306_c(i)[1] == event.y &&
									list.func_150306_c(i)[2] == event.z) {
								list.removeTag(i);
								break;
							}
						}
						plantedCrops.setTag("PlantedCrops", list);
						System.out.println(plantedCrops.toString());
						save.setPlantedCrops(plantedCrops);
			    	}
			    	//System.out.println("HI");
				}
				else {
					System.out.println("save == null");
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (!event.world.isRemote) {
			tickNum++;
			//System.out.println(tickNum);
			//System.out.println(event.world.provider.getDimensionName());
			if (tickNum >= 100 && event.world.provider.getDimensionName() == "Overworld") {
				NBTTagCompound plantedCrops;
				NBTTagList list;
				NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				if (save != null) {
					plantedCrops = save.getPlantedCrops();
					if (plantedCrops != null) {
						//System.out.println(plantedCrops.toString());
						list = plantedCrops.getTagList("PlantedCrops", 11);
						for (int i = 0; i < list.tagCount(); i++) {
							//System.out.println("HELLO1");
							//System.out.println(event.world.getBlock(list.func_150306_c(i)[0], list.func_150306_c(i)[1], list.func_150306_c(i)[2]) instanceof BlockCrops);
							//System.out.println(event.world.getBlock(list.func_150306_c(i)[0], list.func_150306_c(i)[1], list.func_150306_c(i)[2]) instanceof BlockFarmland);
							//System.out.println(event.world.getBlock(list.func_150306_c(i)[0], list.func_150306_c(i)[1], list.func_150306_c(i)[2]) instanceof WeedBlock);
							//System.out.println(event.world.getBlock(list.func_150306_c(i)[0], list.func_150306_c(i)[1], list.func_150306_c(i)[2]).getClass().toString());
							if (event.world.getBlock(list.func_150306_c(i)[0], list.func_150306_c(i)[1], list.func_150306_c(i)[2]) instanceof BlockCrops) {
								//System.out.println(list.func_150306_c(i).toString() + "   " +
								//		coords.toString());
								//System.out.println("HELLO2");
								double probability = 0.0005;
								if (event.world.getBlock(list.func_150306_c(i)[0] - 1, list.func_150306_c(i)[1], list.func_150306_c(i)[2]) instanceof WeedBlock) {
									probability *= 2;
								}
								if (event.world.getBlock(list.func_150306_c(i)[0] + 1, list.func_150306_c(i)[1], list.func_150306_c(i)[2]) instanceof WeedBlock) {
									probability *= 2;
								}
								if (event.world.getBlock(list.func_150306_c(i)[0] - 1, list.func_150306_c(i)[1], list.func_150306_c(i)[2] - 1) instanceof WeedBlock) {
									probability *= 1.5;
								}
								if (event.world.getBlock(list.func_150306_c(i)[0] - 1, list.func_150306_c(i)[1], list.func_150306_c(i)[2] + 1) instanceof WeedBlock) {
									probability *= 1.5;
								}
								if (event.world.getBlock(list.func_150306_c(i)[0] + 1, list.func_150306_c(i)[1], list.func_150306_c(i)[2] - 1) instanceof WeedBlock) {
									probability *= 1.5;
								}
								if (event.world.getBlock(list.func_150306_c(i)[0] + 1, list.func_150306_c(i)[1], list.func_150306_c(i)[2] + 1) instanceof WeedBlock) {
									probability *= 1.5;
								}
								if (event.world.getBlock(list.func_150306_c(i)[0], list.func_150306_c(i)[1], list.func_150306_c(i)[2] - 1) instanceof WeedBlock) {
									probability *= 2;
								}
								if (event.world.getBlock(list.func_150306_c(i)[0], list.func_150306_c(i)[1], list.func_150306_c(i)[2] + 1) instanceof WeedBlock) {
									probability *= 2;
								}
								/*System.out.println("HELLO");
								if (list.func_150306_c(i)[0] == 1401 && list.func_150306_c(i)[1] == 4 &&
										list.func_150306_c(i)[2] == -412) {
									System.out.println(probability);
								}*/
								if (Math.random() < probability) {
									event.world.setBlock(list.func_150306_c(i)[0], list.func_150306_c(i)[1], list.func_150306_c(i)[2], ModBlocks.WEED);
									event.world.setBlockMetadataWithNotify(list.func_150306_c(i)[0], list.func_150306_c(i)[1], list.func_150306_c(i)[2], (int)Math.floor(Math.random() * 3), 2);
								}
							}
						}
					}
					else {
						System.out.println("plantedCrops == null");
					}
				}
				else {
					System.out.println("save == null");
				}
				tickNum = 0;
			}
		}
	}
	
	/*@SubscribeEvent
	public void onFluidMotion(FluidEvent.FluidMotionEvent event) {
		System.out.println("onFluidMotion");
		System.out.println(event.world.getBlock(event.x, event.y, event.z) instanceof BlockCrops);
		System.out.println(event.world.getBlock(event.x, event.y, event.z) instanceof BlockDynamicLiquid);
		if (!event.world.isRemote) {
			if ((event.world.getBlock(event.x, event.y, event.z) instanceof BlockCrops ||
					event.world.getBlock(event.x, event.y, event.z) instanceof WeedBlock) 
					&& event.fluid.getFluid().getBlock() instanceof BlockDynamicLiquid &&
					event.fluid.getFluid().getBlock().getMaterial() == Material.lava) {
				NBTTagCompound plantedCrops;
				NBTTagList list;
				NBTPlantedCrops save = NBTPlantedCrops.get(event.world);
				if (save != null) {
					plantedCrops = save.getPlantedCrops();
			    	if (plantedCrops != null) {
			    		list = plantedCrops.getTagList("PlantedCrops", 11);
						for (int i = 0; i < list.tagCount(); i++) {
							if (list.func_150306_c(i)[0] == event.x && 
									list.func_150306_c(i)[1] == event.y &&
									list.func_150306_c(i)[2] == event.z) {
								list.removeTag(i);
								break;
							}
						}
						plantedCrops.setTag("PlantedCrops", list);
						System.out.println(plantedCrops.toString());
						save.setPlantedCrops(plantedCrops);
			    	}
				}
				else {
					System.out.println("save == null");
				}
			}
		}
	}*/
	
}