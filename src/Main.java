import controllers.GameController;
import exceptions.BotCountException;
import exceptions.PlayerCountDimensionMismatchException;
import exceptions.SymbolCountException;
import models.*;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
        GameController gameController=new GameController();
        List<Player> players=new ArrayList<>();
        players.add(new Player("HD","h1",
                new Symbol('#'), PlayerType.HUMAN_TYPE));
        players.add(new Player("Mithu","h2",
                new Symbol('@'), PlayerType.HUMAN_TYPE));
        players.add(new Bot("Bot1","b1",
                new Symbol('$'), PlayerType.BOT_TYPE,BotDifficultyLevel.EASY));
        Game game=gameController.startGame(4,players,new ArrayList<>());
        System.out.println("Game is starting....");
//        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
//            gameController.displayBoard(game);
//            gameController.makeMove(game);
//        }
//        if(gameController.checkState(game).equals(GameState.SUCCESS)){
//            System.out.println("Winner is some player.");
//        }else if(gameController.checkState(game).equals(GameState.DRAW)){
//            System.out.println("Game is drawn.");
//        }
    }
}