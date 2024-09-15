import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Classe Tarefa
class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return (concluida ? "[Concluída] " : "[Pendente] ") + descricao;
    }
}

// Classe GerenciadorDeTarefas
class GerenciadorDeTarefas {
    private ArrayList<Tarefa> listaDeTarefas;

    public GerenciadorDeTarefas() {
        listaDeTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        listaDeTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(int index) {
        if (index >= 0 && index < listaDeTarefas.size()) {
            listaDeTarefas.remove(index);
        } else {
            System.out.println("Índice inválido. Tente novamente.");
        }
    }

    public void marcarTarefaComoConcluida(int index) {
        if (index >= 0 && index < listaDeTarefas.size()) {
            listaDeTarefas.get(index).marcarComoConcluida();
        } else {
            System.out.println("Índice inválido. Tente novamente.");
        }
    }

    public void listarTarefas() {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa adicionada.");
        } else {
            for (int i = 0; i < listaDeTarefas.size(); i++) {
                System.out.println(i + " - " + listaDeTarefas.get(i));
            }
        }
    }
}

// Classe Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Gerenciador de Tarefas ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Remover Tarefa");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Listar Tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Descrição da tarefa: ");
                        String descricao = scanner.nextLine();
                        gerenciador.adicionarTarefa(descricao);
                        break;
                    case 2:
                        System.out.print("Índice da tarefa a ser removida: ");
                        int indiceRemover = scanner.nextInt();
                        gerenciador.removerTarefa(indiceRemover);
                        break;
                    case 3:
                        System.out.print("Índice da tarefa a ser marcada como concluída: ");
                        int indiceConcluir = scanner.nextInt();
                        gerenciador.marcarTarefaComoConcluida(indiceConcluir);
                        break;
                    case 4:
                        gerenciador.listarTarefas();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();  // Consumir a entrada inválida
            }
        }
        scanner.close();
        System.out.println("Aplicação encerrada.");
    }
}
