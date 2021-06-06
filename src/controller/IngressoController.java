package controller;

import dao.VisitaDAO;
import dao.VisitaDAOImpl;
import entities.Ingresso;
import entities.Visita;
import entities.Visitante;
import javafx.scene.control.Alert;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class IngressoController {

    VisitaDAO visitaDAO = new VisitaDAOImpl();

    public boolean comprarIngresso(Visitante visitante, String dataDeVisita, int quantidade){
        Ingresso ingresso = new Ingresso();
        visitante.setVisita(new Visita());
        visitante.getVisita().setIngresso(ingresso);
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            visitante.getVisita().setDataref(LocalDate.parse(dataDeVisita, dt));
        } catch (Exception e){
            System.out.println("deu merda aqui hein");
            return false;
        }

        double valorIngresso = visitante.calcularValorIngresso(ingresso);
        visitante.setValorTotal(valorIngresso);
        visitante.getVisita().setQuantidade(quantidade);

        boolean sucesso = visitaDAO.inserirVisita(visitante, visitante.getVisita().getQuantidade());

        return sucesso;
    }

    public List<Visita> buscarVisitas(String cpf){
        List<Visita> visitas = visitaDAO.buscarVisita(cpf);
        if (visitas.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Não há nenhuma visita cadastrada nessa data para esse cpf");
            return null;
        } else {
            return visitas;
        }
    }
 }
