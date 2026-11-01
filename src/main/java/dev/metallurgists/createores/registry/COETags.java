package dev.metallurgists.createores.registry;

import dev.metallurgists.createores.COE;
import dev.metallurgists.createores.util.COELang;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class COETags {
    public enum NameSpace {
        MOD(COE.MOD_ID),
        COMMON("c")
        ;

        public final String id;
        NameSpace(String id) {
            this.id = id;
        }
    }

    public enum Blocks {
        ;

        public final TagKey<Block> tag;

        Blocks() {
            this(NameSpace.MOD);
        }
        Blocks(NameSpace namespace) {
            this(namespace, null);
        }
        Blocks(NameSpace namespace, String path) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace.id, path == null ? COELang.asId(name()) : path);
            this.tag = BlockTags.create(id);
        }
        Blocks(String namespace, String path) {
            this.tag = BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, path));
        }
    }

    public enum Items {
        DRILLS
        ;

        public final TagKey<Item> tag;

        Items() {
            this(NameSpace.MOD);
        }
        Items(NameSpace namespace) {
            this(namespace, null);
        }
        Items(NameSpace namespace, String path) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace.id, path == null ? COELang.asId(name()) : path);
            this.tag = ItemTags.create(id);
        }
        Items(String namespace, String path) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace, path == null ? COELang.asId(name()) : path);
            this.tag = ItemTags.create(id);
        }
    }
}
