package com.blackgear.cavebiomes.core.fabric;

import com.blackgear.cavebiomes.core.CaveBiomeAPI;
import net.fabricmc.api.ModInitializer;

public class CaveBiomeAPIFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CaveBiomeAPI.bootstrap();
    }
}