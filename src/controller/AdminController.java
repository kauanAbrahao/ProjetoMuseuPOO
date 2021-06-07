package controller;

import dao.AdministradorDAO;
import dao.AdministradorDAOImpl;
import dao.VisitaDAO;
import dao.VisitaDAOImpl;
import entities.Administrador;
import entities.Visita;

import java.util.List;

public class AdminController {

    AdministradorDAO administradorDAO = new AdministradorDAOImpl();
    VisitaDAO visitaDAO = new VisitaDAOImpl();

    public Administrador loginNoSistema(String login, String senha) {

        Administrador admin = administradorDAO.buscarAdministrador(login, senha);
        return admin;
    }

    public List<Visita> buscarRelatorio(){
        List<Visita> visitas = visitaDAO.buscarTodasAsVisitas();
        return visitas;
    }
}
