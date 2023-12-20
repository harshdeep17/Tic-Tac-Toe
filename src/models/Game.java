package models;

import exceptions.BotCountException;
import exceptions.PlayerCountDimensionMismatchException;
import exceptions.SymbolCountException;
import strategies.winningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private Player winner;
    private List<WinningStrategies> winningStrategies;

    private Game(int dimension, List<Player> players,
                List<WinningStrategies> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextMovePlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;

        private List<WinningStrategies> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        private void validateBotCount() throws BotCountException {
            int botCount=0;
            for(Player p:players){
                if(p.getType().equals(PlayerType.BOT_TYPE))botCount++;
            }
            if(botCount>1)throw new BotCountException();
        }
        private void validatePlayerCount() throws PlayerCountDimensionMismatchException {
            if(players.size()!=dimension-1)throw new PlayerCountDimensionMismatchException();
        }
        private void validateSymbolCount() throws SymbolCountException {
            Map<Character,Integer> symbolCount= new HashMap<>();
            for(Player p:players){
                char symbolChar=p.getSymbol().getaChar();
                if(!symbolCount.containsKey(symbolChar)){
                    symbolCount.put(symbolChar,0);
                }
                symbolCount.put(symbolChar, symbolCount.get(symbolChar)+1);
                if(symbolCount.get(symbolChar)>1) {
                    throw new SymbolCountException();
                }
            }
        }
        private void validate() throws BotCountException, PlayerCountDimensionMismatchException, SymbolCountException {
            validateBotCount();
            validatePlayerCount();
            validateSymbolCount();
        }
        public Game build() throws BotCountException, PlayerCountDimensionMismatchException, SymbolCountException {
            validate();
            return new Game(this.dimension,this.players,this.winningStrategies);
        }
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategies> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategies> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

}
