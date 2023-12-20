package controllers;

import exceptions.BotCountException;
import exceptions.PlayerCountDimensionMismatchException;
import exceptions.SymbolCountException;
import models.Game;
import models.GameState;
import models.Player;
import strategies.winningStrategies.WinningStrategies;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players,
                          List<WinningStrategies> winningStrategies) throws BotCountException, PlayerCountDimensionMismatchException, SymbolCountException {
        return Game.getBuilder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .setWinningStrategies(winningStrategies)
                    .build();
    }
    public void displayBoard(Game game){

    }
    public void makeMove(Game game){

    }
    public void undo(Game game){

    }
    public String checkState(Game game){
        return String.valueOf(GameState.IN_PROGRESS);
    }
    public Player getWinner(Game game){
        return null;
    }
}
