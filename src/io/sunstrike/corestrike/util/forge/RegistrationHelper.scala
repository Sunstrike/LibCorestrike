package io.sunstrike.corestrike.util.forge

import net.minecraft.block.Block
import cpw.mods.fml.common.registry.{LanguageRegistry, GameRegistry}
import net.minecraft.item.{Item, ItemBlock}
import net.minecraftforge.common.MinecraftForge
import net.minecraft.tileentity.TileEntity

/*
 * RegistrationHelper
 * io.sunstrike.corestrike.util.forge
 */

/**
 * Helper methods (static importable) for registering blocks/items/etc with Forge's registries.
 *
 * @author Sunstrike
 */
object RegistrationHelper {

    /**
     * Registers a block with Minecraft Forge
     *
     * Handles communication with GameRegistry, LanguageRegistry and marks the block as minable.
     *
     * @param block Block to register
     * @param id The blocks ID
     * @param internalName The internal name for the block
     * @param humanName The human-readable name for the block
     * @param modId The mod ID for the calling mod (so Forge/NEI correctly assosciate the block to the right mod)
     */
    def registerBlock(block:Block, id:Int, internalName:String, humanName:String, modId:String) {
        GameRegistry.registerBlock(block, classOf[ItemBlock], internalName, modId) // classOf[ItemBlock] -- This is how FML does it, so we are too.
        LanguageRegistry.addName(block, humanName)
        MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0)
    }

    /**
     * Registers a block with Minecraft Forge WITHOUT LanguageRegistry entries
     *
     * Handles communication with GameRegistry and marks the block as minable.
     * This variant is useful for metadata-based blocks.
     *
     * @param block Block to register
     * @param id The blocks ID
     * @param internalName The internal name for the block
     * @param modId The mod ID for the calling mod (so Forge/NEI correctly assosciate the block to the right mod)
     */
    def registerBlockWithoutLang(block:Block, id:Int, internalName:String, modId:String) {
        GameRegistry.registerBlock(block, classOf[ItemBlock], internalName, modId) // classOf[ItemBlock] -- This is how FML does it, so we are too.
        MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0)
    }

    /**
     * Registers a TileEntity with Minecraft Forge.
     *
     * Only wraps one function on GameRegistry, but is provided to allow static importing and managing all
     * registrations with this helper.
     *
     * @param te The TileEntity class
     * @param internalName The internal name for the TE
     */
    def registerTE(te:Class[_<:TileEntity], internalName:String) {
        GameRegistry.registerTileEntity(te, internalName)
    }

    /**
     * Registers an item with Minecraft Forge.
     *
     * Handles communication with GameRegistry and LanguageRegistry.
     *
     * @param item Item to register
     * @param internalName The items internal name
     * @param humanName The in-game human-readable name of the item
     * @param modId The mod ID for the calling mod (so Forge/NEI correctly assosciate the item to the right mod)
     */
    def registerItem(item:Item, internalName:String, humanName:String, modId:String) {
        GameRegistry.registerItem(item, internalName, modId)
        LanguageRegistry.addName(item, humanName)
    }

    /**
     * Registers an item with Minecraft Forge without invoking LanguageRegistry.
     *
     * Handles communication with GameRegistry. This variant is useful for metadata-based items.
     *
     * @param item Item to register
     * @param internalName The items internal name
     * @param modId The mod ID for the calling mod (so Forge/NEI correctly assosciate the item to the right mod)
     */
    def registerItemWithoutLang(item:Item, internalName:String, modId:String) {
        GameRegistry.registerItem(item, internalName, modId)
    }

}
