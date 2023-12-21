package models;

import factories.BotPlayingStrategyFactory;
import strategies.botPlayingStrategies.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, String id, Symbol symbol, PlayerType type,
               BotDifficultyLevel botDifficultyLevel) {
        super(name, id, symbol, type);
        botDifficultyLevel=botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Its " + getName() + "'s turn");
        BotPlayingStrategy strategy = BotPlayingStrategyFactory.getStrategy(botDifficultyLevel);
        Move move=strategy.makeMove(board,this);
        System.out.println("Bot made a move on row:" + move.getCell().getRow() + " col:" + move.getCell().getCol());
        return move;
    }
}
