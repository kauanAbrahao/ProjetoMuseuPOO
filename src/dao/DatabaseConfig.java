package dao;

import org.mariadb.jdbc.*;

public class DatabaseConfig {

    public static final String URL = "jdbc:mariadb//localhost:3306/museu";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Carregado");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
