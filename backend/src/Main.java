import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;

public class Main {

    public static void main(String[] args) throws IOException {

        // Create HTTP Server
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // ================= HOME =================
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {

                String response = "BloodConnect Backend Running Successfully!";

                exchange.sendResponseHeaders(200, response.length());

                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        // ================= REGISTER =================
        server.createContext("/register", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {

                if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {

                    String formData = new String(exchange.getRequestBody().readAllBytes());

                    String[] pairs = formData.split("&");

                    String fullName = "";
                    int age = 0;
                    String bloodGroup = "";
                    String phone = "";
                    String email = "";
                    String city = "";
                    String lastDonation = "";

                    for (String pair : pairs) {

                        String[] keyValue = pair.split("=");

                        String key = keyValue[0];
                        String value = keyValue.length > 1 ? keyValue[1] : "";

                        value = URLDecoder.decode(value, "UTF-8");

                        switch (key) {

                            case "fullName":
                                fullName = value;
                                break;

                            case "age":
                                age = Integer.parseInt(value);
                                break;

                            case "bloodGroup":
                                bloodGroup = value;
                                break;

                            case "phone":
                                phone = value;
                                break;

                            case "email":
                                email = value;
                                break;

                            case "city":
                                city = value;
                                break;

                            case "lastDonation":
                                lastDonation = value;
                                break;
                        }
                    }

                    Donor donor = new Donor(
                            fullName,
                            age,
                            bloodGroup,
                            phone,
                            email,
                            city,
                            lastDonation,
                            "Available"
                    );

                    String response = RegisterHandler.registerDonor(donor);

                    exchange.sendResponseHeaders(200, response.length());

                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();

                } else {

                    exchange.sendResponseHeaders(405, -1);

                }
            }
        });

        // ================= SEARCH =================
        server.createContext("/search", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {

                if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {

                    String formData = new String(exchange.getRequestBody().readAllBytes());

                    String[] pairs = formData.split("&");

                    String bloodGroup = "";
                    String city = "";

                    for (String pair : pairs) {

                        String[] keyValue = pair.split("=");

                        String key = keyValue[0];
                        String value = keyValue.length > 1 ? keyValue[1] : "";

                        value = URLDecoder.decode(value, "UTF-8");

                        switch (key) {

                            case "bloodGroup":
                                bloodGroup = value;
                                break;

                            case "city":
                                city = value;
                                break;
                        }
                    }

                    String response = SearchHandler.searchDonors(bloodGroup, city);

                    exchange.getResponseHeaders().set("Content-Type", "text/html");

                    exchange.sendResponseHeaders(200, response.getBytes().length);

                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();

                } else {

                    exchange.sendResponseHeaders(405, -1);

                }
            }
        });

        // ================= DATABASE TEST =================
        if (Database.getConnection() != null) {
            System.out.println("Database Connected Successfully!");
        } else {
            System.out.println("Database Connection Failed!");
        }

        // ================= START SERVER =================
        server.setExecutor(null);
        server.start();

        System.out.println("=================================");
        System.out.println("BloodConnect Server Started!");
        System.out.println("Home      : http://localhost:8080/");
        System.out.println("Register  : http://localhost:8080/register");
        System.out.println("Search    : http://localhost:8080/search");
        System.out.println("=================================");
    }
}