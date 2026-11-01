package dev.metallurgists.createores.registry;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.metallurgists.createores.COE;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

import static dev.metallurgists.createores.COE.MOD_ID;

public class COECreativeTabs {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COE_MAIN = REGISTER.register("tfmg_main", () -> CreativeModeTab.builder()
            .withTabsBefore(AllCreativeModeTabs.BASE_CREATIVE_TAB.getId())
            .title(Component.translatable(COE.asResource("main").toLanguageKey("creative_tab")))
            .icon(() -> COEItems.DIAMOND_DRILL.get().asItem().getDefaultInstance())
            .build());

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == COECreativeTabs.COE_MAIN.get()) {
            for (RegistryEntry<Item, ?> item : COE.REGISTRATE.getAll(Registries.ITEM)) {

                if (!CreateRegistrate.isInCreativeTab(item, COE_MAIN))
                    continue;
                if (blacklist().contains(item))
                    continue;
                if (item.get() instanceof SequencedAssemblyItem)
                    continue;
                event.accept(item.get(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            }
        }
    }

    public static List<RegistryEntry<Item, ? extends Item>> blacklist() {
        List<RegistryEntry<Item, ? extends Item>> list = new ArrayList<>();

        return list;
    }

    @ApiStatus.Internal
    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
