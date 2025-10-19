package com.paulerleone.varietree.foliageplacer.oak;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.paulerleone.varietree.foliageplacer.ModFoliagePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class ShortOakFoliagePlacer extends FoliagePlacer {

    private boolean orientation;

    public static final Codec<ShortOakFoliagePlacer> CODEC = RecordCodecBuilder.create(ShortOakFoliagePlacerInstance
            -> foliagePlacerParts(ShortOakFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(ShortOakFoliagePlacerInstance, ShortOakFoliagePlacer::new));
    private final int height;

    public ShortOakFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.SHORT_OAK_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config,
                                 int pMaxFreeTreeHeight, FoliageAttachment attachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {

        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 1, 0, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -1, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -2, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -3, attachment.doubleTrunk());

    }

    @Override
    public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int xOffset, int yOffset, int zOffset,
                                         int radius, boolean isDoubleTrunk) {
        if (orientation) {
            return (Math.abs(xOffset) == radius && Math.abs(zOffset) == radius && yOffset == 0) || ((Math.abs(xOffset - zOffset)>2 || Math.abs(xOffset + zOffset)>3) && yOffset == -1)
                    || ((Math.abs(xOffset + zOffset)>2 || Math.abs(xOffset - zOffset)>3) && yOffset == -3);
        } else {
            return (Math.abs(xOffset) == radius && Math.abs(zOffset) == radius && yOffset == 0) || ((Math.abs(xOffset + zOffset)>2 || Math.abs(xOffset - zOffset)>3) && yOffset == -1)
                    || ((Math.abs(xOffset - zOffset)>2 || Math.abs(xOffset + zOffset)>3) && yOffset == -3);
        }
    }
}
