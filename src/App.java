import java.util.ArrayList;

import com.github.fourinline.Game;
import com.github.fourinline.domain.Board;
import com.github.fourinline.domain.Player;
import com.github.fourinline.domain.Board.Size;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Board board = new Board(Size.ROW7_COLUMN10);
        ArrayList<Player> players = new ArrayList<>();
        Player p1 = new Player();
        Player p2 = new Player();
        players.add(p1);
        players.add(p2);

        Game game = new Game(board, players);
        game.start();
    }
}
