package ru.romashkin.romashkin_planner_bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RomashkinPlannerBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RomashkinPlannerBotApplication.class, args); //Запускает наше Спринг приложение
	}

}
