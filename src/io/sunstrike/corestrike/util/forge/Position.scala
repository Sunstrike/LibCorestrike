package io.sunstrike.corestrike.util.forge

import net.minecraft.world.World
import net.minecraftforge.common.ForgeDirection
import scala.ref.WeakReference

/*
 * Position
 * io.sunstrike.corestrike.util.forge
 */

/**
 * Utility class to store location and optional ForgeDirection.
 *
 * @author Sunstrike
 */
class Position(w:World, xPos:Int, yPos:Int, zPos:Int, d:ForgeDirection) {

    def this(w:World, xPos:Int, yPos:Int, zPos:Int) = this(w, xPos, yPos, zPos, ForgeDirection.UNKNOWN)

    /**
     * This doesn't return a World! .apply() must be called to retrieve the world.
     */
    val world = new WeakReference(w)
    val x = xPos
    val y = yPos
    val z = zPos
    val dir = d

    override def toString = super.toString + " :: w:" + world.apply() + ", x:" + x + ", y:" + y + ", z:" + z + ", dir:" + dir

}
