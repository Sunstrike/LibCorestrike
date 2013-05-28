package io.sunstrike.corestrike.asm

import io.sunstrike.corestrike.helpers.ObjRepo._
import cpw.mods.fml.common.asm.transformers.AccessTransformer
import java.lang.reflect.Method

/*
 * ASMTransformer
 * io.sunstrike.corestrike.asm
 */

/**
 * LibCorestrike ASM transformer.
 *
 * Translated (java -> scala) version of the ASM transformer on the Forge wiki.
 *
 * @author Sunstrike
 */
class ASMTransformer extends AccessTransformer {

    //=== Construction ==============================
    ASMTransformer.instance = this
    ASMTransformer.maps.+("corestr_at.cfg")
    for ( map <- ASMTransformer.maps ) {
        readMapFile(map)
    }

    //=== Functions =================================
    def readMapFile(name:String) {
        logger.info("[ASM Transformer] Adding transformer map: " + name)
        try {
            val e:Method = classOf[AccessTransformer].getDeclaredMethod("readMapFile", classOf[String])
            e.setAccessible(true)
            e.invoke(this, name)
        } catch {
            case ex: Exception => throw new RuntimeException(ex)
        }
    }

}

/**
 * Companion - ASM transformer. For storing variables to be fully FML compliant.
 *
 * @author Sunstrike
 */
object ASMTransformer {

    //=== Variables =================================
    var instance:ASMTransformer = null
    val maps = List[String]()

    //=== Functions =================================
    def addTransformerMap(map:String) {
        if (instance == null) maps.+(map) else instance.readMapFile(map)
    }

}
