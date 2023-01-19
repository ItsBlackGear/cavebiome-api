package com.blackgear.cavebiomeapi.core.forge;

import com.blackgear.cavebiomeapi.core.CaveBiomeAPI;
import net.minecraftforge.fml.common.Mod;

@Mod(CaveBiomeAPI.MOD_ID)
public class CaveBiomeAPIForge {
    public CaveBiomeAPIForge() {
        CaveBiomeAPI.bootstrap();
    }
}