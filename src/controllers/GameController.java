package controllers;

import exceptions.BotCountException;
import exceptions.PlayerCountDimensionMismatchException;
import exceptions.SymbolCountException;
import models.*;
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
        List<List<Cell>> board=game.getBoard().getGrid();
        int size=game.getBoard().getSize();
        System.out.println(size);
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board.get(i).get(j).getCellState()+" "
                        +board.get(i).get(j).getRow()+" "
                        +board.get(i).get(j).getCol()+" "
                        +board.get(i).get(j).getPlayer()+" ");
            }
            System.out.println();
        }
    }
    public void makeMove(Game game){

    }
    public void undo(Game game){

    }
    public GameState checkState(Game game){
        return game.getGameState();
    }
    public Player getWinner(Game game){
        return null;
    }
}
