package app;

import enums.Dificuldade;
import enums.StatusMissao;
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
                    System.out.println("\n===== FILTRAR MISSÕES =====");
                    System.out.println("1 - Pendentes");
                    System.out.println("2 - Concluídas");
                    System.out.println("3 - Canceladas");

                    int filtro = input.nextInt();

                    switch (filtro){
                        case 1:
                            mostrarMissoesPorStatus(missoes, StatusMissao.PENDENTE);
                            break;
                        case 2:
                            mostrarMissoesPorStatus(missoes, StatusMissao.CONCLUIDA);
                            break;
                        case 3:
                            mostrarMissoesPorStatus(missoes, StatusMissao.CANCELADA);
                            break;
                        default:
                            System.out.println("Opção invalidade.");
                    }
                    break;
                case 6:
                    Missao missaoRemovida = selecionarMissao(input, missoes);
                    if(missaoRemovida != null){
                        missoes.remove(missaoRemovida);
                        System.out.println("Missão removida com sucesso!");
                    }

                    break;
                case 7:
                    System.out.println("Digite o ID da missão: ");
                    int idBusca = input.nextInt();

                    Missao missaoEncontrada = buscarMissaoPorId(missoes, idBusca);

                    if (missaoEncontrada != null){
                        missaoEncontrada.exibirDetalhes();
                    } else {
                        System.out.println("Missão não encontrada.");
                    }
                    break;
                case 8:
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
        System.out.println("5 - Filtrar Missões");
        System.out.println("6 - Remover Missões");
        System.out.println("7 - Buscar Missões por ID");
        System.out.println("8 - Sair");
    }

    public static Missao selecionarMissao(Scanner input, ArrayList<Missao> missoes){
        System.out.println("\n =====MISSÔES ====");

        if(missoes.isEmpty()){
            System.out.println("lista de missões vazia.");
            return null;
        }

        for(int i = 0; i < missoes.size(); i++){
            Missao missao = missoes.get(i);

            System.out.println(
                    (i + 1) + " - " + missao.getTitulo() + " [ " + missao.getStatusMissao() + " ]"
            );
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

        System.out.println("\n =========== Missões =========");

        for(int i = 0; i < missoes.size(); i++){
            Missao missao = missoes.get(i);

            System.out.println(
                    (i + 1) + " - " + missao.getTitulo() + " [ " + missao.getStatusMissao() + " ]"
            );
        }
    }

    public static void mostrarMissoesPorStatus(ArrayList<Missao> missoes, StatusMissao status ){
        if(missoes.isEmpty()){
            System.out.println("Nenhuma missão foi criada.");
            return;
        }
        boolean encontrou = false;

        for (int i = 0; i < missoes.size(); i++){
            Missao missao = missoes.get(i);
            if (missao.getStatusMissao() == status){
                System.out.println(
                        (i + 1) + " - " + missao.getTitulo() + " [" + missao.getStatusMissao() + "]"
                );
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("Nenhuma missão foi encontrada com esse status.");
        }
    }

    public static Missao buscarMissaoPorId(ArrayList<Missao> missoes, int id){
        for(Missao missao : missoes){
            if(missao.getId() == id){
                return missao;
            }
        }
        return null;
    }
}
