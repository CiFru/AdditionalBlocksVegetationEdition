package com.cifru.additionalblocks.vegetation.boat;

import com.cifru.additionalblocks.vegetation.AdditionalBlocks;
import com.cifru.additionalblocks.vegetation.IConfigObject;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created 4/16/2021 by SuperMartijn642
 */
public class VBoatItem extends Item implements IConfigObject {
    private static final Predicate<Entity> field_219989_a = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);

    private final VBoatType boatType;

    public VBoatItem(VBoatType type){
        super(type.getItemProperties());
        this.boatType = type;
        this.setRegistryName(type.getRegistryName());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn){
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
        if(raytraceresult.getType() == RayTraceResult.Type.MISS){
            return ActionResult.resultPass(itemstack);
        }else{
            Vector3d vector3d = playerIn.getLook(1.0F);
            List<Entity> list = worldIn.getEntitiesInAABBexcluding(playerIn, playerIn.getBoundingBox().expand(vector3d.scale(5.0D)).grow(1.0D), field_219989_a);
            if(!list.isEmpty()){
                Vector3d vector3d1 = playerIn.getEyePosition(1.0F);

                for(Entity entity : list){
                    AxisAlignedBB axisalignedbb = entity.getBoundingBox().grow((double)entity.getCollisionBorderSize());
                    if(axisalignedbb.contains(vector3d1)){
                        return ActionResult.resultPass(itemstack);
                    }
                }
            }

            if(raytraceresult.getType() == RayTraceResult.Type.BLOCK){
                VBoatEntity entity = new VBoatEntity(AdditionalBlocks.boat_entity, worldIn, raytraceresult.getHitVec().x, raytraceresult.getHitVec().y + 0.1, raytraceresult.getHitVec().z);
                entity.setVBoatType(this.boatType);
                entity.rotationYaw = playerIn.rotationYaw;
                if(!worldIn.hasNoCollisions(entity, entity.getBoundingBox().grow(-0.1D))){
                    return ActionResult.resultFail(itemstack);
                }else{
                    if(!worldIn.isRemote){
                        worldIn.addEntity(entity);
                        if(!playerIn.abilities.isCreativeMode){
                            itemstack.shrink(1);
                        }
                    }

                    playerIn.addStat(Stats.ITEM_USED.get(this));
                    return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
                }
            }else{
                return ActionResult.resultPass(itemstack);
            }
        }
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemGroup(group, items);
    }

    @Override
    public boolean isEnabled() {
        return this.boatType.isEnabled();
    }
}
