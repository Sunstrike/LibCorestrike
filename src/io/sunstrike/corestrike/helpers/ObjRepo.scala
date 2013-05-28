package io.sunstrike.corestrike.helpers

import java.util.logging.Logger
import cpw.mods.fml.common.FMLCommonHandler

/*
 * ObjRepo
 * io.sunstrike.corestrike.helpers
 */

/**
 * Static object repository
 *
 * @author Sunstrike
 */
object ObjRepo {

    val logger = Logger.getLogger("LibCorestrike")
    val side = FMLCommonHandler.instance().getSide

}
