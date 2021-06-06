package dao;

import entities.Visita;
import entities.Visitante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
    public Visita buscarVisita(String cpf, LocalDate dataref){
        try {
            String sql = "SELECT * FROM visita_cad WHERE (cpf = ? and dataref = ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, dataref.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Visita visita = new Visita();
            visita.setDataref(LocalDate.parse(resultSet.getString("dataref")));
            visita.setValor(resultSet.getDouble("valorPago"));
            visita.setQuantidade(resultSet.getInt("quantidade"));

            return visita;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deletarVisita(String cpf, LocalDate dataref) {
        try {
            String sql = "DELETE * FROM visita_cad WHERE (cpf = ? and dataref = ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, dataref.toString());

            preparedStatement.execute();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

}
