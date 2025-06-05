import com.sun.net.httpserver.HttpServer;
import database.Database;
import web.LoginHandler;
import web.RegisterHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
public class Dispatcher {
    public static void main(String[] args) throws IOException {
        Database.connect();
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Обробник GET — для віддачі сторінки (HTML-форму можна спростити)
        server.createContext("/api/register", new RegisterHandler());
        server.createContext("/api/login", new LoginHandler());
        //server.createContext("/api/create-task", new TaskCreateHandler());

        // Обробник POST — для обробки даних форми
        //server.createContext("/submit-account", new CreateAccountPostHandler());

        server.setExecutor(null); // за замовчуванням, потоки
        System.out.println("Server started on http://localhost:8080");
        server.start();
    }
}