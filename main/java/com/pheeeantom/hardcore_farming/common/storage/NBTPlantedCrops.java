package com.pheeeantom.hardcore_farming.common.storage;

import java.util.HashSet;
import java.util.List;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;

public class NBTPlantedCrops extends WorldSavedData {
	
	//NBTTagCompound plantedCrops;
	
	/*public NBTPlantedCrops(String p_i2141_1_) {
		super(p_i2141_1_);
	}

	@Override
	public void readFromNBT(NBTTagCompound p_76184_1_) {
		//plantedCrops = p_76184_1_.getTagList("PlantedCropsArr", 11);
		plantedCrops = p_76184_1_;
	}

	@Override
	public void writeToNBT(NBTTagCompound p_76187_1_) {}
	
	public NBTTagCompound writeToNBT2(NBTTagCompound p_76187_1_) {
		//NBTTagList list = p_76187_1_.setTag("PlantedCropsArr", NBTBase.NBTTypes[11]);
		//NBTTagIntArray coords = new NBTTagIntArray();
		//list.appendTag(p_74742_1_);
		p_76187_1_ = plantedCrops;
		return p_76187_1_;
	}


	//public void addCoords()
	
	public static NBTPlantedCrops get(World world) {
		NBTPlantedCrops save = (NBTPlantedCrops) world.mapStorage.loadData(NBTPlantedCrops.class,
				"NBTPlantedCrops");
		if(save == null) {
			System.out.println("Creating a new World Configuration File");
			save = new NBTPlantedCrops("NBTPlantedCrops");
			world.mapStorage.setData("NBTPlantedCrops", save);
		}else {
			System.out.println("Using a pre-existing Configuration File!");
		}
		return save;
	}*/
	
	private static final String DATA_NAME = "HardcoreFarming_PlantedCrops";
    private static NBTPlantedCrops instance;
    private NBTTagCompound plantedCrops;
	
    public NBTPlantedCrops() {
        super(DATA_NAME);
    }

    public NBTPlantedCrops(String name) {
        super(name);
    }

    public static NBTPlantedCrops get(World world) {
        MapStorage storage = world.mapStorage;
        instance = (NBTPlantedCrops) storage.loadData(NBTPlantedCrops.class, DATA_NAME);

        if (instance == null) {
            instance = new NBTPlantedCrops();
            storage.setData(DATA_NAME, instance);
        }
        else {
        	//System.out.println("HELLO");
        }
        return instance;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        plantedCrops = nbt.getCompoundTag("PlantedCrops");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        compound.setTag("PlantedCrops", plantedCrops);;
    }

    public void setPlantedCrops(NBTTagCompound nbt) {
        plantedCrops = nbt;
        markDirty();
    }

    public NBTTagCompound getPlantedCrops() {
        return plantedCrops;
    }
}
