package rt.rsbot.recservbot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import rt.rsbot.recservbot.botApi.BotUpdateHandle;

public class RecruitingServiceBot extends TelegramWebhookBot {
    private final BotUpdateHandle tFacade;

    private String username;
    private String token;
    private String webHookPath;

    public RecruitingServiceBot(DefaultBotOptions defaultBotOptions, BotUpdateHandle tFacade) {
        super(defaultBotOptions);
        this.tFacade = tFacade;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
       SendMessage sendMessage = tFacade.handleUpdate(update);
       return sendMessage;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

   /* @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            try {
                execute(new SendMessage(chat_id, "Hi " + update.getMessage().getText()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        return null;
    }*/



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWebHookPath() {
        return webHookPath;
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }
}
