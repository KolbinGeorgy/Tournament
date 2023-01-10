import java.util.ArrayList;

public class Game {
    private ArrayList<Player> playerList = new ArrayList<Player>();

    public void register(Player player) {
        playerList.add(player);
    }

    public int strenghtByName(String name) {
        for (Player player : playerList) {
            if (player.getName() == name) {
                return player.getStrength();
            }
        }
        throw new NotRegisteredException("Player with name: " + name + " is not registered!");
    }

    public int round(String playerName1, String playerName2) {
        if (strenghtByName(playerName1) > strenghtByName(playerName2)) {
            return 1;
        } else if (strenghtByName(playerName1) < strenghtByName(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}