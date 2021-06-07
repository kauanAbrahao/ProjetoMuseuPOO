package controller;

import dao.AdministradorDAO;
import dao.AdministradorDAOImpl;
import dao.VisitaDAO;
import dao.VisitaDAOImpl;
import entities.Administrador;
import entities.Visita;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public boolean alterarVisita(String cpf, String dataref, String novaDataRef){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean resultado;
        try{
            LocalDate date1 = LocalDate.parse(dataref, dt);
            LocalDate date2 = LocalDate.parse(novaDataRef, dt);
            resultado = visitaDAO.alterarVisita(cpf, date1, date2);
        } catch (Exception e){
            System.out.println("Verifique os campos de data e cpf!");
            resultado = false;
        }

        return resultado;
    }
}
