package models;

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
}
