import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SafeSet<E> implements Set<E> {
    HashSet<E> set;

    public SafeSet(int size) {
        set = new HashSet<>(size);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return set.toArray(ts);
    }

    @Override
    public String toString() {
        return set.toString();
    }

    @Override
    public synchronized boolean add(E e) {
        return set.add(e);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return set.containsAll(collection);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends E> collection) {
        return set.addAll(collection);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        return set.retainAll(collection);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        return set.retainAll(collection);
    }

    @Override
    public synchronized void clear() {
        set.clear();
    }
}
