package models;

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
}
