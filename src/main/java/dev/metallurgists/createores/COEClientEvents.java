package dev.metallurgists.createores;

import dev.metallurgists.createores.registry.COEDataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

@EventBusSubscriber(Dist.CLIENT)
public class COEClientEvents {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item.TooltipContext context = event.getContext();
        List<Component> tooltip = event.getToolTip();
        TooltipFlag flag = event.getFlags();
        for (var type : COEDataComponents.DATA_COMPONENTS.getEntries()) {
            var comp = stack.get(type);
            if (comp instanceof TooltipProvider tooltipProvider) {
                tooltipProvider.addToTooltip(context, tooltip::add, flag);
            }
        }
    }
}
