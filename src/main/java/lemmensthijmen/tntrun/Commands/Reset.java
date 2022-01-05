package lemmensthijmen.tntrun.Commands;

import lemmensthijmen.tntrun.Manager;
import lemmensthijmen.tntrun.TntRun;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reset implements CommandExecutor {

    public Reset() {
        TntRun.getTntrun().getCommand("reset").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Manager.getArea().reset();
        return false;
    }
}
