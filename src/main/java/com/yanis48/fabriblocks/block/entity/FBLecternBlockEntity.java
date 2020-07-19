package com.yanis48.fabriblocks.block.entity;

import com.yanis48.fabriblocks.block.FBLectern;
import com.yanis48.fabriblocks.init.ModBlockEntities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.LecternScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;

public class FBLecternBlockEntity extends BlockEntity implements Clearable, NamedScreenHandlerFactory {
	private final Inventory inventory = new Inventory() {
		public int size() {
			return 1;
		}
		
		public boolean isEmpty() {
			return FBLecternBlockEntity.this.book.isEmpty();
		}
		
		public ItemStack getStack(int int_1) {
			return int_1 == 0 ? FBLecternBlockEntity.this.book : ItemStack.EMPTY;
		}

		public ItemStack removeStack(int int_1, int int_2) {
			if (int_1 == 0) {
				ItemStack stack = FBLecternBlockEntity.this.book.split(int_2);
				if (FBLecternBlockEntity.this.book.isEmpty()) {
					FBLecternBlockEntity.this.onBookRemoved();
				}
				return stack;
			} else {
				return ItemStack.EMPTY;
			}
		}
		
		public ItemStack removeStack(int int_1) {
			if (int_1 == 0) {
				ItemStack stack = FBLecternBlockEntity.this.book;
				FBLecternBlockEntity.this.book = ItemStack.EMPTY;
				FBLecternBlockEntity.this.onBookRemoved();
				return stack;
			} else {
				return ItemStack.EMPTY;
			}
		}
		
		public void setStack(int int_1, ItemStack stack) {
		}
		
		public int getMaxCountPerStack() {
			return 1;
		}
		
		public void markDirty() {
			FBLecternBlockEntity.this.markDirty();
		}
		
		public boolean canPlayerUse(PlayerEntity player) {
			if (FBLecternBlockEntity.this.world.getBlockEntity(FBLecternBlockEntity.this.pos) != FBLecternBlockEntity.this) {
				return false;
			} else {
				return !(player.squaredDistanceTo(FBLecternBlockEntity.this.pos.getX() + 0.5D, FBLecternBlockEntity.this.pos.getY() + 0.5D, FBLecternBlockEntity.this.pos.getZ() + 0.5D) > 64.0D) && FBLecternBlockEntity.this.hasBook();
			}
		}
		
		public boolean isValid(int int_1, ItemStack stack) {
			return false;
		}
		
		public void clear() {
		}
	};
	private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
		public int get(int int_1) {
			return int_1 == 0 ? FBLecternBlockEntity.this.currentPage : 0;
		}
		
		public void set(int int_1, int int_2) {
			if (int_1 == 0) {
				FBLecternBlockEntity.this.setCurrentPage(int_2);
			}
			
		}
		
		public int size() {
			return 1;
		}
	};
	private ItemStack book;
	private int currentPage;
	private int pageCount;
	
	public FBLecternBlockEntity() {
		super(ModBlockEntities.LECTERN);
		this.book = ItemStack.EMPTY;
	}
	
	public ItemStack getBook() {
		return this.book;
	}
	
	public boolean hasBook() {
		Item item = this.book.getItem();
		return item == Items.WRITABLE_BOOK || item == Items.WRITTEN_BOOK;
	}
	
	public void setBook(ItemStack stack) {
		this.setBook(stack, null);
	}
	
	private void onBookRemoved() {
		this.currentPage = 0;
		this.pageCount = 0;
		FBLectern.setHasBook(this.getWorld(), this.getPos(), this.getCachedState(), false);
	}
	
	public void setBook(ItemStack stack, PlayerEntity player) {
		this.book = this.resolveBook(stack, player);
		this.currentPage = 0;
		this.pageCount = WrittenBookItem.getPageCount(this.book);
		this.markDirty();
	}
	
	private void setCurrentPage(int int_1) {
		int int_2 = MathHelper.clamp(int_1, 0, this.pageCount - 1);
		if (int_2 != this.currentPage) {
			this.currentPage = int_2;
			this.markDirty();
			FBLectern.setPowered(this.getWorld(), this.getPos(), this.getCachedState());
		}
	}
	
	public int getCurrentPage() {
		return this.currentPage;
	}
	
	public int getComparatorOutput() {
		float float_1 = this.pageCount > 1 ? this.getCurrentPage() / (this.pageCount - 1.0F) : 1.0F;
		return MathHelper.floor(float_1 * 14.0F) + (this.hasBook() ? 1 : 0);
	}
	
	private ItemStack resolveBook(ItemStack stack, PlayerEntity player) {
		if (this.world instanceof ServerWorld && stack.getItem() == Items.WRITTEN_BOOK) {
			WrittenBookItem.resolve(stack, this.getCommandSource(player), player);
		}
		return stack;
	}
	
	private ServerCommandSource getCommandSource(PlayerEntity player) {
		String name;
		Text component;
		if (player == null) {
			name = "Lectern";
			component = new LiteralText("Lectern");
		} else {
			name = player.getName().getString();
			component = player.getDisplayName();
		}
		Vec3d vec3d_1 = new Vec3d(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D);
		return new ServerCommandSource(CommandOutput.DUMMY, vec3d_1, Vec2f.ZERO, (ServerWorld)this.world, 2, name, component, this.world.getServer(), player);
	}
	
	public void fromTag(BlockState state, CompoundTag tag) {
		super.fromTag(state, tag);
		if (tag.contains("Book", 10)) {
			this.book = this.resolveBook(ItemStack.fromTag(tag.getCompound("Book")), null);
		} else {
			this.book = ItemStack.EMPTY;
		}
		this.pageCount = WrittenBookItem.getPageCount(this.book);
		this.currentPage = MathHelper.clamp(tag.getInt("Page"), 0, this.pageCount - 1);
	}
	
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		if (!this.getBook().isEmpty()) {
			tag.put("Book", this.getBook().toTag(new CompoundTag()));
			tag.putInt("Page", this.currentPage);
		}
		return tag;
	}
	
	public void clear() {
		this.setBook(ItemStack.EMPTY);
	}
	
	public ScreenHandler createMenu(int int_1, PlayerInventory inventory, PlayerEntity player) {
		return new LecternScreenHandler(int_1, this.inventory, this.propertyDelegate);
	}
	
	public Text getDisplayName() {
		return new TranslatableText("container.lectern", new Object[0]);
	}
}
