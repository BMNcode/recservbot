package rt.rsbot.recservbot.controller;

import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import rt.rsbot.recservbot.RecruitingServiceBot;
import rt.rsbot.recservbot.botApi.BotRestHandle;

@RestController
@RequestMapping("/")
public class WebHookController {

    private RecruitingServiceBot bot;
    private BotRestHandle botRestHandle;

    public WebHookController(RecruitingServiceBot bot, BotRestHandle botRestHandle) {
        this.bot = bot;
        this.botRestHandle = botRestHandle;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) throws TelegramApiException {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setDocument("http://localhost:8080/orders/download-pdf");
        sendDocument.setChatId(update.getMessage().getChatId());
        bot.execute(sendDocument);
        return bot.onWebhookUpdateReceived(update);
    }

    @PutMapping("/")
    public String str (@RequestBody Object obj){
        botRestHandle.handleRest(obj);
        return "Success";
    }

//    @GetMapping("/")
//    public PartialBotApiMethod<?> onUpdateReceivedDoc(){
//        return botRestHandle.handleRestDoc();
//    }
}
