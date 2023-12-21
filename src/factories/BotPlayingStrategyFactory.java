package factories;

import models.BotDifficultyLevel;
import strategies.botPlayingStrategies.BotPlayingStrategy;
import strategies.botPlayingStrategies.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy();
        }
        return new EasyBotPlayingStrategy();
    }
}
