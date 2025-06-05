package web;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.google.gson.Gson;
import database.UserService;
import models.User;
import models.Utility;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RegisterHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Дозволити CORS
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        // Обробка preflight-запиту
        if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(204, -1);
            return;
        }


        if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            Utility.sendResponse(exchange, "{\"error\":\"Method Not Allowed\"}", 405);
            return;
        }

        String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
        System.out.println("Request body: " + body); // Для дебагу

        try {
            JsonObject json = JsonParser.parseString(body).getAsJsonObject();

            String email = json.has("emailText") && !json.get("emailText").isJsonNull()
                    ? json.get("emailText").getAsString() : null;
            String password = json.has("passwordText") && !json.get("passwordText").isJsonNull()
                    ? json.get("passwordText").getAsString() : null;
            System.out.println("Parsed emailText: " + email);
            System.out.println("Parsed passwordText: " + password);

            if (email == null || email.isEmpty() || password == null || password.isEmpty()){

                Utility.sendResponse(exchange, "{\"error\":\"Missing required fields\"}", 400);
                return;
            }

            User user = new User(email, password);
            boolean isCreated = UserService.createUser(user);

            JsonObject responseJson = new JsonObject();
            responseJson.addProperty("isCreated", isCreated);

            Utility.sendResponse(exchange, new Gson().toJson(responseJson), 200);

        } catch (Exception e) {
            e.printStackTrace();
            Utility.sendResponse(exchange, "{\"error\":\"Invalid JSON format or server error\"}", 400);
        }
    }
}
