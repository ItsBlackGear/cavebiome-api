package com.blackgear.cavebiomes.core.platform.common.forge;

import com.blackgear.cavebiomes.core.CaveBiomeAPI;
import com.blackgear.cavebiomes.core.platform.common.IntegrationRegistry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(modid = CaveBiomeAPI.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class IntegrationRegistryImpl {
    private static final Set<Consumer<PlayerInteractEvent.RightClickBlock>> INTERACT_ON_BLOCK = ConcurrentHashMap.newKeySet();

    public static void interaction(IntegrationRegistry.Interaction interaction) {
        INTERACT_ON_BLOCK.add(event -> event.setCancellationResult(interaction.of(new UseOnContext((Player)event.getEntity(), event.getHand(), event.getHitVec()))));
    }

    @SubscribeEvent
    public static void onBlockInteraction(PlayerInteractEvent.RightClickBlock event) {
        INTERACT_ON_BLOCK.forEach(consumer -> consumer.accept(event));
    }
}