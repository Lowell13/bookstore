package com.bookstore.front.service;

import com.bookstore.front.entity.Book;
import com.bookstore.front.utils.JsonBodyHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Service
public class ApiRequestService {

    private final String urlApi = "http://localhost:3010/";

    public List<Book> getAllBooks() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create(urlApi + "book"))
                .GET()
                .build();

        HttpResponse<Supplier<Book[]>> response = null;

        try {
            response = client.send(request, new JsonBodyHandler<>(Book[].class));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return Arrays.asList(response != null ? response.body().get() : new Book[0]);
    }

    public Book getBookById(Long id) {
        Book toReturn = null;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create(urlApi + "book/" + id.toString()))
                .GET()
                .build();

        try {
            HttpResponse<Supplier<Book>> response = client.send(request, new JsonBodyHandler<>(Book.class));
            toReturn = response.body().get();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return toReturn;
    }
}
