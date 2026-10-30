package com.tom.createores;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(CreateOreExcavation.MODID)
public class CreateOreExcavation {
    public static final String MODID = "createoreexcavation";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateOreExcavation(IEventBus bus, ModContainer modContainer) {}
}
