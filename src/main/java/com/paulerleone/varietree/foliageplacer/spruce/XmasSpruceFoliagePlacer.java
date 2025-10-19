package com.paulerleone.varietree.foliageplacer.spruce;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.paulerleone.varietree.foliageplacer.ModFoliagePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class XmasSpruceFoliagePlacer extends FoliagePlacer {
    public static final Codec<XmasSpruceFoliagePlacer> CODEC = RecordCodecBuilder.create(XmasSpruceFoliagePlacerInstance
            -> foliagePlacerParts(XmasSpruceFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(XmasSpruceFoliagePlacerInstance, XmasSpruceFoliagePlacer::new));
    private final int height;

    public XmasSpruceFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.XMAS_SPRUCE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config,
                                 int pMaxFreeTreeHeight, FoliageAttachment attachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {

        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 0, 2, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 0, 1, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 1, 0, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 1, -1, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 1, -2, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -3, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -4, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -5, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -6, attachment.doubleTrunk());

    }

    @Override
    public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int xOffset, int yOffset, int zOffset,
                                         int radius, boolean isDoubleTrunk) {
        return (  xOffset == radius && zOffset == radius && yOffset == 0) ||
                (  xOffset == radius && zOffset == radius && yOffset == -1) ||
                ( (xOffset + zOffset)>2 && yOffset == -3) ||
                (  xOffset == radius && zOffset == radius && yOffset == -4) ||
                (  xOffset == radius && zOffset == radius && yOffset == -6) ;
    }
}
