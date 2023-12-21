package controllers;

import exceptions.BotCountException;
import exceptions.PlayerCountDimensionMismatchException;
import exceptions.SymbolCountException;
import models.*;
import strategies.winningStrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players,
                          WinningStrategy winningStrategy) throws BotCountException, PlayerCountDimensionMismatchException, SymbolCountException {
        return Game.getBuilder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .setWinningStrategy(winningStrategy)
                    .build();
    }
    public void displayBoard(Game game){
        game.displayBoard();
    }
    public void makeMove(Game game){
        game.makeMove();
    }
    public void undo(Game game){
        game.undo();
    }
    public GameState checkState(Game game){
        return game.getGameState();
    }
    public Player getWinner(Game game){
        return null;
    }
}
