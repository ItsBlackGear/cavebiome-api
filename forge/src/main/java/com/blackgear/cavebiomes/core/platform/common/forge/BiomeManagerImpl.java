package com.blackgear.cavebiomes.core.platform.common.forge;

import com.blackgear.cavebiomes.core.CaveBiomeAPI;
import com.blackgear.cavebiomes.core.platform.common.BiomeContext;
import com.blackgear.cavebiomes.core.platform.common.BiomeManager;
import com.blackgear.cavebiomes.core.platform.common.BiomeWriter;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaveBiomeAPI.MOD_ID)
public class BiomeManagerImpl {
    public static void bootstrap() {}

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeManager.INSTANCE.register(new ForgeBiomeWriter(event));
    }

    static class ForgeBiomeWriter extends BiomeWriter {
        private final BiomeLoadingEvent event;

        ForgeBiomeWriter(BiomeLoadingEvent event) {
            this.event = event;
        }

        @Override
        public ResourceLocation name() {
            return ForgeBiomeWriter.this.event.getName();
        }

        @Override
        public BiomeContext context() {
            return new BiomeContext() {
                @Override
                public boolean is(Biome.BiomeCategory category) {
                    return ForgeBiomeWriter.this.event.getCategory() == category;
                }

                @Override
                public boolean is(ResourceKey<Biome> biome) {
                    return ResourceKey.create(Registry.BIOME_REGISTRY, ForgeBiomeWriter.this.name()) == biome;
                }
            };
        }

        @Override
        public void feature(GenerationStep.Decoration decoration, ConfiguredFeature<?, ?> feature) {
            this.event.getGeneration().addFeature(decoration, feature);
        }

        @Override
        public void spawn(MobCategory category, MobSpawnSettings.SpawnerData data) {
            this.event.getSpawns().addSpawn(category, data);
        }

        @Override
        public void carver(GenerationStep.Carving carving, ConfiguredWorldCarver<?> carver) {
            this.event.getGeneration().addCarver(carving, carver);
        }
    }
}