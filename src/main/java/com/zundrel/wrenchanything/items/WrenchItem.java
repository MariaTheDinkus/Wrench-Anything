package com.zundrel.wrenchanything.items;

import com.zundrel.wrenchanything.config.WrenchAnythingConfig;
import com.zundrel.wrenchable.wrench.Wrench;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class WrenchItem extends Item implements Wrench {
    public WrenchItem() {
        super(new Item.Settings().maxCount(1).group(ItemGroup.TOOLS));
    }

    public WrenchItem(int durability) {
        super(new Item.Settings().maxCount(1).maxDamage(durability).group(ItemGroup.TOOLS));
    }

    @Override
    public boolean canRepair(ItemStack itemStack_1, ItemStack itemStack_2) {
        return WrenchAnythingConfig.hasDurability && ToolMaterials.IRON.getRepairIngredient().test(itemStack_2);
    }

    @Override
    public void onBlockWrenched(World world, ItemStack stack, PlayerEntity player, Hand hand, BlockHitResult result) {
        if (!player.isCreative() && WrenchAnythingConfig.hasDurability) {
            stack.damage(1, player, (playerEntity -> {
                player.sendToolBreakStatus(hand);
            }));
        }
    }

    @Override
    public void onEntityWrenched(World world, ItemStack stack, PlayerEntity player, Hand hand, EntityHitResult result) {
        if (!player.isCreative() && WrenchAnythingConfig.hasDurability) {
            stack.damage(1, player, (playerEntity -> {
                player.sendToolBreakStatus(hand);
            }));
        }
    }
}
