package rt.rsbot.recservbot.botApi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import rt.rsbot.recservbot.cache.DataCacheImp;

/**
 * Обработка объекта update, определение наличия в нем сообщения, запросов от кнопок
 * и последующая обработка
 */

@Component
public class BotUpdateHandle {
    private final BotStateContext botStateContext;
    private final DataCacheImp dataCacheImp;

    public BotUpdateHandle(BotStateContext botStateContext, DataCacheImp dataCacheImp) {
        this.botStateContext = botStateContext;
        this.dataCacheImp = dataCacheImp;
    }

    public SendMessage handleUpdate(Update update) {
        SendMessage replyMessage = null;

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            replyMessage = HandleInputMessage(message);
        }
        return replyMessage;
    }

    private SendMessage HandleInputMessage(Message message) {
        String inputMessage = message.getText();
        int userId = Math.toIntExact(message.getFrom().getId());
        BotState botState;
        SendMessage replyMessage;

        switch (inputMessage) {
            case "/start":
                botState = BotState.SHOW_MAIN_MENU;
                break;
            case "О боте":
                botState = BotState.SHOW_ABOUT_ME;
                break;
            default:
                botState = dataCacheImp.getUserCurrentBotState(userId);
                break;
        }
        dataCacheImp.setUserCurrentBotState(userId, botState);
        replyMessage = botStateContext.processInputMessage(botState, message);
        return replyMessage;
    }
}
