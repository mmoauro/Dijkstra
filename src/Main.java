public class Main {
    public static void main(String[] args) {
        Grafo<Integer> g = new Grafo<>();
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(10);

        g.agregarArco(1, 2, 10);
        g.agregarArco(1, 3, 5);
        g.agregarArco(3, 2, 2);
        g.agregarArco(2, 5, 1);
        g.agregarArco(5, 4, 22);
        g.agregarArco(3, 4, 12);
        g.agregarArco(5, 10, 200);

        Dijkstra d = new Dijkstra(g);
        System.out.println(d.recorrer(1));




    }
}
