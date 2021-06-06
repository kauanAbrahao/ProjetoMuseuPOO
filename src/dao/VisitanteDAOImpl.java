package dao;

import entities.Cidadao;
import entities.Visitante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class VisitanteDAOImpl extends DatabaseConfig implements VisitanteDAO{

    Connection connection = super.conectaNoBanco();

    @Override
    public boolean inserirVisitante(Visitante visitante) {

        boolean resultado;
        String sql = String.format("INSERT INTO museu (cpf, rg, nome, email, telefone, login, senha, datanasc)" +
                        " VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                visitante.getCpf(), visitante.getRg(), visitante.getNome(), visitante.getEmail(),
                visitante.getTelefone(), visitante.getLogin(), visitante.getSenha(), visitante.getDatanasc());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultado = preparedStatement.execute();
            return resultado;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public Visitante buscarVisitante(String login, String senha) {

        try {
            String sql = "SELECT * from visitante_cad WHERE (login = ? or cpf = ?) and senha = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, senha);

            ResultSet resultSet = preparedStatement.executeQuery();
            Visitante visitante = new Cidadao();
            visitante.setCpf(resultSet.getString("cpf"));
            visitante.setRg(resultSet.getString("rg"));
            visitante.setNome(resultSet.getString("nome"));
            visitante.setEmail(resultSet.getString("email"));
            visitante.setTelefone(resultSet.getString("telefone"));
            visitante.setLogin(resultSet.getString("login"));
            visitante.setSenha(resultSet.getString("senha"));
            visitante.setDatanasc(LocalDate.parse(resultSet.getString("datanasc")));

            return visitante;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


}
