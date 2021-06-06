package controller;

import dao.AdministradorDAO;
import dao.AdministradorDAOImpl;
import entities.Administrador;

public class AdminController {

    AdministradorDAO administradorDAO = new AdministradorDAOImpl();

    public Administrador loginNoSistema(String login, String senha) {

        Administrador admin = administradorDAO.buscarAdministrador(login, senha);
        return admin;
    }
}
