# Boundless-Forging
A Minecraft Spigot plugin that removes the "Too expensive" anvil experience cap by clamping the cost.

## How it works
This plugin aims to provide a vanilla experience, so no extra steps are required compared to using an anvil normally. Just forge to your heart's content, and if an item is "Too Expensive" (you won't see it), the price will just be 39 and you'll be able to complete the forging.

## Why 39?
In vanilla minecraft, the maximum ammount of XP levels that an anvil event can accept before displaying the "Too Expensive" message is 39. If an item requires more than 39 levels, the plugin clamps it to 39 in order for the forge to be accepted. While the maximum ammount of levels can be changed with Spigot, the vanilla client will still display the "Too Expensive" message. Unfortunately, I haven't found a way for the clients to be notified of this change.

## Compatibility
This plugin should be compatible with other plugins that modify the max ammount of levels that an anvil can accept. If you are still seeing the "Too Expensive" message, set `forceMaxRepairCost` to `true` in the `config.yml` file of this plugin.
