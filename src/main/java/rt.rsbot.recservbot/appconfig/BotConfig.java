package rt.rsbot.recservbot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import rt.rsbot.recservbot.RecruitingServiceBot;
import rt.rsbot.recservbot.botApi.BotUpdateHandle;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
class BotConfig {
    private String username;
    private String token;
    private String webHookPath;

    @Bean
    public RecruitingServiceBot recruitingServiceBot(BotUpdateHandle tFacade) {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);
        RecruitingServiceBot recruitingServiceBot = new RecruitingServiceBot(options, tFacade);
        recruitingServiceBot.setUsername(username);
        recruitingServiceBot.setToken(token);
        recruitingServiceBot.setWebHookPath(webHookPath);

        return recruitingServiceBot;
    }
}
