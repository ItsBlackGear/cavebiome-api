package com.blackgear.cavebiomes.core.platform.common;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public record RegistryBuilder(String modId) {
    public <T> Sample<T> create(String key, Supplier<T> bootstrap) {
        ResourceKey<Registry<T>> resource = ResourceKey.createRegistryKey(new ResourceLocation(this.modId, key));
        return new Sample<>(resource, Registry.registerSimple(resource, bootstrap));
    }

    public record Sample<T>(ResourceKey<Registry<T>> resource, Registry<T> registry) {}
}