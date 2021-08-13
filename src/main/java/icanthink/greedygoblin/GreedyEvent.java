package icanthink.greedygoblin;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class GreedyEvent{

    public static void run(Player player) {
        Random rand = new Random();
        GreedyGoblin.AddGreed(player,0);
        float greed = GreedyGoblin.greed.get(player.getUniqueId().toString());
        if (rand.nextInt(101) < greed){
            boolean chosen = false;
            while (!chosen){
                if (greed > 10f){
                    if (rand.nextInt(21) == 0){
                        player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                        chosen = true;
                    }
                    if (rand.nextInt(10) == 0){
                        player.getInventory().addItem(new ItemStack(Material.DEAD_BUSH));
                        chosen = true;
                    }
                }
                if (greed > 30f){
                    if (rand.nextInt(21) == 0){
                        player.damage(2.0);
                        chosen = true;
                    }
                    if (rand.nextInt(21) == 0){
                        player.getWorld().strikeLightning(player.getLocation());
                        chosen = true;
                    }
                }
                if (greed > 30f){
                    if (rand.nextInt(21) == 0){
                        player.getLocation().add(0,3,0);
                        chosen = true;
                    }
                    if (rand.nextInt(21) == 0){
                        player.setExp(player.getExp() - 30);
                        chosen = true;
                    }
                }
                if (greed > 50f){
                    if (rand.nextInt(21) == 0){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON,300,0));
                        chosen = true;
                    }
                    if (rand.nextInt(21) == 0){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,300,0));
                        chosen = true;
                    }
                }
                if (greed > 80f){
                    if (rand.nextInt(21) == 0){
                        player.sendMessage("[Greedy Goblin] I am the Greedy Goblin and you have been toooo greedy!!! HEHEHEhehehe");
                        chosen = true;
                    }
                }
            }
        }
    }
}
