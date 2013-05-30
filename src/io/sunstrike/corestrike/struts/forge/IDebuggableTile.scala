package io.sunstrike.corestrike.struts.forge

import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer

/*
 * IDebuggableTile
 * io.sunstrike.corestrike.struts.forge
 */

/**
 * Trait for TileEntities which can be debugged via CSBlock's debug hook.
 *
 * @author Sunstrike
 */
trait IDebuggableTile {

    /**
     * Debug hook for CSBlock.
     *
     * Used to send debugging information to the acting player. Send messages with player.addChatMessage, preferably in form "[TileClassName] Debug message".
     *
     * @param world World the player is in.
     * @param player The player acting to get debug info.
     */
    def sendDebugToPlayer(world: World, player:EntityPlayer)

}
