package com.paulerleone.varietree.foliageplacer.birch;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.paulerleone.varietree.foliageplacer.ModFoliagePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class BigBirchFoliagePlacer extends FoliagePlacer {
    public static final Codec<BigBirchFoliagePlacer> CODEC = RecordCodecBuilder.create(BigBirchFoliagePlacerInstance
            -> foliagePlacerParts(BigBirchFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(BigBirchFoliagePlacerInstance, BigBirchFoliagePlacer::new));
    private final int height;

    public BigBirchFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.BIG_BIRCH_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config,
                                 int pMaxFreeTreeHeight, FoliageAttachment attachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {

        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 0, 3, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 1, 2, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, 1, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, 0, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -1, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 3, -2, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 3, -3, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 3, -4, attachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int xOffset, int yOffset, int zOffset,
                                         int radius, boolean isDoubleTrunk) {
        return ((xOffset + zOffset)>1 && yOffset == 2) ||
                ((xOffset + zOffset)>2 && yOffset == 1) ||
                ((xOffset + zOffset)>2 && yOffset == 0) ||
                ((xOffset + zOffset)>3 && yOffset == -1) ||
                ((xOffset + zOffset)>3 && yOffset == -2) ||
                (xOffset>1 && zOffset>1 && yOffset == -3) ||
                ((xOffset + zOffset)>3 && yOffset == -4);
    }
}
