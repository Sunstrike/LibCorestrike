package io.sunstrike.corestrike

import cpw.mods.fml.common.{LoadController, ModMetadata, DummyModContainer}
import collection.JavaConversions._
import com.google.common.eventbus.{Subscribe, EventBus}
import io.sunstrike.corestrike.helpers.ObjRepo._
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}

/*
 * CorestrikeLib
 * io.sunstrike.corestrike
 */

/**
 * Corestrike core
 *
 * @since 2013-05-28
 * @author Sunstrike
 */
class CorestrikeLib extends DummyModContainer(new ModMetadata()) {

    //=== Construction ==============================
    val meta = super.getMetadata
    meta.authorList = List("Sunstrike")
    meta.description = "Coremod library for Minecraft Forge"
    meta.modId = "LibCorestrike"
    meta.name = "LibCorestrike"
    meta.version = "@VERSION@"

    //=== Forge EVENT_BUS ===========================
    /**
     * Forge EVENT_BUS registration
     *
     * @param bus The EVENT_BUS
     * @return True if registering
     */
    override def registerBus(bus: EventBus, controller: LoadController): Boolean = {
        bus.register(this)
        logger.info("Attached to Forge event bus.")
        true
    }

    //=== FML events ================================
    /**
     * FML - Preinit event
     *
     * Load configuration data here
     *
     * @param event FML event
     */
    @Subscribe
    def preInit(event:FMLPreInitializationEvent) {

    }

    /**
     * FML - Init event
     *
     * @param event FML event
     */
    @Subscribe
    def init(event:FMLInitializationEvent) {
        logger.info("Initialised LibCorestrike (version @VERSION@).")
    }

    /**
     * FML - Postinit event
     *
     * @param event FML event
     */
    @Subscribe
    def postInit(event:FMLPostInitializationEvent) {

    }

}
