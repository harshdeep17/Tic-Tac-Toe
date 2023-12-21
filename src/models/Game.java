package models;

import exceptions.BotCountException;
import exceptions.PlayerCountDimensionMismatchException;
import exceptions.SymbolCountException;
import strategies.winningStrategies.WinningStrategy;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private int currentMovePlayerIndex;
    private Player winner;
    private WinningStrategy winningStrategy;

    private Game(int dimension, List<Player> players, WinningStrategy winningStrategy) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.currentMovePlayerIndex = 0;
        this.winningStrategy = winningStrategy;
    }
    public void displayBoard(){
        board.displayBoard();
    }
    public void makeMove(){
        //Figure out who's turn is it.
        Player currentPlayer=players.get(currentMovePlayerIndex);

        // Ask that player to tell which cell to move on
        Move move=currentPlayer.makeMove(board);
        moves.add(move);
        if(winningStrategy.checkWinner(move,board)){
            setGameState(GameState.ENDED);
            setWinner(currentPlayer);
            return;
        }
        if(moves.size() == board.getSize() * board.getSize()){
            // Game has drawn
            setGameState(GameState.DRAW);
            return;
        }
        currentMovePlayerIndex = (currentMovePlayerIndex + 1) % players.size();
    }
    public void undo(){
        int previousMovePlayerIndex=(currentMovePlayerIndex-1+players.size())%players.size();
        Player player=players.get(previousMovePlayerIndex);
        if(player.getType().equals(PlayerType.BOT_TYPE)){
            return;
        }
        System.out.println("Do you want a undo?");
        System.out.println("Enter 1 for yes 2 for no: ");
        Scanner scanner=new Scanner(System.in);
        int flag= scanner.nextInt();
        if(flag==2)return ;
        currentMovePlayerIndex=previousMovePlayerIndex;
        Move move=moves.get(moves.size()-1);
        Cell cell=move.getCell();
        moves.remove(moves.size()-1);
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);
        board.getGrid().get(cell.getRow()).set(cell.getCol(),cell);
        winningStrategy.undo(move,board);
    }
    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;

        private WinningStrategy winningStrategy;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
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
            return new Game(this.dimension,this.players,this.winningStrategy);
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

    public int getCurrentMovePlayerIndex() {
        return currentMovePlayerIndex;
    }

    public void setCurrentMovePlayerIndex(int currentMovePlayerIndex) {
        this.currentMovePlayerIndex = currentMovePlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

}
