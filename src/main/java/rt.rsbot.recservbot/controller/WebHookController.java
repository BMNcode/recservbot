package rt.rsbot.recservbot.controller;

import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import rt.rsbot.recservbot.RecruitingServiceBot;

@RestController
@RequestMapping("/")
public class WebHookController {
    private final RecruitingServiceBot bot;

    public WebHookController(RecruitingServiceBot bot) {
        this.bot = bot;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
        return bot.onWebhookUpdateReceived(update);
    }

    @PostMapping("/api")
    @ResponseBody
    public String str (@RequestBody Object obj){
        return "Good";
    }
}
