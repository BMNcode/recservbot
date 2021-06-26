package rt.rsbot.recservbot.cache;

import org.springframework.stereotype.Component;
import rt.rsbot.recservbot.botApi.BotState;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataCacheImp implements DataCache {
    private Map<Integer, BotState> userBotStates = new HashMap<>();

    @Override
    public void setUserCurrentBotState(int userId, BotState botState) {
        userBotStates.put(userId, botState);
    }

    @Override
    public BotState getUserCurrentBotState(int userId) {
        BotState botState = userBotStates.get(userId);
        if(botState==null){
            botState = BotState.SHOW_MAIN_MENU;
        }
        return botState;
    }

    public Map<Integer, BotState> getUserBotStates() {
        return userBotStates;
    }
}
