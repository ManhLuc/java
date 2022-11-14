package vn.com.vti.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtils {
    private static DatabaseUtils dbIsntance;
    private static Connection con;

    public static DatabaseUtils getInstance(){
        if (dbIsntance == null){
            dbIsntance = new DatabaseUtils();

        }
        return dbIsntance;
    }
    public static void closeConnection (Connection conn){
        try {
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();

        }
    }
    public Connection getDatabaseConnection () {
        try {
            Properties properties = new Properties();
            //Đọc thông tin trong properties
            properties.load(Files.newInputStream(Paths.get("src/main/resources/database.properties")));
            String databaseUrl = properties.getProperty("databaseUlr");
            String userName = properties.getProperty("username");
            String password = properties.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (con == null) {
                con = DriverManager.getConnection(databaseUrl, userName, password);
                con.setAutoCommit(false);
                System.out.println("Connect to database success");
                return con;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;

    }
}
