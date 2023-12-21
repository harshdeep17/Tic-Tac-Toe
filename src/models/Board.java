package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board(int dimension) {
        this.size = dimension;
        this.grid = new ArrayList<>();
        for(int i=0;i<dimension;i++){
            List<Cell> row=new ArrayList<>();
            for(int j=0;j<dimension;j++){
                Cell cell=new Cell();
                cell.setRow(i);
                cell.setCol(j);
                cell.setCellState(CellState.EMPTY);
                row.add(cell);
            }
            grid.add(row);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }
    public void displayBoard(){
        List<List<Cell>> board=grid;
//        System.out.println(size);
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board.get(i).get(j).getCellState().equals(CellState.EMPTY))
                    System.out.print("-");
                else
                    System.out.print(board.get(i).get(j).getPlayer().getSymbol().getaChar());
            }
            System.out.println();
        }
    }
}
