package models;

import java.util.Scanner;

public class Player {
    private String name;
    private String id;
    private Symbol symbol;
    private PlayerType type;

    public Player(String name, String id, Symbol symbol, PlayerType type) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }
    public Move makeMove(Board board){
        Scanner scanner=new Scanner(System.in);
        System.out.println("It's " + name + "'s turn");
        System.out.println("Please enter row and col");
        int row = scanner.nextInt();

//        System.out.println("Please enter column");
        int col = scanner.nextInt();

        //TODO validate
        Cell cell=board.getGrid().get(row).get(col);
        cell.setRow(row);
        cell.setCol(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        Move move = new Move();
        move.setCell(cell);
        move.setPlayer(this);
        return move;
    }
}
