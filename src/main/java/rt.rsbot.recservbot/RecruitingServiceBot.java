package rt.rsbot.recservbot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import rt.rsbot.recservbot.botApi.BotUpdateHandle;

public class RecruitingServiceBot extends TelegramWebhookBot {
    private final BotUpdateHandle handle;

    private String username;
    private String token;
    private String webHookPath;

    public RecruitingServiceBot(DefaultBotOptions defaultBotOptions, BotUpdateHandle handle) {
        super(defaultBotOptions);
        this.handle = handle;
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
        return handle.handleUpdate(update);
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }
}
