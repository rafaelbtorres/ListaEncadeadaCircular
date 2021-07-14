package listaenc_circular;

import java.util.Scanner;

public class ListaCircular {

    static Pivo pivo;
    static String sel;

    public static void main(String[] args) {

        ListaCircular lista = new ListaCircular();
        //Inicia lista padrão
        iniciaLista();
        //Interação com usuario
        lista.controleLista();
    }

    
    //Interação com usuário e controle da 
    public void controleLista() {
        Scanner e = new Scanner(System.in);
        System.out.println("\n----------|Lista atual:|---------- ");
        imprimeLista();
        System.out.println("\nO que deseja fazer na lista?");
        System.out.println("(A)dicionar (E)xcluir (I)mprimir Nó Atual (S)air");
        String escolha = e.next();

        switch (escolha) {
            case "a":
            case "A":
                System.out.println("Insira o valor:");
                inserirDadoInicio(e.nextInt());
                System.out.println("Dado inserido com sucesso!");
                
                
                controleLista();
            case "e":
            case "E":
                deletaDado();
                System.out.println("Dado do pivo excluido com sucesso!");
                controleLista();
            case "i":
            case "I":
                System.out.println("\n----------|Nó atual|----------");
                pivoToString();
                System.out.println("------------------------------");
                System.out.println("(P)ular de Nó  (S)air");
                sel = e.next();
                while(sel.equalsIgnoreCase("p")){
                    moverPivo();
                    System.out.println("\n----------|Nó atual|----------");
                    pivoToString();
                    System.out.println("------------------------------");
                    System.out.println("(P)ular de Nó  (S)air");
                    sel = e.next();
                }
                controleLista();
            case "s":
            case "S":
                System.out.println("\n----------|Até logo!|----------");
                break;
            default:
                System.out.println("\n----------|Opção inválida, tente novamente!|----------");
                controleLista();
        }
    }

    
    //Deleta o dado que está no pivo da lista
    private static void deletaDado() {
        Pivo tmp = pivo;
        while (tmp.prox != pivo) {
            tmp = tmp.prox;
        }
        Pivo prox = tmp;
        Pivo primeiro = prox.prox;
        prox.prox = primeiro.prox;
        primeiro = primeiro.prox;
        pivo = primeiro;
    }

    
    //Inicia a lista com valores de 1 a 4 padrão
    private static void iniciaLista() {
        Pivo node1 = new Pivo(1);
        Pivo node2 = new Pivo(2);
        Pivo node3 = new Pivo(3);
        Pivo node4 = new Pivo(4);
        node1.prox = node2;
        node2.prox = node3;
        node3.prox = node4;
        node4.prox = node1;
        pivo = node1;
    }

    
    //mostra a lista atualmente organizada
    private static void imprimeLista() {
        Pivo tmp = pivo;
        while (tmp.prox != pivo) {
            System.out.print(tmp.dado + "-->");
            tmp = tmp.prox;
        }
        System.out.println(tmp.dado);
    }
    
    //mostra a lista atualmente organizada
    private void pivoToString() {
        int dado = pivo.dado;
        int prox = pivo.prox.dado;
        System.out.println("Dado do nó atual: "+dado+"\nDado do proximo nó: "+prox);
    }
    
    //mostra a lista atualmente organizada
    private void moverPivo() {
        pivo = pivo.prox;
    }

    
    //O metodo adiciona um dado no inicio da lista
    private static void inserirDadoInicio(int valor) {
        Pivo node = new Pivo(valor);
        Pivo primeiro = pivo;
        
        while (primeiro.prox != pivo) {
            primeiro = primeiro.prox;
        }
        primeiro.prox = node;
        node.prox = pivo;
        pivo = node;
    }
    
    
    //O metodo adiciona um dado no final da lista
    private static void inserirDadoFinal(int valor) {
        Pivo node = new Pivo(valor);
        Pivo ultimo = pivo;
        
        while (pivo != ultimo.prox) {
            ultimo = ultimo.prox;
        }
        ultimo.prox = node;
        node.prox = pivo;
        pivo = node;
    }

    
    //Instancia o pivo para controle da lista
    static class Pivo {

        int dado;
        Pivo prox;

        Pivo(int valor) {
            this.dado = valor;
        }
    }
}
