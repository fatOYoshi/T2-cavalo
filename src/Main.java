
public class Main {
    public static void main(String[] args) {
        // 1. Leitura do Grafo (Formato algs4)
        In in = new In("dados/entrada.txt");
        Graph G = new Graph(in);

        // Pergunta 1: Lista de Adjacência
        System.out.println("Lista de adjacência:");
        System.out.print(G.toString());

        // Pergunta 2: Componentes Conexas
        CC cc = new CC(G);
        int m = cc.count();
        System.out.println("\nComponentes conexas: " + m);
        for (int i = 0; i < m; i++) {
            System.out.print("Vértices da componente " + i + ": ");
            for (int v = 0; v < G.V(); v++) {
                if (cc.id(v) == i) System.out.print(v + " ");
            }
            System.out.println();
        }

        // Pergunta 3: Distância mínima (0,0) -> 0 até (2,2) -> 8
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);
        if (bfs.hasPathTo(8)) {
            System.out.println("\nDistância mínima entre (0,0) e (2,2): " + bfs.distTo(8));
        } else {
            System.out.println("\nNão há caminho entre (0,0) e (2,2).");
        }

        // Pergunta 4 : Ciclo
        Cycle finder = new Cycle(G);
        if (finder.hasCycle()) {
            System.out.println("\nO grafo possui ciclo: Sim");
            System.out.print("Um ciclo encontrado: ");
            for (int v : finder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("\nO grafo possui ciclo: Não");
        }
        

    }


}