import java.util.Iterator;

public class IteradorAdyacentes<T> implements Iterator<Integer> {
    private final Iterator<Arco<T>> itArcos;

    public IteradorAdyacentes(Iterator<Arco<T>> itArcos) {
        this.itArcos = itArcos;
    }

    @Override
    public boolean hasNext() {
        return this.itArcos.hasNext();
    }

    @Override
    public Integer next() {
        return this.itArcos.next().getVerticeDestino();
    }
}
