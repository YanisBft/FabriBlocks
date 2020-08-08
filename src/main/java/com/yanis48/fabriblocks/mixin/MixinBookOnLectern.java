package com.yanis48.fabriblocks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.yanis48.fabriblocks.block.FBLectern;
import com.yanis48.fabriblocks.init.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LecternBlock;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.WritableBookItem;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin( {WritableBookItem.class, WrittenBookItem.class} )
public abstract class MixinBookOnLectern {
	
	@Inject(method = "useOnBlock", at = @At(value = "HEAD"), cancellable = true)
	private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		World world = context.getWorld();
		BlockPos pos = context.getBlockPos();
		BlockState state = world.getBlockState(pos);
		if (state.getBlock() == Blocks.LECTERN) {
			cir.setReturnValue(LecternBlock.putBookIfAbsent(world, pos, state, context.getStack()) ? ActionResult.SUCCESS : ActionResult.PASS);
		} else if (state.getBlock().isIn(ModBlockTags.LECTERNS) && state.getBlock() != Blocks.LECTERN) {
			cir.setReturnValue(FBLectern.putBookIfAbsent(world, pos, state, context.getStack()) ? ActionResult.SUCCESS : ActionResult.PASS);
		} else {
			cir.setReturnValue(ActionResult.PASS);
		}
	}
}
