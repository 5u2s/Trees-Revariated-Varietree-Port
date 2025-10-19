package com.paulerleone.varietree;

import com.mojang.logging.LogUtils;
import com.paulerleone.varietree.foliageplacer.ModFoliagePlacers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Varietree.MODID)
public class Varietree {
    public static final String MODID = "varietree";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Varietree() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModFoliagePlacers.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
