package com.blakebr0.mysticalagradditions.world;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public final class ModWorldgenRegistration {
    private static final RuleTest END_STONE_RULE_TEST = new BlockMatchTest(Blocks.END_STONE);

    public static void onCommonSetup() {
        int size, rate, minY, maxY;
        List<OreConfiguration.TargetBlockState> targets;
        ConfiguredFeature<OreConfiguration, ?> feature;

        size = ModConfigs.NETHER_PROSPERITY_SPAWN_SIZE.get();
        minY = ModConfigs.NETHER_PROSPERITY_SPAWN_MIN_Y.get();
        maxY = ModConfigs.NETHER_PROSPERITY_SPAWN_MAX_Y.get();
        rate = ModConfigs.NETHER_PROSPERITY_SPAWN_RATE.get();
        targets = List.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_PROSPERITY_ORE.get().defaultBlockState()));
        feature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(targets, size));

        var placedNetherProsperityOreFeature = new PlacedFeature(Holder.direct(feature), List.of(
                CountPlacement.of(rate),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(minY), VerticalAnchor.absolute(maxY)),
                BiomeFilter.biome()
        ));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_prosperity_ore"), feature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_prosperity_ore"), placedNetherProsperityOreFeature);

        size = ModConfigs.NETHER_INFERIUM_SPAWN_SIZE.get();
        minY = ModConfigs.NETHER_INFERIUM_SPAWN_MIN_Y.get();
        maxY = ModConfigs.NETHER_INFERIUM_SPAWN_MAX_Y.get();
        rate = ModConfigs.NETHER_INFERIUM_SPAWN_RATE.get();
        targets = List.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_INFERIUM_ORE.get().defaultBlockState()));
        feature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(targets, size));

        var placedNetherInferiumOreFeature = new PlacedFeature(Holder.direct(feature), List.of(
                CountPlacement.of(rate),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(minY), VerticalAnchor.absolute(maxY)),
                BiomeFilter.biome()
        ));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_inferium_ore"), feature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_inferium_ore"), placedNetherInferiumOreFeature);

        size = ModConfigs.END_PROSPERITY_SPAWN_SIZE.get();
        minY = ModConfigs.END_PROSPERITY_SPAWN_MIN_Y.get();
        maxY = ModConfigs.END_PROSPERITY_SPAWN_MAX_Y.get();
        rate = ModConfigs.END_PROSPERITY_SPAWN_RATE.get();
        targets = List.of(OreConfiguration.target(END_STONE_RULE_TEST, ModBlocks.END_PROSPERITY_ORE.get().defaultBlockState()));
        feature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(targets, size));

        var placedEndProsperityOreFeature = new PlacedFeature(Holder.direct(feature), List.of(
                CountPlacement.of(rate),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(minY), VerticalAnchor.absolute(maxY)),
                BiomeFilter.biome()
        ));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_prosperity_ore"), feature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_prosperity_ore"), placedEndProsperityOreFeature);

        size = ModConfigs.END_INFERIUM_SPAWN_SIZE.get();
        minY = ModConfigs.END_INFERIUM_SPAWN_MIN_Y.get();
        maxY = ModConfigs.END_INFERIUM_SPAWN_MAX_Y.get();
        rate = ModConfigs.END_INFERIUM_SPAWN_RATE.get();
        targets = List.of(OreConfiguration.target(END_STONE_RULE_TEST, ModBlocks.END_INFERIUM_ORE.get().defaultBlockState()));
        feature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(targets, size));

        var placedEndInferiumOreFeature = new PlacedFeature(Holder.direct(feature), List.of(
                CountPlacement.of(rate),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(minY), VerticalAnchor.absolute(maxY)),
                BiomeFilter.biome()
        ));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_inferium_ore"), feature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_inferium_ore"), placedEndInferiumOreFeature);
    }
}
