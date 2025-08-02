import java.util.ArrayList;

import com.github.fourinline.Game;
import com.github.fourinline.GameAnalyzer;
import com.github.fourinline.domain.Board;
import com.github.fourinline.domain.Player;
import com.github.fourinline.domain.Token;
import com.github.fourinline.domain.Board.Size;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(".:: Four In Line ::.");

        Board board = new Board(Size.DEFAULT);
        GameAnalyzer analyzer = new GameAnalyzer(board);
        ArrayList<Player> players = new ArrayList<>();
        Player p1 = new Player("player1", Token.RED);
        Player p2 = new Player("player2", Token.GREEN);
        // Player p3 = new Player("player3", Token.BLUE);

        players.add(p1);
        players.add(p2);
        // players.add(p3);

        Game game = new Game(board, analyzer, players);
        game.start();
    }
}
