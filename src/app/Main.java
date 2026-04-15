package app;

import enums.Dificuldade;
import model.Missao;
import model.Usuario;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("====== SEJA BEM VINDO AO QUESTIFY ======");

        System.out.println("Digite seu nome de usuario: ");
        String nomeUsuario = input.nextLine();

        Usuario usuario = new Usuario(1, nomeUsuario);
        ArrayList<Missao> missoes = new ArrayList<>();

        int id = 1;
        boolean controle = true;

        while (controle){

            mostrarMenu();

            int opcao = input.nextInt();

            switch (opcao){
                case 1:
                    Missao missaoCriada = executarMissao(input, usuario, id);
                    missoes.add(missaoCriada);
                    id++;
                break;
                case 2:
                    mostrarMissao(usuario, missoes);
                break;
                case 3:
                    Missao m = selecionarMissao(input, missoes);
                    if (m != null){
                        m.concluir(usuario);
                    }
                    break;
                case 4:
                    Missao missaoCancela = selecionarMissao(input, missoes);
                    if( missaoCancela != null){
                        missaoCancela.cancelar();
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o sistema.");
                    controle = false;
                break;
                default:
                    System.out.println("Opção Invalida.");
                break;
            }
        }
        input.close();
    }

    public static Missao executarMissao(Scanner input, Usuario usuario, int id){

        input.nextLine();
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


        input.nextLine();
        return missao;

    }

    public static void mostrarMenu(){
        System.out.println("\n =====MENU DO SISTEMA====");
        System.out.println("1 - Criar Missão");
        System.out.println("2 - Ver Status e Missões");
        System.out.println("3 - Concluir Missão");
        System.out.println("4 - Cancelar Missão");
        System.out.println("5 - Sair");
    }

    public static Missao selecionarMissao(Scanner input, ArrayList<Missao> missoes){
        System.out.println("\n =====MISSÔES ====");

        if(missoes.isEmpty()){
            System.out.println("lista de missões vazia.");
            return null;
        }

        for(Missao missao : missoes){
            missao.exibirDetalhes();
        }

        System.out.println("digite o número da missão desejada: ");
        int escolha = input.nextInt();

        int indice = escolha - 1;

        if (indice >= 0 && indice < missoes.size()){
            return missoes.get(indice);
        } else{
            System.out.println("Missão invalida.");
            return null;
        }

    }

    public static void mostrarMissao(Usuario usuario, ArrayList<Missao> missoes ){
        System.out.println("\n ====== Status e Missões ======");
        usuario.exibirStatus();

        if (missoes.isEmpty()){
            System.out.println("Nenhuma missão foi criada.");
            return;
        }
        for (Missao missao : missoes){
            missao.exibirDetalhes();
        }
    }
}
