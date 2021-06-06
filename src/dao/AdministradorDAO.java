package dao;

import entities.Administrador;

public interface AdministradorDAO {

    Administrador buscarAdministrador(String login, String senha);
}
