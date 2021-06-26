package rt.rsbot.recservbot.botApi.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import rt.rsbot.recservbot.botApi.BotState;
import rt.rsbot.recservbot.botApi.InputMessageHandler;
import rt.rsbot.recservbot.service.MainMenuService;


@Component
public class MainMenuHandler implements InputMessageHandler {
    private MainMenuService mainMenuService;

    public MainMenuHandler(MainMenuService mainMenuService) {
        this.mainMenuService = mainMenuService;
    }


    @Override
    public SendMessage handle(Message message) {
        return mainMenuService.getMainMenuMessage(message.getChatId(), "Главное меню");
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_MAIN_MENU;
    }
}
