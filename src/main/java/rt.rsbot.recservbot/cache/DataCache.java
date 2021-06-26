package rt.rsbot.recservbot.cache;

import rt.rsbot.recservbot.botApi.BotState;

/**
 * Интерфейс объявляет методы позволяющие получить и установить состояние бота
 */

public interface DataCache {
    void setUserCurrentBotState(int userId, BotState botState);

    BotState getUserCurrentBotState(int userId);


}
