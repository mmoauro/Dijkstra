
public class Arco<T> {

    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }
    @Override
    public boolean equals (Object o) {
        try {
            Arco<T> arco = (Arco<T>) o;
            return arco.getVerticeOrigen() == this.getVerticeOrigen() && arco.getVerticeDestino() == this.getVerticeDestino();
        }
        catch (Exception e) {
            return false;
        }
    }

}