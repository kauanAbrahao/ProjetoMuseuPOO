package entities;

import java.time.LocalDate;

public class Visita {
    private LocalDate dataref;
    private Ingresso ingresso;
    private int quantidade;
    private double valor;
    Guia guia;
    Visitante visitante;


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void obtemIngresso(){
        this.setIngresso(new Ingresso());
        this.setGuia(new Guia());
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataref() {
        return dataref;
    }

    public void setDataref(LocalDate dataref) {
        this.dataref = dataref;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }
}
