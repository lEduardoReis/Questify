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
        this.statusMissao = StatusMissao.PENDENTE;
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
    public void aplicarRecompensa(Usuario usuario){

        int xp = calcularXp();
        int moedas = calcularMoedas();
        usuario.adicionarXp(xp);
        usuario.adicionarMoedas(moedas);

        System.out.println("XP recebido: " + xp);
        System.out.println("Moedas recebidas: " + moedas);
    }

    public void concluir(Usuario usuario){
        if(this.statusMissao == StatusMissao.PENDENTE){
            this.statusMissao = StatusMissao.CONCLUIDA;
            aplicarRecompensa(usuario);
        }else{
            System.out.println("Não foi possível concluir a missão.");
        }
    }

    public void cancelar(){
        if(this.statusMissao == StatusMissao.PENDENTE){
            this.statusMissao = StatusMissao.CANCELADA;
        }else{
            System.out.println("Não foi possível cancelar a missão.");
        }
    }

    public void exibirDetalhes() {
        System.out.println("===== MISSÃO =====");
        System.out.println("ID: " + this.id);
        System.out.println("Título: " + this.titulo);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Dificuldade: " + this.dificuldade);
        System.out.println("Status: " + this.statusMissao);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public StatusMissao getStatusMissao() {
        return statusMissao;
    }



}
