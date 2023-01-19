package com.blackgear.cavebiomeapi.core;

import com.blackgear.cavebiomeapi.client.ClientSetup;
import com.blackgear.cavebiomeapi.common.CommonSetup;
import com.blackgear.cavebiomeapi.core.platform.ModInstance;

public class CaveBiomeAPI {
    public static final String MOD_ID = "cavebiomeapi";
    public static final ModInstance INSTANCE = ModInstance.create(MOD_ID).common(CommonSetup::onInstance).postCommon(CommonSetup::postInstance).client(ClientSetup::onInstance).postClient(ClientSetup::postInstance).build();

    public static void bootstrap() {
        INSTANCE.bootstrap();
    }
}