import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Grafo<T> {
    private HashMap<Integer, ArrayList<Arco<T>>> vertices;
    private int cantidadArcos;

    public Grafo() {
        this.vertices = new HashMap<>();
        this.cantidadArcos = 0;
    }

    public void agregarVertice(int verticeId) {
        if (!this.vertices.containsKey(verticeId))
            this.vertices.put(verticeId, new ArrayList<>());
    }

    public void borrarVertice(int verticeId) {
        for (int idVertice : this.vertices.keySet()) {
            this.vertices.get(idVertice).removeIf(arco -> arco.getVerticeDestino() == verticeId); // O(n)
        }
        this.vertices.remove(verticeId);
    }

    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
        if (!this.vertices.get(verticeId1).contains(arco)) { // O(n)
            this.vertices.get(verticeId1).add(arco);
            this.cantidadArcos++;
        }
    }

    public void borrarArco(int verticeId1, int verticeId2) {
        this.vertices.get(verticeId1).removeIf(arco -> arco.getVerticeDestino() == verticeId2);
        this.cantidadArcos--;
    }

    public boolean contieneVertice(int verticeId) {
        return this.vertices.containsKey(verticeId);
    }

    public boolean existeArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : this.vertices.get(verticeId1)) {
            if (arco.getVerticeDestino() == verticeId2)
                return true;
        }
        return false;
    }

    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : this.vertices.get(verticeId1)) {
            if (arco.getVerticeDestino() == verticeId2)
                return arco;
        }
        return null;
    }

    public int cantidadVertices() {
        return this.vertices.size();
    }

    public int cantidadArcos() {
        return this.cantidadArcos;
    }

    public Iterator<Integer> obtenerVertices() {
        return this.vertices.keySet().iterator();
    }

    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        return new IteradorAdyacentes<T>(this.vertices.get(verticeId).iterator());
    }

    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> retorno = new ArrayList<>();
        for (int verticeId : this.vertices.keySet())
            retorno.addAll(this.vertices.get(verticeId));
        return retorno.iterator();
    }

    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return this.vertices.get(verticeId).iterator();
    }

}
