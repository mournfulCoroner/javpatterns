public class Apple implements Cloneable{
    protected float width;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Apple copy = (Apple) super.clone();
        return copy;
    }
}
