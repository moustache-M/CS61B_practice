public class LinkedListDeque<T> {
    private class DequeNode {
        public DequeNode prev;
        public T item;
        public DequeNode next;

        public DequeNode(DequeNode prevNode, T items, DequeNode nextNode) {
            prev = prevNode;
            item = items;
            next = nextNode;
        }
    }

    private int size;

    public DequeNode sentinel;

    public LinkedListDeque() {
        sentinel = new DequeNode(sentinel, null, sentinel);
        size = 0;
    }


    public void addFirst(T items) {
        sentinel.next = new DequeNode(sentinel, items, sentinel.next);
        size = size + 1;
    }

    public void addLast(T items) {
        sentinel.prev = new DequeNode(sentinel.prev, items, sentinel);
    }

    public boolean isEmpty() {
        return size > 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = size;
        DequeNode deque = sentinel;
        while (i > 0) {
            deque = deque.next;
            System.out.print(deque.item);
            System.out.print(i > 1 ? " " : null);
            i -= 1;
        }
    }

    public T removeFirst() {
        DequeNode first = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return first.item;
    }

    public T removeLast() {
        DequeNode last = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return last.item;
    }

    public T get(int index) {
        DequeNode indexDeque = sentinel;
        while (index <= size && index > 0) {
            if (index == 1) {
                break;
            }
            index -= 1;
        }

        /** contains the case of index is bigger than size or equals 0 and normal case */
        return indexDeque.item;
    }

    private T helper(DequeNode  indexDeque, int index) {
        if (index > size || index == 1 || index <= 0) {
            return indexDeque.item;
        }
        return helper(indexDeque.next, index-1);
    }

    public T getRecursive(int index) {
        DequeNode indexDeque = sentinel;
        return helper(indexDeque, index);
    }

}
