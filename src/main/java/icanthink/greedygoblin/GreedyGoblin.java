package icanthink.greedygoblin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Hashtable;

public final class GreedyGoblin extends JavaPlugin {
    public static Hashtable<String, Float> greed = new Hashtable<String, Float>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PluginEvents(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void AddGreed(Player player, float amount){
        if (!GreedyGoblin.greed.containsKey(player.getUniqueId().toString())){
            GreedyGoblin.greed.put(player.getUniqueId().toString(), 0f);
        }
        GreedyGoblin.greed.put(player.getUniqueId().toString(), GreedyGoblin.greed.get(player.getUniqueId().toString()) + amount);
        if (GreedyGoblin.greed.get(player.getUniqueId().toString()) > 100f){
            GreedyGoblin.greed.put(player.getUniqueId().toString(),100f);
        }
    }
}
