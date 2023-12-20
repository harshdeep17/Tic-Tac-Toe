package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.size = size;
        this.board = new ArrayList<>();
        for(int i=0;i<dimension;i++){
            List<Cell> row=new ArrayList<>();
            for(int j=0;j<dimension;j++){
                Cell cell=new Cell();
                cell.setRow(i);
                cell.setCol(j);
                cell.setCellState(CellState.EMPTY);
                row.add(cell);
            }
            board.add(row);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return board;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.board = grid;
    }
}
