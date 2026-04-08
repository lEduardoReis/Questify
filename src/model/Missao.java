package model;

import enums.Dificuldade;
import enums.StatusMissao;

public class Missao {

    private int id;
    private String titulo;
    private String descricao;
    private Dificuldade dificuldade;
    private StatusMissao statusMissao;

    public Missao(int id, String titulo, String descricao, Dificuldade dificuldade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.statusMissao = statusMissao.PENDENTE;
    }

    public int calcularXp(){
        switch (this.dificuldade){
            case FACIL:
                return 10;
            case MEDIA:
                return 20;
            case DIFICIL:
                return 40;
            case EPICA:
                return 80;
            default:
                return 0;
        }
    }
    public int calcularMoedas() {
        switch (this.dificuldade) {
            case FACIL:
                return 5;
            case MEDIA:
                return 10;
            case DIFICIL:
                return 20;
            case EPICA:
                return 40;
            default:
                return 0;
        }
    }

    public void concluir(){
        this.statusMissao = StatusMissao.CONCLUIDA;
    }

    public void cancelar(){
        this.statusMissao = StatusMissao.CANCELADA;
    }

    public void exibirDetalhes() {
        System.out.println("===== MISSÃO =====");
        System.out.println("ID: " + this.id);
        System.out.println("Título: " + this.titulo);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Dificuldade: " + this.dificuldade);
        System.out.println("Status: " + this.statusMissao);
    }
}
