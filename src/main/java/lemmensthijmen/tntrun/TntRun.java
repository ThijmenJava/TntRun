package lemmensthijmen.tntrun;

import lemmensthijmen.tntrun.Commands.AreaCommand;
import lemmensthijmen.tntrun.Commands.Reset;
import lemmensthijmen.tntrun.Commands.TestCommand;
import lemmensthijmen.tntrun.GameLisnener.DeathEvent;
import lemmensthijmen.tntrun.GameLisnener.TntEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TntRun extends JavaPlugin {

    private static TntRun tntrun;
    private boolean toggle;

    @Override
    public void onEnable() {
        TntRun.tntrun = this;
        new Manager();

        new TntEvent();
        // Plugin startup logic

        new AreaCommand();
        new TestCommand();
        new Reset();
        new DeathEvent();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TntRun getTntrun() {
        return tntrun;
    }

    public boolean getToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }
}
