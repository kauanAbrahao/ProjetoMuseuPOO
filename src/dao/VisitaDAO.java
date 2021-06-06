package dao;

import entities.Visita;
import entities.Visitante;

import java.time.LocalDate;
import java.util.List;

public interface VisitaDAO {

    boolean inserirVisita(Visitante visitante, int quantidade);

    List<Visita> buscarVisita(String cpf, LocalDate dataref);

    boolean deletarVisita(String cpf, LocalDate dataref);
}
