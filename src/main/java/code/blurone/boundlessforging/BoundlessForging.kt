package code.blurone.boundlessforging

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareAnvilEvent
import org.bukkit.plugin.java.JavaPlugin
import java.awt.List

class BoundlessForging : JavaPlugin(), Listener {
    override fun onEnable() {
        // Plugin startup logic
        server.pluginManager.registerEvents(this, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler(priority = EventPriority.LOWEST)
    fun anvilEvent(e: PrepareAnvilEvent)
    {
        if (e.inventory.repairCost < e.inventory.maximumRepairCost) return

        e.inventory.maximumRepairCost = Integer.MAX_VALUE
        e.inventory.contents[2]?.itemMeta?.lore = listOf("§c§lCost: $${e.inventory.repairCost}")
    }
}