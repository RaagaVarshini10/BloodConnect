import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

  private static final String URL = "jdbc:mysql://localhost:3306/bloodconnect";
    private static final String USER = "root";
    private static final String PASSWORD = "raaga@73123436";

    public static Connection getConnection() {

        for (int i = 1; i <= 10; i++) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

                System.out.println("Database Connected Successfully!");

                return con;

            } catch (Exception e) {

                System.out.println("Waiting for MySQL... Attempt " + i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("Database Connection Failed!");
        return null;
    }
}