package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Response {
    public String getContent(String path) throws IOException {
        // Для буферизации текста из потока
        BufferedReader reader = null;
        // Байтовый поток для записи
        InputStream stream = null;
        // Вызываем класс для для реализации работы с сетью
        HttpsURLConnection connection = null;
        try {
            // Присваиваем путь
            URL url = new URL(path);
            connection = (HttpsURLConnection) url.openConnection();
            // Выбираем метод GET для запроса
            connection.setRequestMethod("GET");
            connection.setReadTimeout(70000);
            connection.connect();
            // Полученный результат разбиваем с помощью байтовых потоков
            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder buf = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buf.append(line).append("\n");
            }
            // Возвращаем разбитый по строкам результат
            return (buf.toString());
        }
        // Закрываем открытые потоки и подключения
        finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}

