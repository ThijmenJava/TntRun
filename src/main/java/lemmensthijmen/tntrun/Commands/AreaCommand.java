package lemmensthijmen.tntrun.Commands;

import lemmensthijmen.tntrun.Manager;
import lemmensthijmen.tntrun.TntRun;
import lemmensthijmen.tntrun.enums.GameStates;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AreaCommand implements CommandExecutor {

    public AreaCommand() {
        TntRun.getTntrun().getCommand("tnt").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            switch (args[0]) {
                case "join" -> {
                    if (Manager.isPlaying(player)) {
                        player.sendMessage(ChatColor.RED + "you are in the game!");
                    } else {
                        Manager.getArea().addPlayers(player);
                    }
                }
                case "leave" -> {
                    if (Manager.getArea().getStates() == GameStates.COUNTDOWN) {
                        Manager.getArea().removePlayers(player);
                    } else {
                        player.sendMessage(ChatColor.RED + "Game is live!");
                    }
                }
                case "reset" -> {
                    if (player.isOp()) {
                        Manager.getArea().reset();
                    }
                }
                default -> player.sendMessage(ChatColor.RED + "Wrong command!");
            }
        }

        return false;
    }
}
