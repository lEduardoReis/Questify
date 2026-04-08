package model;

public class Usuario {
    private int id;
    private String nome;
    private int nivel;
    private int xp;
    private int moedas;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.nivel = 1;
        this.xp = 0;
        this.moedas = 0;
    }

    // Metodo de adicionar XP
    public void adicionarXp(int xp){
        this.xp += xp;

        while (this.xp >= 100){
            this.xp -= 100;
            this.nivel++;
            System.out.println("Parabéns! Você subiu para o nível " + this.nivel);
        }
    }

    public void adicionarMoedas(int moedas){
        this.moedas += moedas;
    }

    public void exibirStatus(){
        System.out.println("===== STATUS DO USUARIO ======");
        System.out.println("Nome: " + this.nome);
        System.out.println("Nivel: " + this.nivel);
        System.out.println("XP: " + this.xp);
        System.out.println("Moedas: " + this.moedas);
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
}
