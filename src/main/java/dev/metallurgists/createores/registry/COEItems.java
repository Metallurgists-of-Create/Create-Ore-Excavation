package dev.metallurgists.createores.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import dev.metallurgists.createores.COE;
import dev.metallurgists.createores.content.items.VeinAtlasItem;
import dev.metallurgists.createores.content.items.VeinFinderItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;

public class COEItems {

    public static final CreateRegistrate REGISTRATE = COE.REGISTRATE.setCreativeTab(COECreativeTabs.COE_MAIN);

    public static final ItemEntry<Item>

            IRON_DRILL = REGISTRATE.item("iron_drill", Item::new)
                    .tag(COETags.Items.DRILLS.tag)
                    .properties(p -> p.stacksTo(1))
                    .register(),
            DIAMOND_DRILL = REGISTRATE.item("diamond_drill", Item::new)
                    .tag(COETags.Items.DRILLS.tag)
                    .properties(p -> p.stacksTo(1))
                    .register(),
            NETHERITE_DRILL = REGISTRATE.item("netherite_drill", Item::new)
                    .tag(COETags.Items.DRILLS.tag)
                    .properties(p -> p.stacksTo(1))
                    .register();

    public static final ItemEntry<Item>

            RAW_DIAMOND = REGISTRATE.item("raw_diamond", Item::new)
                    .tag(COEMaterial.DIAMOND.rawOres, Tags.Items.RAW_MATERIALS).register(),
            RAW_EMERALD = REGISTRATE.item("raw_emerald", Item::new)
                    .tag(COEMaterial.EMERALD.rawOres, Tags.Items.RAW_MATERIALS).register(),
            RAW_REDSTONE = REGISTRATE.item("raw_redstone", Item::new)
                    .tag(COEMaterial.REDSTONE.rawOres, Tags.Items.RAW_MATERIALS).register();

    public static final ItemEntry<VeinFinderItem> VEIN_FINDER = REGISTRATE.item("vein_finder", VeinFinderItem::new)
            .properties(p -> p.stacksTo(1))
            .register();

    public static final ItemEntry<VeinAtlasItem> VEIN_ATLAS = REGISTRATE.item("vein_atlas", VeinAtlasItem::new)
            .properties(p -> p.stacksTo(1))
            .register();


    public static void init() {
    }
}
