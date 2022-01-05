package lemmensthijmen.tntrun.Commands;

import lemmensthijmen.tntrun.TntRun;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TntToggle implements CommandExecutor {

    public TntToggle() {
        TntRun.getTntrun().getCommand("tnt").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (TntRun.getTntrun().getToggle()) {
                TntRun.getTntrun().setToggle(false);
                player.sendMessage("tnt run uit");
            } else {
                TntRun.getTntrun().setToggle(true);
                player.sendMessage("tnt run aan");
            }
        } else {
            TntRun.getTntrun().getLogger().info("you are not a player!");
        }

        return false;
    }
}
