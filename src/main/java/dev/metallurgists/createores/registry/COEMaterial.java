package dev.metallurgists.createores.registry;

import dev.metallurgists.createores.COE;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public enum COEMaterial {
    DIAMOND,
    EMERALD,
    REDSTONE,
    ;

    public final String name;

    /**
     * True is this metal generates naturally. If false, the following tags are nonsense:
     * <ul>
     *     <li>{@link #ores}</li>
     *     <li>{@link #rawOres}</li>
     *     <li>{@link #rawStorageBlocks}</li>
     * </ul>
     */
    public final boolean isNatural;

    public final ItemLikeTag ores;
    public final TagKey<Item> rawOres;
    public final ItemLikeTag rawStorageBlocks;

    COEMaterial() {
        this(true);
    }

    COEMaterial(boolean natural) {
        this.name = Lang.asId(name());

        this.isNatural = natural;

        this.ores = new ItemLikeTag("ores/" + this.name);
        this.rawOres = itemTag("raw_materials/" + this.name);
        this.rawStorageBlocks = new ItemLikeTag("storage_blocks/raw_" + this.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    private static TagKey<Item> itemTag(String path) {
        return TagKey.create(Registries.ITEM, COE.asCommon(path));
    }

    private static TagKey<Block> blockTag(String path) {
        return TagKey.create(Registries.BLOCK, COE.asCommon(path));
    }

    public record ItemLikeTag(TagKey<Item> items, TagKey<Block> blocks) {
        private ItemLikeTag(String path) {
            this(itemTag(path), blockTag(path));
        }
    }
}
