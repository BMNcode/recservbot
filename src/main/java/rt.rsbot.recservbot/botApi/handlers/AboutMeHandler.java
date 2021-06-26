package rt.rsbot.recservbot.botApi.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import rt.rsbot.recservbot.botApi.BotState;
import rt.rsbot.recservbot.botApi.InputMessageHandler;

@Component
public class AboutMeHandler implements InputMessageHandler {
    @Override
    public SendMessage handle(Message message) {
       return new SendMessage(message.getChatId(), "Данный бот создан для учебного проекта группы BrainHub");
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_ABOUT_ME;
    }
}
