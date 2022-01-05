package lemmensthijmen.tntrun.Commands;

import lemmensthijmen.tntrun.Manager;
import lemmensthijmen.tntrun.TntRun;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    public TestCommand() {
        TntRun.getTntrun().getCommand("test").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;



        return false;
    }
}
