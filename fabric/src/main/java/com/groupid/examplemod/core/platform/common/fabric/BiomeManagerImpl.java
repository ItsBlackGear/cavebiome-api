package com.groupid.examplemod.core.platform.common.fabric;

import com.groupid.examplemod.core.ExampleMod;
import com.groupid.examplemod.core.platform.common.BiomeContext;
import com.groupid.examplemod.core.platform.common.BiomeManager;
import com.groupid.examplemod.core.platform.common.BiomeWriter;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BiomeManagerImpl {
    public static void bootstrap() {
        BiomeModifications.create(new ResourceLocation(ExampleMod.MOD_ID, "biome_modifier")).add(ModificationPhase.ADDITIONS, context -> true, (selector, modifier) -> BiomeManager.INSTANCE.register(new FabricBiomeWriter(selector, modifier)));
    }

    static class FabricBiomeWriter extends BiomeWriter {
        private final BiomeSelectionContext selector;
        private final BiomeModificationContext modifier;

        FabricBiomeWriter(BiomeSelectionContext selector, BiomeModificationContext modifier) {
            this.selector = selector;
            this.modifier = modifier;
        }

        @Override
        public ResourceLocation name() {
            return this.selector.getBiomeKey().location();
        }

        @Override
        public BiomeContext context() {
            return new BiomeContext() {
                @Override
                public boolean is(Biome.BiomeCategory category) {
                    return FabricBiomeWriter.this.selector.getBiome().getBiomeCategory() == category;
                }

                @Override
                public boolean is(ResourceKey<Biome> biome) {
                    return FabricBiomeWriter.this.selector.getBiomeKey() == biome;
                }
            };
        }

        @Override
        public void feature(GenerationStep.Decoration decoration, ConfiguredFeature<?, ?> feature) {
            this.modifier.getGenerationSettings().addBuiltInFeature(decoration, feature);
        }

        @Override
        public void spawn(MobCategory category, MobSpawnSettings.SpawnerData data) {
            this.modifier.getSpawnSettings().addSpawn(category, data);
        }

        @Override
        public void carver(GenerationStep.Carving carving, ConfiguredWorldCarver<?> carver) {
            this.modifier.getGenerationSettings().addBuiltInCarver(carving, carver);
        }
    }
}