public class ArrayDeque<T> {
    T[] deque;
    private int size;
    private int headPointer;

    public ArrayDeque() {
        deque =(T[]) new Object[8];
        size = 0;
        headPointer = 0;
    }

    private void resize(int length) {
        T[] resizeDeque = (T[]) new Object[length];
        System.arraycopy(deque, 0, resizeDeque, 0, deque.length);
        deque = resizeDeque;
    }

    public void addFirst(T items) {
        if (size == deque.length) {
            resize(deque.length*2);
        }
        int firstIndex = (headPointer+deque.length+1) % deque.length;
        deque[firstIndex] = items;
        size += 1;
    }

    public void addLast(T items) {
        if (size == deque.length) {
            resize(deque.length*2);
        }
        int  lastIndex = (headPointer+size) % deque.length;
        deque[size] = items;
        size += 1;
    }

    public boolean isEmpty() {
        return size > 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(T item: deque) {
            System.out.print(item+" ");
        }
    }

    public T removeFirst() {
        T item = deque[0];
        System.arraycopy(deque, 1, deque, 0, size-1);
        deque[size-1] = null;
        return item;
    }

    public T removeLast() {
        T item = deque[size-1];
        deque[size-1] = null;
        size -= 1;
        return item;
    }

    public T get(int index) {
        return deque[index];
    }


}