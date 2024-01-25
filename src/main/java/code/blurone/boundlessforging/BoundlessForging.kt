package code.blurone.boundlessforging

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareAnvilEvent
import org.bukkit.inventory.AnvilInventory
import org.bukkit.plugin.java.JavaPlugin

class BoundlessForging : JavaPlugin(), Listener {
    private var realMaxRepairCosts: MutableMap<AnvilInventory, Int> = mutableMapOf()
    private var forceMax = config.getBoolean("forceMaxRepairCost", true)

    override fun onEnable() {
        // Plugin startup logic
        saveDefaultConfig()
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler(priority = EventPriority.LOWEST)
    fun anvilEvent(e: PrepareAnvilEvent)
    {
        if (e.inventory.maximumRepairCost != Int.MAX_VALUE)
            realMaxRepairCosts[e.inventory] = e.inventory.maximumRepairCost

        if (e.inventory.repairCost < realMaxRepairCosts[e.inventory]!!)
        {
            realMaxRepairCosts.remove(e.inventory)?.let { e.inventory.maximumRepairCost = it }
            return
        }

        e.inventory.maximumRepairCost = Int.MAX_VALUE
        e.inventory.repairCost = if (forceMax) 39 else realMaxRepairCosts[e.inventory]!! - 1
    }
}