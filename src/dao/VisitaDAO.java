package dao;

import entities.Visita;
import entities.Visitante;

public interface VisitaDAO {

    boolean inserirVisita(Visitante visitante, int quantidade);

    Visita buscarVisita(String cpf);
}
