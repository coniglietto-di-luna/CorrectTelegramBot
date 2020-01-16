package ru.otus.rzdtelegrambot.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Sergei Viacheslaev
 */
@Service
@Slf4j
public class PingTask {

    @Scheduled(fixedRate = 900_000)
    public void pingMe() {
        try {
            URL url = new URL("https://bot1035774480-aaernp8.herokuapp.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            log.info("Ping OK: response code {}", connection.getResponseCode());
        } catch (IOException e) {
            log.error("Ping FAILED");
            e.printStackTrace();
        }

    }

}
