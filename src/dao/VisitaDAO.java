package dao;

import entities.Visita;
import entities.Visitante;

import java.time.LocalDate;

public interface VisitaDAO {

    boolean inserirVisita(Visitante visitante, int quantidade);

    Visita buscarVisita(String cpf, LocalDate dataref);

    boolean deletarVisita(String cpf, LocalDate dataref);
}
