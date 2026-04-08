package app;

import enums.Dificuldade;
import model.Missao;
import model.Usuario;


import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("====== SEJA BEM VINDO AO QUESTIFY ======");

        //MISSAO 1
        System.out.println("Digite seu nome de usuario: ");
        String nomeUsuario = input.nextLine();

        Usuario usuario = new Usuario(1, nomeUsuario);

        System.out.println("++++ MISSÃO 1 ++++++");
        System.out.println("Digite o titulo da missão: ");
        String tituloMissao = input.nextLine();

        System.out.println("Digite a descrição da missão: ");
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

        Missao missao = new Missao(1, tituloMissao, descMissao, dificuldade);

        System.out.println("\n==== DADOS INICIAIS ====");
        usuario.exibirStatus();
        missao.exibirDetalhes();

        System.out.println("Escolher o que fazer com a Missão: ");
        System.out.println("1 - Concluir");
        System.out.println("2 - Cancelar");
        int opcaoAcao = input.nextInt();

        switch (opcaoAcao){
            case 1:
                System.out.println("\n==== CONCLUINDO MISSÃO ====");
                missao.concluir();
                usuario.adicionarXp(missao.calcularXp());
                usuario.adicionarMoedas(missao.calcularMoedas());
                break;
            case 2:
                System.out.println("\n ===== MISSAO CANCELADA =====");
                missao.cancelar();
                System.out.println("Missão cancelada!");
                break;
            default:
                System.out.println("Opção invalida.");

        }

        // MISSAO 2
        input.nextLine();
        System.out.println("++++++ MISSAO 2 ++++++");
        System.out.println("Digite o titulo da missao 2: ");
        String tituloMissao2 = input.nextLine();

        System.out.println("Digite uma descrição da missao 2: ");
        String descMissao2 = input.nextLine();

        System.out.println("Escolha a dificuldade: ");
        System.out.println("1 - FACIL");
        System.out.println("2 - MEDIA");
        System.out.println("3 - DIFICIL");
        System.out.println("4 - EPICA");
        int opcao2 = input.nextInt();

        Dificuldade dificuldade2;
        switch (opcao2){
            case 1:
                dificuldade2 = Dificuldade.FACIL;
                break;
            case 2:
                dificuldade2 = Dificuldade.MEDIA;
                break;
            case 3:
                dificuldade2 = Dificuldade.DIFICIL;
                break;
            case 4:
                dificuldade2 = Dificuldade.EPICA;
                break;
            default:
                System.out.println("Opção Inválida. Missão criada como FACIL.");
                dificuldade2 = Dificuldade.FACIL;
        }

        Missao missao2 = new Missao(2, tituloMissao2, descMissao2, dificuldade2);
        System.out.println("\n==== DADOS INICIAIS DA MISSAO 2 ====");
        usuario.exibirStatus();
        missao2.exibirDetalhes();

        System.out.println("Escolher o que fazer com a Missão: ");
        System.out.println("1 - Concluir");
        System.out.println("2 - Cancelar");
        int opcaoAcao2 = input.nextInt();

        switch (opcaoAcao2){
            case 1:
                System.out.println("\n==== CONCLUINDO MISSÃO ====");
                missao2.concluir();
                usuario.adicionarXp(missao2.calcularXp());
                usuario.adicionarMoedas(missao2.calcularMoedas());
            break;
            case 2:
                System.out.println("\n ===== MISSAO CANCELADA =====");
                missao2.cancelar();
                System.out.println("Missão cancelada!");
                break;
            default:
                System.out.println("Opção invalida.");

        }

        System.out.println("\n==== RESULTADO DA MISSAO ====");
        usuario.exibirStatus();
        missao.exibirDetalhes();
        missao2.exibirDetalhes();

//        System.out.println("\n==== CONCLUINDO MISSÃO ====");
//        missao.concluir();
//        usuario.adicionarXp(missao.calcularXp());
//        usuario.adicionarMoedas(missao.calcularMoedas());
//
//        System.out.println("\n==== DADOS APOS CONCLUIR A MISSAO ====");
//        usuario.exibirStatus();
//        missao.exibirDetalhes();

        input.close();
    }
}
