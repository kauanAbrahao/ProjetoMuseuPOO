package dao;

import entities.Visita;

public interface VisitaDAO {

    void inserirVisita(Visita visita);

    Visita buscarVisita(String cpf);
}
