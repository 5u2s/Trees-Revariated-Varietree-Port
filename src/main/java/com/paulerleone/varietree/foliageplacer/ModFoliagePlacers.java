package com.paulerleone.varietree.foliageplacer;

import com.paulerleone.varietree.Varietree;
import com.paulerleone.varietree.foliageplacer.birch.BigBirchFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.birch.LollipopBirchFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.birch.RodBirchFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.oak.LollipopOakFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.oak.SandwichOakFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.oak.ShortOakFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.spruce.CandleSpruceFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.spruce.XmasSpruceFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, Varietree.MODID);

    public static final RegistryObject<FoliagePlacerType<BigBirchFoliagePlacer>> BIG_BIRCH_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("big_birch_foliage_placer", () -> new FoliagePlacerType<>(BigBirchFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<LollipopBirchFoliagePlacer>> LOLLIPOP_BIRCH_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("lollipop_birch_foliage_placer", () -> new FoliagePlacerType<>(LollipopBirchFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<RodBirchFoliagePlacer>> ROD_BIRCH_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("rod_birch_foliage_placer", () -> new FoliagePlacerType<>(RodBirchFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<LollipopOakFoliagePlacer>> LOLLIPOP_OAK_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("lollipop_oak_foliage_placer", () -> new FoliagePlacerType<>(LollipopOakFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<SandwichOakFoliagePlacer>> SANDWICH_OAK_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("sandwich_oak_foliage_placer", () -> new FoliagePlacerType<>(SandwichOakFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<ShortOakFoliagePlacer>> SHORT_OAK_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("short_oak_foliage_placer", () -> new FoliagePlacerType<>(ShortOakFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<CandleSpruceFoliagePlacer>> CANDLE_SPRUCE_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("candle_spruce_foliage_placer", () -> new FoliagePlacerType<>(CandleSpruceFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<XmasSpruceFoliagePlacer>> XMAS_SPRUCE_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("xmas_spruce_foliage_placer", () -> new FoliagePlacerType<>(XmasSpruceFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
