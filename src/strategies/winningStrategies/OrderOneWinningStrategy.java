package strategies.winningStrategies;

import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneWinningStrategy implements WinningStrategy{
    List<Map<Symbol,Integer>> rows;
    List<Map<Symbol,Integer>> cols;
    Map<Symbol,Integer> diagonal;
    Map<Symbol,Integer>reverseDiagonal;
    public OrderOneWinningStrategy(int size) {
        rows=new ArrayList<>();
        cols=new ArrayList<>();
        diagonal=new HashMap<>();
        reverseDiagonal=new HashMap<>();
        for(int i=0;i<size;i++){
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
        }
    }
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Player player=move.getPlayer();
        Map<Symbol,Integer> rowMap=rows.get(row);
        Map<Symbol,Integer> colMap=cols.get(col);
        rowMap.put(player.getSymbol(),rowMap.getOrDefault(player.getSymbol(),0)+1);
        colMap.put(player.getSymbol(),colMap.getOrDefault(player.getSymbol(),0)+1);
        if(row==col){
            diagonal.put(player.getSymbol(),diagonal.getOrDefault(player.getSymbol(),0)+1);
        }
        if(row+col==board.getSize()-1){
            reverseDiagonal.put(player.getSymbol(),reverseDiagonal.getOrDefault(player.getSymbol(),0)+1);
        }
        return rowMap.get(player.getSymbol())== board.getSize() || colMap.get(player.getSymbol())== board.getSize()
                || diagonal.getOrDefault(player.getSymbol(),0)== board.getSize() ||
                diagonal.getOrDefault(player.getSymbol(),0)== board.getSize();
    }

    @Override
    public void undo(Move move, Board board) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Player player=move.getPlayer();
        Map<Symbol,Integer> rowMap=rows.get(row);
        Map<Symbol,Integer> colMap=cols.get(col);
        rowMap.put(player.getSymbol(),rowMap.get(player.getSymbol())-1);
        colMap.put(player.getSymbol(),colMap.get(player.getSymbol())-1);
        if(row==col){
            diagonal.put(player.getSymbol(),diagonal.get(player.getSymbol())-1);
        }
        if(row+col==board.getSize()-1){
            reverseDiagonal.put(player.getSymbol(),reverseDiagonal.get(player.getSymbol())-1);
        }
    }
}
