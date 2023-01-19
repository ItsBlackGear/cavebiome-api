package com.blackgear.cavebiomes.core.forge;

import com.blackgear.cavebiomes.core.CaveBiomeAPI;
import net.minecraftforge.fml.common.Mod;

@Mod(CaveBiomeAPI.MOD_ID)
public class CaveBiomeAPIForge {
    public CaveBiomeAPIForge() {
        CaveBiomeAPI.bootstrap();
    }
}