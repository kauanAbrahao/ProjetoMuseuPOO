package dao;

import entities.Visita;
import entities.Visitante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitaDAOImpl extends DatabaseConfig implements VisitaDAO {

    Connection connection = super.conectaNoBanco();

    @Override
    public boolean inserirVisita(Visitante visitante, int quantidade){
        try {
            String sql = "INSERT INTO visita_cad (dataref, valorPago, cpf, quantidade)" +
                    " VALUES (?, ? , ? ,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, visitante.getVisita().getDataref().toString());
            preparedStatement.setString(2, String.valueOf(visitante.getValorTotal()));
            preparedStatement.setString(3, visitante.getCpf());
            preparedStatement.setString(4, String.valueOf(quantidade));

            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

    @Override
    public Visita buscarVisita(String cpf){
        return null;
    }

}
