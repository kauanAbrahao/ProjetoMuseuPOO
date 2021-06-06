package dao;

import org.mariadb.jdbc.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    //A URL é composta por jdbc:<nomeDoBanco>://<ip>:<porta>/<nomeDoDatabase>
    public static final String URL = "jdbc:mariadb://localhost:3306/museu";
    public static final String USER = "root";
    public static final String PASSWORD = "";


    public Connection conectaNoBanco(){
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
}
