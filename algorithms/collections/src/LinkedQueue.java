import java.util.Iterator;

public class LinkedQueue<Item> implements IQueue<Item> {

    // -> [tail -> .. -> .. -> head] ->
    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    public LinkedQueue () {
        head = tail = null;
        size = 0;
    }

    @Override
    public void enqueue(Item item) {
        Node<Item> curr = new Node<Item>(item, null);
        if (isEmpty()) {
            head = tail = curr;
        }
        else {
            tail.next = curr;
            tail = curr;
        }
        size++;
    }

    @Override
    public Item dequeue() {
        Item elm = head.item;
        if (size == 1) {
            head = tail = null;
        }
        else {
            head = head.next;
        }
        size--;
        return elm;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<Item> {

        Node<Item> curr;

        public LinkedQueueIterator() {
            Node<Item> curr = head;
        }

        @Override
        public boolean hasNext() {
            return curr.next != null;
        }

        @Override
        public Item next() {
            Node<Item> ret = curr;
            curr = curr.next;
            return ret.item;
        }

    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item) {
            this.item = item;
        }

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
