import controllers.GameController;
import exceptions.BotCountException;
import exceptions.PlayerCountDimensionMismatchException;
import exceptions.SymbolCountException;
import models.*;
import strategies.winningStrategies.OrderOneWinningStrategy;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
        GameController gameController=new GameController();
        List<Player> players=new ArrayList<>();
        players.add(new Player("HD","h1",
                new Symbol('X'), PlayerType.HUMAN_TYPE));
        players.add(new Player("Mithu","h2",
                new Symbol('O'), PlayerType.HUMAN_TYPE));
        players.add(new Player("Pratyush","h3",
                new Symbol('$'), PlayerType.HUMAN_TYPE));
//        players.add(new Bot("Bot1","b1",
//                new Symbol('$'), PlayerType.BOT_TYPE,BotDifficultyLevel.EASY));
        Game game=gameController.startGame(4, players, new OrderOneWinningStrategy(4));
        System.out.println("Game is starting....");
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
            gameController.undo(game);
        }
        if(gameController.checkState(game).equals(GameState.ENDED)){
            System.out.println(game.getWinner().getName()+" is winner.");
        }else if(gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game is drawn.");
        }
    }
}