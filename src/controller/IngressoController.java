package controller;

import dao.VisitaDAO;
import dao.VisitaDAOImpl;
import entities.Ingresso;
import entities.Visita;
import entities.Visitante;

import java.time.LocalDate;

public class IngressoController {

    VisitaDAO visitaDAO = new VisitaDAOImpl();

    public boolean comprarIngresso(Visitante visitante, LocalDate dataDeVisita, int quantidade){
        Ingresso ingresso = new Ingresso();
        visitante.setVisita(new Visita());
        visitante.getVisita().setIngresso(ingresso);
        visitante.getVisita().setDataref(dataDeVisita);
        double valorIngresso = visitante.calcularValorIngresso(ingresso);
        visitante.setValorTotal(valorIngresso);

        boolean sucesso = visitaDAO.inserirVisita(visitante, quantidade);

        return sucesso;
    }
}
