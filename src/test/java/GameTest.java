import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "First", 10);
    Player player2 = new Player(2, "Second", 2);
    Player player3 = new Player(3, "Third", 3);
    Player player4 = new Player(4, "Fourth", 4);
    Player player5 = new Player(5, "Fifth", 5);
    Player player6 = new Player(6, "Sixth", 6);
    Player playerFour = new Player(14, "Fourteenth", 4);

    @Test
    public void shouldFillArrayListAndReturnStrenght() {
        Game gameTour = new Game();
        gameTour.register(player1);
        gameTour.register(player2);
        gameTour.register(player3);
        gameTour.register(player4);
        gameTour.register(player5);
        gameTour.register(player6);

        int[] actual = new int[6];

        actual[0] = gameTour.strenghtByName("First");
        actual[1] = gameTour.strenghtByName("Second");
        actual[2] = gameTour.strenghtByName("Third");
        actual[3] = gameTour.strenghtByName("Fourth");
        actual[4] = gameTour.strenghtByName("Fifth");
        actual[5] = gameTour.strenghtByName("Sixth");

        int[] expected = {10, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisteredExceptionCorrectWork() {
        Game gameTour = new Game();
        gameTour.register(player1);
        gameTour.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gameTour.strenghtByName("Zero");
        });
    }

    @Test
    public void shouldGetWinnerByStrenght() {
        Game gameTour = new Game();
        gameTour.register(player1);
        gameTour.register(player2);
        gameTour.register(player3);
        gameTour.register(player4);
        gameTour.register(playerFour);

        int[] actual = new int[3];

        actual[0] = gameTour.round("First", "Second");
        actual[1] = gameTour.round("Second", "Third");
        actual[2] = gameTour.round("Fourth", "Fourteenth");

        int[] expected = {1, 2, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

}
