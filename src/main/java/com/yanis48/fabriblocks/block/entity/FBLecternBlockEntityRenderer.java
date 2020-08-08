package com.yanis48.fabriblocks.block.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.LecternBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.EnchantingTableBlockEntityRenderer;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;

@Environment(EnvType.CLIENT)
public class FBLecternBlockEntityRenderer extends BlockEntityRenderer<FBLecternBlockEntity> {	
	private final BookModel book = new BookModel();
	
	public FBLecternBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
		super(dispatcher);
	}
	
	@Override
	public void render(FBLecternBlockEntity lecternBlockEntity_1, float float_1, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int int_1, int int_2) {
		BlockState state = lecternBlockEntity_1.getCachedState();
		if (state.get(LecternBlock.HAS_BOOK)) {
			matrixStack.push();
			matrixStack.translate(0.5D, 1.0625D, 0.5D);
			float float_2 = state.get(LecternBlock.FACING).rotateYClockwise().asRotation();
			matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-float_2));
			matrixStack.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(67.5F));
			matrixStack.translate(0.0D, -0.125D, 0.0D);
			this.book.setPageAngles(0.0F, 0.1F, 0.9F, 1.2F);
			VertexConsumer vertexConsumer = EnchantingTableBlockEntityRenderer.BOOK_TEXTURE.getVertexConsumer(vertexConsumerProvider, RenderLayer::getEntitySolid);
			this.book.render(matrixStack, vertexConsumer, int_1, int_2, 1.0F, 1.0F, 1.0F, 1.0F);
			matrixStack.pop();
		}
	}
}
