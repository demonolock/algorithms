import java.util.Iterator;

public class LinkedStack<Item> implements IStack<Item> {

    private Node<Item> head;
    private int size;

    public LinkedStack() {
        head = new Node<Item>(null, null);
        size = 0;
    }

    @Override
    public void push(Item item) {
        if (isEmpty())
            head.item = item;
        else {
            Node<Item> curr = head;
            while (curr.next != null)
                curr = curr.next;
            Node<Item> elm = new Node<Item>(item, null);
            curr.next = elm;
        }
        size++;
    }

    @Override
    public Item pop() {
        Item elm = null;
        if (size == 1){
            elm = head.item;
            head = null;
        }
        else {
            Node<Item> curr = head;
            while (curr.next.next != null)
                curr = curr.next;
            elm = curr.next.item;
            curr.next = null;
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
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {

        Node<Item> curr;

        public LinkedStackIterator() {
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

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}

