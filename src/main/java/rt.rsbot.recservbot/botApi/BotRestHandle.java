package rt.rsbot.recservbot.botApi;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import rt.rsbot.recservbot.RecruitingServiceBot;
import rt.rsbot.recservbot.cache.DataCacheImp;

@Component
public class BotRestHandle {
    private RecruitingServiceBot bot;
    private DataCacheImp dataCacheImp;

    public BotRestHandle(RecruitingServiceBot bot, DataCacheImp dataCacheImp) {
        this.bot = bot;
        this.dataCacheImp = dataCacheImp;
    }

    public void handleRest(Object object){
       dataCacheImp.getUserBotStates().forEach((k,v)->{
           try {
               bot.execute(new SendMessage(String.valueOf(k),object.toString()));
           } catch (TelegramApiException e) {
               e.printStackTrace();
           }
       });
    }
}
