package rt.rsbot.recservbot.botApi;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 *     Обработчик сообщений
 */

public interface InputMessageHandler {

    SendMessage handle(Message message);

    SendDocument handleDocument(Message message);

    BotState getHandlerName();
}
