package com.cifru.additionalblocks.vegetation.boat;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.network.NetworkHooks;

import java.lang.reflect.Field;

/**
 * Created 4/16/2021 by SuperMartijn642
 */
public class VBoatEntity extends BoatEntity {

    private static final Field lastYd = ObfuscationReflectionHelper.findField(BoatEntity.class, "field_184473_aH");
    private static final Field status = ObfuscationReflectionHelper.findField(BoatEntity.class, "field_184469_aF");

    static{
        try{
            lastYd.setAccessible(true);
        }catch(Exception e){e.printStackTrace();}
    }

    private static final DataParameter<Integer> BOAT_TYPE = EntityDataManager.createKey(VBoatEntity.class, DataSerializers.VARINT);

    public VBoatEntity(EntityType<? extends VBoatEntity> type, World world){
        super(type, world);
    }

    public VBoatEntity(EntityType<? extends VBoatEntity> type, World world, double x, double y, double z){
        this(type, world);
        this.setPosition(x, y, z);
        this.setMotion(Vector3d.ZERO);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    @Override
    protected void registerData(){
        super.registerData();
        this.dataManager.register(BOAT_TYPE, 0);
    }

    public void setVBoatType(VBoatType type){
        this.dataManager.set(BOAT_TYPE, type.getIndex());
    }

    public VBoatType getVBoatType(){
        return VBoatType.fromIndex(this.dataManager.get(BOAT_TYPE));
    }

    @Override
    public Item getItemBoat(){
        return this.getVBoatType().getItem();
    }

    @Override
    protected void writeAdditional(CompoundNBT compound){
        super.writeAdditional(compound);
        compound.putInt("VBoatType", this.getVBoatType().getIndex());
    }

    @Override
    protected void readAdditional(CompoundNBT compound){
        super.readAdditional(compound);
        if(compound.contains("VBoatType"))
            this.setVBoatType(VBoatType.fromIndex(compound.getInt("VBoatType")));
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos){
        this.setLastYd(this.getMotion().y);
        if(!this.isPassenger()){
            if(onGroundIn){
                if(this.fallDistance > 3.0F){
                    if(this.getStatus() != BoatEntity.Status.ON_LAND){
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.onLivingFall(this.fallDistance, 1.0F);
                    if(!this.world.isRemote && !this.removed){
                        this.remove();
                        if(this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)){
                            for(int i = 0; i < 3; ++i){
                                this.entityDropItem(this.getVBoatType().getPlank());
                            }

                            for(int j = 0; j < 2; ++j){
                                this.entityDropItem(Items.STICK);
                            }
                        }
                    }
                }

                this.fallDistance = 0.0F;
            }else if(!this.world.getFluidState(this.getPosition().down()).isTagged(FluidTags.WATER) && y < 0.0D){
                this.fallDistance = (float)((double)this.fallDistance - y);
            }

        }
    }

    private void setLastYd(double value){
        try{
            lastYd.set(this, value);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }

    private Status getStatus(){
        try{
            return (Status)status.get(this);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IPacket<?> createSpawnPacket(){
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
