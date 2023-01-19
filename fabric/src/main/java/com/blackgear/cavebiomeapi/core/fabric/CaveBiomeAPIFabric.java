package com.blackgear.cavebiomeapi.core.fabric;

import com.blackgear.cavebiomeapi.core.CaveBiomeAPI;
import net.fabricmc.api.ModInitializer;

public class CaveBiomeAPIFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CaveBiomeAPI.bootstrap();
    }
}