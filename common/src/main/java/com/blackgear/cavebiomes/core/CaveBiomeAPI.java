package com.blackgear.cavebiomes.core;

import com.blackgear.cavebiomes.client.ClientSetup;
import com.blackgear.cavebiomes.common.CommonSetup;
import com.blackgear.cavebiomes.core.platform.ModInstance;

public class CaveBiomeAPI {
    public static final String MOD_ID = "cavebiomes";
    public static final ModInstance INSTANCE = ModInstance.create(MOD_ID).common(CommonSetup::onInstance).postCommon(CommonSetup::postInstance).client(ClientSetup::onInstance).postClient(ClientSetup::postInstance).build();

    public static void bootstrap() {
        INSTANCE.bootstrap();
    }
}