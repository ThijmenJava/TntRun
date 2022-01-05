package lemmensthijmen.tntrun.Util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Random;

public class Replace {

    private static Random random = new Random();

    private static void replace(int y, boolean gravelSand){
        Location loc = new Location(Bukkit.getWorld("world"),785, 0,-99);
        for (int x= 0; x < 48; x++){
            for (int z = 0; z < 48; z++){
                if (gravelSand) {
                    if (random.nextInt(2) < 1){
                        Block block = loc.getBlock().getRelative(x, y, z);
                        block.setType(Material.SAND);
                    } else {
                        Block block = loc.getBlock().getRelative(x, y, z);
                        block.setType(Material.GRAVEL);
                    }
                }
                if (!gravelSand) {
                    Block block = loc.getBlock().getRelative(x, y, z);
                    block.setType(Material.TNT);
                }
            }
        }
    }

    public static void replaceAll() {
        Replace.replace(119, true);
        Replace.replace(118, false);
        Replace.replace(108, true);
        Replace.replace(107, false);
        Replace.replace(95, true);
        Replace.replace(94, false);
        Replace.replace(83, true);
        Replace.replace(82, false);
        Replace.replace(71, true);
        Replace.replace(70, false);
    }
}
