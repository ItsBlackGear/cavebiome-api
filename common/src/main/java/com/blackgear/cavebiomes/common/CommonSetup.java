package com.blackgear.cavebiomes.common;

import com.blackgear.cavebiomes.core.platform.common.BiomeManager;

public class CommonSetup {
    public static void onInstance() {

    }

    public static void postInstance() {
        BiomeManager.bootstrap();
    }
}