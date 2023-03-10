package com.blackgear.cavebiomes.core.platform.fabric;

import com.blackgear.cavebiomes.core.platform.CoreRegistry;
import net.minecraft.core.Registry;

public class CoreRegistryImpl {
    public static <T> CoreRegistry<T> create(Registry<T> registry, String modId) {
        return new CoreRegistry.SimpleRegistry<>(registry, modId);
    }
}