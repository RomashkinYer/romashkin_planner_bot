package ru.romashkin.romashkin_planner_bot.service;

import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.romashkin.romashkin_planner_bot.config.BotConfig;

import java.lang.runtime.SwitchBootstraps;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;

    public TelegramBot(BotConfig config) {
        this.config = config;
    }

    @Override
    public void onUpdateReceived(Update update) { // Логика обработки обновлений от пользователя
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId(); //ChatId - чтобы бот понимал кому пишет

            switch (messageText) {
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                break;
            }
        }

    }

    private void startCommandReceived (long chatId, String name) { //Метод для ответа
        String answer = "Приветствую, " + name + ", рад вас видеть, мой Господин!";
        sendMessage(chatId, answer);

    }

    private void sendMessage (long chatId, String textToSend) {
        SendMessage message = new SendMessage(chatId, textToSend);

        try {
            execute(message); // Отправляем сообщение
        } catch (Exception e) {
            e.printStackTrace(); // Обработка ошибок при отправке сообщения
        }
    }

    private void execute(SendMessage message) {
    }

    @Override
    public String getBotUsername() {
        return config.getBotName(); // Возвращаем имя бота из конфигурации
    }

    @Override
    public String getBotToken() {
        return config.getToken(); // Возвращаем токен бота из конфигурации
    }
}

