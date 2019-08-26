
import java.io.IOException;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        CriarAgenda ca;
        ArrayList<CriarAgenda> agenda = new ArrayList();
        int opcao = 0;
        Ler l = new Ler();
        l.nome();
        agenda = l.getAgenda();
        try {
            while (opcao != 9) {
                System.out.println("1-Adicionar Contato");
                System.out.println("2-Busca");
                System.out.println("3-Lista de Contatos");
                System.out.println("4-Remover Contato");
                System.out.println("5-Editar Contato");
                System.out.println("9-Encerrar");
                Collections.sort(agenda);
                Salvar s = new Salvar(agenda);
                opcao = teclado.nextInt();
                switch (opcao) {
                    case 1:
                        teclado.nextLine();
                        System.out.println("Digite o nome");
                        String nome = teclado.nextLine();
                        System.out.println("Digite o numero");
                        String numero = teclado.nextLine();
                        boolean exite = false;
                        if (exite) {
                            System.out.println("Contato existente");
                        } else {
                            agenda.add(ca = new CriarAgenda(nome, numero));
                        }
                        break;
                    case 2:
                        System.out.println("Digite o nome do contato que deseja buscar");
                        String buscar = teclado.next();
                        exite = false;
                        for (CriarAgenda caa : agenda) {
                            if (caa.getNome().toLowerCase().contains(buscar.toLowerCase())) {
                                System.out.println(caa.getNome() + ", " + caa.getNumero());
                                exite = true;
                            }
                        }
                        if (exite == false) {
                            System.out.println("não exite");
                        }
                        break;
                    case 3:
                        for (CriarAgenda caa : agenda) {
                            System.out.println(caa.getNome() + ", " + caa.getNumero());
                        }
                        System.out.println("");
                        break;
                    case 4:
                        System.out.println("Digite o nome do contato que deseja remover");
                        teclado.nextLine();
                        String remover = teclado.nextLine();
                        boolean v = false;
                        boolean vv = false;
                        int index = 0;
                        int posicao = 0;
                        int quantidade = 0;
                        boolean existencia = false;
                        String pessoaExcluida = "";
                        for (CriarAgenda caa : agenda) {
                            if (caa.getNome().equals(remover)) {
                                existencia = true;
                                quantidade++;
                            }
                        }
                        if (existencia == false) {
                            System.out.println("não exite");
                        } else {
                            if (quantidade == 1) {
                                for (CriarAgenda caa : agenda) {
                                    if (caa.getNome().equals(remover)) {
                                        v = true;
                                        posicao = index;
                                        pessoaExcluida = caa.getNome();
                                    }
                                    index++;
                                }

                            } else {
                                quantidade = 0;
                                vv = true;
                                System.out.println("qual desse contatos deseja excluir");
                                for (CriarAgenda caa : agenda) {
                                    if (caa.getNome().equals(remover)) {
                                        System.out.println(quantidade + " " + caa.getNome() + " " + caa.getNumero());
                                        existencia = true;
                                    }
                                    quantidade++;
                                }
                            }
                            String opcao2 = "0";
                            String opcao3 = "0";
                            if (v) {
                                System.out.println("Deseja remover SIM(1) ou NÃO(2)");
                                opcao2 = teclado.next();
                                switch (opcao2) {
                                    case "1":
                                        agenda.remove(posicao);
                                        System.out.println(pessoaExcluida + " Foi Excluido com sucesso" + "\n");
                                        break;
                                    case "2":
                                        System.out.println("cancelado");
                                        break;
                                    default:
                                        System.out.println("comando invalido tente mais tarde");
                                        break;
                                }


                            } else if (vv) {
                                int entrada = teclado.nextInt();
                                String nn = agenda.get(entrada).getNome();
                                System.out.println("Deseja remover SIM(1) ou NÃO(2)");
                                opcao3 = teclado.next();
                                switch (opcao3) {
                                    case "1":
                                        agenda.remove(entrada);
                                        System.out.println(nn + " Foi Excluido com sucesso" + "\n");
                                        break;
                                    case "2":
                                        System.out.println("cancelado");
                                        break;
                                    default:
                                        System.out.println("comando invalido tente mais tarde");
                                        break;
                                }
                            } else {
                                System.out.println("não exite");
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Digite o nome do contato que deseja Editar");
                        teclado.nextLine();
                        String editar = teclado.nextLine();
                        v = false;
                        vv = false;
                        index = 0;
                        posicao = 0;
                        quantidade = 0;
                        existencia = false;
                        pessoaExcluida = "";
                        for (CriarAgenda caa : agenda) {
                            if (caa.getNome().equals(editar)) {
                                existencia = true;
                                quantidade++;
                            }
                        }
                        if (existencia == false) {
                            System.out.println("não exite");
                        } else {
                            if (quantidade == 1) {
                                for (CriarAgenda caa : agenda) {
                                    if (caa.getNome().equals(editar)) {
                                        v = true;
                                        posicao = index;
                                        pessoaExcluida = caa.getNome();
                                    }
                                    index++;
                                }

                            } else {

                                quantidade = 0;
                                vv = true;
                                System.out.println("qual desse contatos deseja editar");
                                for (CriarAgenda caa : agenda) {
                                    if (caa.getNome().equals(editar)) {
                                        System.out.println(quantidade + " " + caa.getNome() + " " + caa.getNumero());
                                        existencia = true;
                                    }
                                    quantidade++;
                                }
                            }
                            String opcao2 = "0";
                            String opcao3 = "0";
                            if (v) {
                                System.out.println("Deseja editar nome ou numero?");
                                String escolha = teclado.next();
                                switch (escolha){
                                    case "nome":
                                        teclado.nextLine();
                                        System.out.println("Digite Novo Nome");
                                        String eNome = teclado.nextLine();
                                        System.out.println("Deseja editar SIM(1) ou NÃO(2)");
                                        opcao2 = teclado.next();
                                        switch (opcao2) {
                                            case "1":
                                                agenda.set(posicao, ca = new CriarAgenda(eNome,agenda.get(posicao).getNumero()));
                                                System.out.println(pessoaExcluida + " Foi Editado para " + eNome + "\n");
                                                break;
                                            case "2":
                                                System.out.println("cancelado");
                                                break;
                                            default:
                                                System.out.println("comando invalido tente mais tarde");
                                                break;
                                        }
                                        break;
                                    case "numero":
                                        teclado.nextLine();
                                        System.out.println("Digite Novo Numero");
                                        String eNumero = teclado.nextLine();
                                        System.out.println("Deseja editar " +agenda.get(posicao).getNumero()+" para "+eNumero+" SIM(1) ou NÃO(2)");
                                        opcao2 = teclado.next();
                                        switch (opcao2) {
                                            case "1":
                                                agenda.set(posicao, ca = new CriarAgenda(agenda.get(posicao).getNome(),eNumero));
                                                System.out.println(pessoaExcluida + " Foi Editado com sucesso" + "\n");
                                                break;
                                            case "2":
                                                System.out.println("cancelado");
                                                break;
                                            default:
                                                System.out.println("comando invalido tente mais tarde");
                                                break;
                                        }

                                        break;
                                    default:
                                        System.out.println("Comando invalido");
                                        break;
                                }



                            } else if (vv) {
                                int entrada = teclado.nextInt();
                                String nn = agenda.get(entrada).getNome();

                                System.out.println("Deseja editar nome ou numero?");
                                String escolha = teclado.next();
                                switch (escolha){
                                    case "nome":
                                        teclado.nextLine();
                                        System.out.println("Digite Novo Nome");
                                        String eNome = teclado.nextLine();
                                        System.out.println("Deseja editar SIM(1) ou NÃO(2)");
                                        opcao2 = teclado.next();
                                        switch (opcao2) {
                                            case "1":
                                                pessoaExcluida = agenda.get(entrada).getNome();
                                                agenda.set(entrada, ca = new CriarAgenda(eNome,agenda.get(entrada).getNumero()));
                                                System.out.println(pessoaExcluida + " Foi Editado para " + eNome + "\n");
                                                break;
                                            case "2":
                                                System.out.println("cancelado");
                                                break;
                                            default:
                                                System.out.println("comando invalido tente mais tarde");
                                                break;
                                        }
                                        break;
                                    case "numero":
                                        teclado.nextLine();
                                        System.out.println("Digite Novo Numero");
                                        String eNumero = teclado.nextLine();
                                        System.out.println("Deseja editar " +agenda.get(entrada).getNumero()+" para "+eNumero+" SIM(1) ou NÃO(2)");
                                        opcao2 = teclado.next();
                                        switch (opcao2) {
                                            case "1":
                                                agenda.set(entrada, ca = new CriarAgenda(agenda.get(entrada).getNome(),eNumero));
                                                System.out.println(agenda.get(entrada).getNome() + " Foi Editado com sucesso" + "\n");
                                                break;
                                            case "2":
                                                System.out.println("cancelado");
                                                break;
                                            default:
                                                System.out.println("comando invalido tente mais tarde");
                                                break;
                                        }

                                        break;
                                    default:
                                        System.out.println("Comando invalido");
                                        break;
                                }
                            } else {
                                System.out.println("não exite");
                            }
                        }
                        break;
                }

            }


        }catch (InputMismatchException e){
            System.out.println("Comando invalido");
            System.out.println("Causa do problema: Comando era um int e não uma String");
        }
    }
}


