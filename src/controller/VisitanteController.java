package controller;

import dao.VisitanteDAO;
import dao.VisitanteDAOImpl;
import entities.Aluno;
import entities.Cidadao;
import entities.Professor;
import entities.Visitante;
import javafx.scene.control.Alert;

import java.util.LinkedList;
import java.util.List;

public class VisitanteController {

    VisitanteDAO visitateDAO = new VisitanteDAOImpl();

    //SUBSTITUIR POR DAO DEPOIS
    public void cadastrarVisitante(Visitante visitante){
        if (visitante!=null){
            boolean resultado = visitateDAO.inserirVisitante(visitante);
            if(resultado){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Cadastro realizado com sucesso!");
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Verifique os campos e tente novamente!");
            }
        }
    }public void cadastrarVisitante(Professor visitante){
        if (visitante!=null){
            boolean resultado = visitateDAO.inserirVisitante(visitante);
            if(resultado){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Cadastro realizado com sucesso!");
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Verifique os campos e tente novamente!");
            }
        }
    } public void cadastrarVisitante(Cidadao visitante){
        if (visitante!=null){
            boolean resultado = visitateDAO.inserirVisitante(visitante);
            if(resultado){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Cadastro realizado com sucesso!");
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Verifique os campos e tente novamente!");
            }
        }

    }

    //SUBSTITUIR POR DAO DEPOIS
    public Visitante loginVisitante(String loginOuCpf, String senha){
        Visitante visitante = visitateDAO.buscarVisitante(loginOuCpf, senha);
        return visitante;
    }





}
