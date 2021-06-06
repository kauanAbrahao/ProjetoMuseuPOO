package dao;

import entities.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAOImpl extends DatabaseConfig implements AdministradorDAO {

    Connection connection = super.conectaNoBanco();

    @Override
    public Administrador buscarAdministrador(String login, String senha) {
        String sql = "SELECT * from admin_cad WHERE (login = ? and senha = ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Administrador administrador = new Administrador();
            administrador.setAtivo(resultSet.getBoolean("ativo"));
            return administrador;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
