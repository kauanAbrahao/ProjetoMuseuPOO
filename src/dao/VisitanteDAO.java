package dao;

import entities.Cidadao;
import entities.Visitante;

public interface VisitanteDAO {

    Visitante buscarVisitante(String login, String senha);

    boolean inserirVisitante(Visitante visitante);
}
