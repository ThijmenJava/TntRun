package lemmensthijmen.tntrun.GameLisnener;

import lemmensthijmen.tntrun.Cuboid;
import lemmensthijmen.tntrun.TntRun;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TntEvent implements Listener {

    private Cuboid cuboid = new Cuboid(
            new Location(Bukkit.getWorld("world"), 785,134,-52),
            new Location(Bukkit.getWorld("world"), 833,70 ,-100)
    );

    public TntEvent() {
        TntRun.getTntrun().getServer().getPluginManager().registerEvents(this, TntRun.getTntrun());
    }

    @EventHandler//blokken onder je weg halen
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location location = player.getLocation();

        double y = location.getY();
        double ysec = location.getY() - 1;
        double x = location.getX() ;
        double z = location.getZ();
        World world = player.getWorld();

        Block block = new Location(world, x, ysec, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockSand = new Location(world, x, y, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockGravel = new Location(world, x, y, z).getBlock().getRelative(BlockFace.DOWN);


        if (TntRun.getTntrun().getToggle()) {
            if (cuboid.contains(location)) {
                if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) {//sand
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(TntRun.getTntrun(), new Runnable() {//delay ding
                        @Override
                        public void run() {
                            blockSand.setType(Material.AIR);
                            block.setType(Material.AIR);

                        }

                    }, 5L);//delay zelf
                }
                if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GRAVEL) {//gravel
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(TntRun.getTntrun(), new Runnable() {
                        @Override
                        public void run() {
                            blockGravel.setType(Material.AIR);
                            block.setType(Material.AIR);
                        }//delay ding

                    }, 5L);//delay zelf
                }
            }
        }
    }
}
