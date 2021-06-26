package rt.rsbot.recservbot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import rt.rsbot.recservbot.RecruitingServiceBot;
import rt.rsbot.recservbot.botApi.BotUpdateHandle;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String username;
    private String token;
    private String webHookPath;

    @Bean
    public RecruitingServiceBot recruitingServiceBot(BotUpdateHandle tFacade) throws TelegramApiRequestException {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);
        RecruitingServiceBot recruitingServiceBot = new RecruitingServiceBot(options, tFacade);
        recruitingServiceBot.setUsername(username);
        recruitingServiceBot.setToken(token);
        recruitingServiceBot.setWebHookPath(webHookPath);
        recruitingServiceBot.setWebhook(webHookPath, null);

        return recruitingServiceBot;
    }
}
