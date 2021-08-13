package icanthink.greedygoblin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class PluginEvents implements Listener {
    @EventHandler
    public void blockBreak(BlockBreakEvent event){
        Material blockType = event.getBlock().getType();
        if (blockType == Material.DIAMOND_ORE || blockType == Material.DEEPSLATE_DIAMOND_ORE){
            GreedyGoblin.AddGreed(event.getPlayer(),2);
        }
        if (blockType == Material.ANCIENT_DEBRIS){
            GreedyGoblin.AddGreed(event.getPlayer(),4);
        }
        GreedyGoblin.AddGreed(event.getPlayer(),0);
        Random rand = new Random();
        if (rand.nextInt(1000) < GreedyGoblin.greed.get(event.getPlayer().getUniqueId().toString())){
            GreedyEvent.run(event.getPlayer());
        }
    }
    @EventHandler
    public void craftItem(CraftItemEvent event){
        ItemStack itemStack = event.getCurrentItem();
        if (itemStack.getType().toString().contains("DIAMOND")){
            GreedyGoblin.AddGreed((Player) event.getWhoClicked(),2);
        }
    }
    @EventHandler
    public void playerChat(AsyncPlayerChatEvent event){
        if (event.getMessage().equalsIgnoreCase("what the fuck is my greed")){
            event.getPlayer().sendMessage("Your greed is " + GreedyGoblin.greed.get(event.getPlayer().getUniqueId().toString()));
            event.setCancelled(true);
        }
        else if (event.getMessage().contains("greed") || event.getMessage().contains("goblin")){
            GreedyGoblin.AddGreed(event.getPlayer(),1);
        }
    }
    @EventHandler
    public void advancementDone(PlayerAdvancementDoneEvent event){
        GreedyGoblin.AddGreed(event.getPlayer(),0.1f);
    }
}
