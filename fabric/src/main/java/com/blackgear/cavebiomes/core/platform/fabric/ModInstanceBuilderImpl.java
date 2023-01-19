package com.blackgear.cavebiomes.core.platform.fabric;

import com.blackgear.cavebiomes.core.platform.Environment;
import com.blackgear.cavebiomes.core.platform.ModInstance;

public class ModInstanceBuilderImpl {
    public static ModInstance builder(String modId, Runnable common, Runnable postCommon, Runnable client, Runnable postClient) {
        return new ModInstance(modId, common, postCommon, client, postClient) {
            @Override public void bootstrap() {
                this.onCommon.run();
                this.onPostCommon.run();
                if (Environment.isClientSide()) {
                    this.onClient.run();
                    this.onPostClient.run();
                }
            }
        };
    }
}