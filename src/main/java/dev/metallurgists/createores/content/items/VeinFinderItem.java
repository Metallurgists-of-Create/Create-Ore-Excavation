package dev.metallurgists.createores.content.items;

import dev.metallurgists.createores.COE;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;

public class VeinFinderItem extends Item {
    public VeinFinderItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if(!level.isClientSide)
            return detect(level, player.blockPosition(), player);

        return InteractionResultHolder.success(player.getItemInHand(interactionHand));
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        if(!ctx.getLevel().isClientSide)
            return detect(ctx.getLevel(), ctx.getClickedPos(), ctx.getPlayer()).getResult();

        return InteractionResult.SUCCESS;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return false;//(pStack.get(CreateOreExcavation.ORE_VEIN_FINDER_FILTERED_COMPONENT) == Boolean.TRUE) || super.isFoil(pStack);
    }

    private InteractionResultHolder<ItemStack> detect(Level level, BlockPos pos, Player player) {
        ItemStack atlas = ItemStack.EMPTY;
        for (int i = 0;i < player.getInventory().getContainerSize(); i++) {
            ItemStack is = player.getInventory().getItem(i);
            //if (is.getItem() == COEItems.VEIN_ATLAS.get()) {
            //    atlas = is;
            //    break;
            //}
        }
        //var atlasData = atlas.get(COEDataComponents.ORE_VEIN_ATLAS);
        //Predicate<RecipeHolder<VeinRecipe>> filter = atlasData != null ? makeFilter(atlasData) : a -> true;
        ChunkPos center = new ChunkPos(pos);
        //OreData found = null;
        //List<OreData> nearby = new ArrayList<>();
        //int near = Config.veinFinderNear;
        //for(int x = -near;x <= near;x++) {
        //    for(int z = -near;z <= near;z++) {
        //        OreData d = OreDataAttachment.getData(level.getChunk(center.x + x, center.z + z));
        //        if(x == 0 && z == 0)found = d;
        //        else nearby.add(d);
        //    }
        //}
        player.displayClientMessage(Component.translatable("chat.coe.veinFinder.info"), false);
        player.displayClientMessage(Component.translatable("chat.coe.veinFinder.pos", center.x, center.z), false);
        RecipeManager m = level.getRecipeManager();
        Component f;
        Component nothing = Component.translatable("chat.coe.veinFinder.nothing");
        Component comma = Component.literal(", ");
        //if(found != null && found.getRecipe(m) != null)f = found.getRecipe(m).value().getName();
        //else f = nothing;
        player.displayClientMessage(Component.translatable("chat.coe.veinFinder.found", nothing), false);

        CompoundTag infoTag = new CompoundTag();
        ResourceLocation id = COE.asResource("bleh");//found.getRecipeId();
        if (id != null)infoTag.putString("found", id.toString());
        infoTag.putInt("x", pos.getX());
        infoTag.putInt("z", pos.getZ());

        ResourceLocation rl = COE.asResource("bleh");//nearby.stream().map(d -> d.getRecipe(m)).filter(r -> r != null).map(RecipeHolder::id).findFirst().orElse(null);
        if (rl != null) {
            infoTag.putString("nearby", rl.toString());
        }

        //f = nearby.stream().map(d -> d.getRecipe(m)).filter(r -> r != null).map(r -> r.value().getName()).collect(ComponentJoiner.joining(nothing, comma));
        //player.displayClientMessage(Component.translatable("chat.coe.veinFinder.nearby", nothing), false);

        //Pair<BlockPos, RecipeHolder<VeinRecipe>> nearest = OreVeinGenerator.getPicker((ServerLevel) level).locate(pos, (ServerLevel) level, 16, filter);
        //if(nearest != null) {
        //    BlockPos at = nearest.getFirst();
        //    int i = Math.round(RandomSpreadGenerator.distance2d(at, pos) / Config.veinFinderFar) * Config.veinFinderFar;
        //    player.displayClientMessage(Component.translatable("chat.coe.veinFinder.far", Component.translatable("chat.coe.veinFinder.distance", nearest.getSecond().value().getName(), i)), false);
        //    infoTag.putString("far", nearest.getSecond().id().toString());
        //    infoTag.putInt("dist", i);
        //} else {
        //    player.displayClientMessage(Component.translatable("chat.coe.veinFinder.far", nothing), false);
        //}
        //NetworkHandler.sendTo((ServerPlayer) player, new OreVeinInfoPacket(infoTag));
        //player.getCooldowns().addCooldown(this, Config.veinFinderCd);
        return InteractionResultHolder.success(player.getItemInHand(player.getUsedItemHand()));
    }
}
