package dev.metallurgists.createores.content.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class VeinAtlasItem extends Item implements MenuProvider {
    public static final String DISCOVERED = "discovered";
    public static final String EXCLUDE = "exclude";
    public static final String VEINS = "veins";
    public static final String TARGET = "veinTarget";
    public static final String SIZE = "size";
    public static final String DIMENSION = "dim";
    public static final String POS_X = "x";
    public static final String POS_Z = "z";
    public static final String VEIN_ID = "id";
    public static final String HIDE = "hide";

    public VeinAtlasItem(Properties properties) {
        super(properties);
    }

    //public void addVein(Player player, ItemStack is, RecipeHolder<VeinRecipe> vein, DimChunkPos pos, float randomMul) {
    //
    //}

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide) {
            //player.openMenu(this);
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    @Override
    public Component getDisplayName() {
        return getDescription();
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        ItemStack heldItem = player.getMainHandItem();
        return null;//new OreVeinAtlasMenu(Registration.VEIN_ATLAS_MENU.get(), pContainerId, pPlayerInventory, heldItem);
    }

    //public void menuClicked(ItemStack is, Option opt, ResourceLocation id) {
    //
    //}

    //public void menuClicked2(ItemStack is, Option opt, int id) {
    //
    //}
}
