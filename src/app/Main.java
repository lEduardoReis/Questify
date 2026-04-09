package app;

import enums.Dificuldade;
import model.Missao;
import model.Usuario;


import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("====== SEJA BEM VINDO AO QUESTIFY ======");

        System.out.println("Digite seu nome de usuario: ");
        String nomeUsuario = input.nextLine();

        Usuario usuario = new Usuario(1, nomeUsuario);
        Missao m1 = executarMissao(input, usuario, 1);
        Missao m2 = executarMissao(input, usuario, 2);

        System.out.println("\n ==== RESULTADO FINAL ====");
        usuario.exibirStatus();
        m1.exibirDetalhes();
        m2.exibirDetalhes();

        input.close();
    }

    public static Missao executarMissao(Scanner input, Usuario usuario, int id){

        System.out.println("++++ MISSÃO " + id + " ++++");
        System.out.println("Digite o titulo da Missão: ");
        String titulo = input.nextLine();
        System.out.println("Digite a Descrição da Missão: ");
        String descMissao = input.nextLine();
        System.out.println("Escolha a dificuldade: ");
        System.out.println("1 - FACIL");
        System.out.println("2 - MEDIA");
        System.out.println("3 - DIFICIL");
        System.out.println("4 - EPICA");

        int opcao = input.nextInt();
        Dificuldade dificuldade;

        switch (opcao){
            case 1:
                dificuldade = Dificuldade.FACIL;
                break;
            case 2:
                dificuldade = Dificuldade.MEDIA;
                break;
            case 3:
                dificuldade = Dificuldade.DIFICIL;
                break;
            case 4:
                dificuldade = Dificuldade.EPICA;
                break;
            default:
                System.out.println("Opção Inválida. Missão criada como FACIL.");
                dificuldade = Dificuldade.FACIL;
        }

        Missao missao = new Missao(id, titulo, descMissao, dificuldade);

        System.out.println("==== DADOS INICIAIS ====");
        usuario.exibirStatus();
        missao.exibirDetalhes();

        System.out.println("1 - Concluir");
        System.out.println("2 - Cancelar");

        int acao = input.nextInt();

        switch (acao){
            case 1:
                System.out.println("\n==== CONCLUINDO MISSÃO ====");
                missao.concluir(usuario);
                break;
            case 2:
                System.out.println("\n ===== MISSAO CANCELADA =====");
                missao.cancelar();
                System.out.println("Missão cancelada!");
                break;
            default:
                System.out.println("Opção invalida.");

        }
        input.nextLine();
        return missao;

    }
}
