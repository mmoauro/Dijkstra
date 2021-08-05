import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Dijkstra {
    private Grafo<Integer> grafo;
    private HashMap<Integer, Integer> distancias;
    private HashMap<Integer, Integer> padres;
    private ArrayList<Integer> visitados;

    public Dijkstra (Grafo<Integer> grafo) {
        this.grafo = grafo;
        this.distancias = new HashMap<>();
        this.padres = new HashMap<>();
        this.visitados = new ArrayList<>();
    }

    public HashMap<Integer, Integer>  recorrer (int origen) {
        for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext(); ) {
            Integer id = it.next();
            distancias.put(id, null);
            padres.put(id, null);
        }
        this.distancias.put(origen, 0);
        return this.privateRecorrer(origen);
    }

    private HashMap<Integer, Integer> privateRecorrer (int originVertex) {
        this.visitados.add(originVertex);
        // Obtengo los adyacentes del origen
        Iterator<Integer> it = this.grafo.obtenerAdyacentes(originVertex);
        while (it.hasNext()) {
            Integer id = it.next();
            int distanciaArco = this.grafo.obtenerArco(originVertex, id).getEtiqueta();
            if (this.distancias.get(id) == null || this.distancias.get(id) > this.distancias.get(originVertex) + distanciaArco) {
                this.distancias.put(id, this.distancias.get(originVertex) + distanciaArco);
                this.padres.put(id, originVertex);
            }
        }
        // Por cual vertice sigo?
        Integer menorDistance = Integer.MAX_VALUE;
        Integer id = null;
        Iterator<Integer> vertex = this.grafo.obtenerVertices();
        while (vertex.hasNext()) {
            Integer idV = vertex.next();
            if (!this.visitados.contains(idV)) {
                if (this.distancias.get(idV) != null && this.distancias.get(idV) < menorDistance) {
                    menorDistance = this.distancias.get(idV);
                    id = idV;
                }
            }
        }
        if (id != null)
            this.privateRecorrer(id);
        return this.distancias;
    }


}
