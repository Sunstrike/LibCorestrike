package io.sunstrike.corestrike.struts.forge

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.client.renderer.texture.IconRegister

/*
 * CSBlock
 * io.sunstrike.corestrike.struts.forge
 */

/**
 * Base class for blocks with debug functionality built in (hit with stick)
 *
 * @author Sunstrike
 */
class CSBlock(startId:Int, mat:Material) extends Block(startId, mat) {

    //=== Construction/Vars =========================
    val id = startId

    //=== Functions =================================
    /**
     * Debug hook inside onBlockClicked to detect sticks.
     *
     * Subclasses must include a super call to retain the debug helper.
     *
     * @param world The current world
     * @param x x coord
     * @param y y coord
     * @param z z coord
     * @param player Player clicking it
     */
    override def onBlockClicked(world: World, x: Int, y: Int, z: Int, player: EntityPlayer) {
        super.onBlockClicked(world, x, y, z, player)
        if (world.isRemote) return

        val held:ItemStack = player.getCurrentEquippedItem
        if (held == null || held.getItem != Item.stick) return

        val te:TileEntity = world.getBlockTileEntity(x, y, z)
        te match {
            case t:IDebuggableTile => t.sendDebugToPlayer(world, player)
            case _ => return
        }
    }

}
