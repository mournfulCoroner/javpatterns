import java.util.*;
import java.util.concurrent.Semaphore;

public class SafeList<E> implements List<E> {
    private static final Semaphore phore = new Semaphore(1);
    private ArrayList<E> lst;

    public SafeList(int size) {
        this.lst = new ArrayList<>(size);
    }

    @Override
    public int size() {
        return lst.size();
    }

    @Override
    public boolean isEmpty() {
        return lst.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return lst.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return lst.iterator();
    }

    @Override
    public Object[] toArray() {
        return lst.toArray();
    }

    @Override
    public String toString() {
        return lst.toString();
    }

    @Override
    public boolean add(E o) {
        try {
            phore.acquire();
            boolean check = lst.add(o);
            phore.release();
            return check;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            phore.acquire();
            boolean check = lst.remove(o);
            phore.release();
            return check;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void clear() {
        lst.clear();
    }

    @Override
    public E get(int i) {
        return lst.get(i);
    }

    @Override
    public E set(int i, E o) {
        try {
            phore.acquire();
            E o1 = lst.set(i, o);
            phore.release();
            return o1;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(int i, E o) {
        try {
            phore.acquire();
            lst.add(i, o);
            phore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public E remove(int i) {
        try {
            phore.acquire();
            E o = lst.remove(i);
            phore.release();
            return o;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int indexOf(Object o) {
        return lst.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return lst.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return lst.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return lst.listIterator(i);
    }

    @Override
    public List<E> subList(int i, int i1) {
        try {
            phore.acquire();
            List<E> ch = lst.subList(i, i1);
            phore.release();
            return ch;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    @Override
    public boolean retainAll(Collection<?> collection) {
        try {
            phore.acquire();
            boolean ch = lst.retainAll(collection);
            phore.release();
            return ch;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        try {
            phore.acquire();
            boolean ch = lst.removeAll(collection);
            phore.release();
            return ch;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return lst.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        try {
            phore.acquire();
            boolean check = lst.addAll(collection);
            phore.release();
            return check;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        try {
            phore.acquire();
            boolean check = lst.addAll(i, collection);
            phore.release();
            return check;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return lst.toArray(ts);
    }
}
