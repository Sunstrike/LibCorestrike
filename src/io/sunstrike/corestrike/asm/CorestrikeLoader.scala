package io.sunstrike.corestrike.asm

import cpw.mods.fml.relauncher.IFMLLoadingPlugin
import java.util
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion

/*
 * CorestrikeLoader
 * io.sunstrike.corestrike.asm
 */

/**
 * FML loading plugin for LibCorestrike.
 *
 * @author Sunstrike
 */
@MCVersion(value = "1.5.2")
class CorestrikeLoader extends IFMLLoadingPlugin {

    def getLibraryRequestClass: Array[String] = null

    def getASMTransformerClass: Array[String] = Array("io.sunstrike.corestrike.asm.ASMTransformer")

    def getModContainerClass: String = "io.sunstrike.corestrike.CorestrikeLib"

    def getSetupClass: String = null

    def injectData(data: util.Map[String, AnyRef]) {}

}
