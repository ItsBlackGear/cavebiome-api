package com.blackgear.cavebiomeapi.common;

import com.blackgear.cavebiomeapi.core.platform.common.BiomeManager;

public class CommonSetup {
    public static void onInstance() {

    }

    public static void postInstance() {
        BiomeManager.bootstrap();
    }
}