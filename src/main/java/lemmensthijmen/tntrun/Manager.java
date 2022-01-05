package lemmensthijmen.tntrun;

import lemmensthijmen.tntrun.enums.GameStates;
import org.bukkit.entity.Player;

public class Manager {

    private static Area area;

    public Manager() {
        area = new Area();
    }

    public static boolean isPlaying(Player player) {
        return area.getPlayers().contains(player.getUniqueId());
    }

    public static boolean isPlayerJoin() {
        return area.getStates() == GameStates.PLAYERJOIN;
    }

    public static Area getArea() {
        return area;
    }
}
