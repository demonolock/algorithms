import java.util.Arrays;
import java.util.Iterator;

public class CyclicArrayDeque<Item> implements IDeque<Item> {

    private static final int DEFAULT_CAPACITY = 10;
    private Item[] elementData;
    private int head;
    private int tail;
    private int size;

    public CyclicArrayDeque() {
        this.elementData = (Item[]) new Object[DEFAULT_CAPACITY];
        head = tail = 0;
        size = 0;
    }

    @Override
    public void pushFront(Item item) {
        if (size == elementData.length)
            grow();
        if (head == -1)
            head = elementData.length - 1;
        elementData[head--] = item;
        size++;
    }

    @Override
    public void pushBack(Item item) {
        if (size == elementData.length)
            grow();
        if (tail == elementData.length)
            tail = 0;
        elementData[tail++] = item;
        size++;
    }

    @Override
    public Item popFront() {
        Item item = elementData[head];
        if (size * 4 < elementData.length)
            shrink();
        if (head == elementData.length-1)
            head = 0;
        size--;
        return item;
    }

    @Override
    public Item popBack() {
        Item item = elementData[head];
        if (size * 4 < elementData.length)
            shrink();
        if (tail == 0)
            tail = elementData.length - 1;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void grow() {
        changeCapacity((int)(elementData.length * 1.5D));
    }

    private void shrink() {
        changeCapacity((int)(elementData.length / 2D));
    }

    private void changeCapacity(int newCapacity) {
        if (head !=0 ) {
            if (head < tail) {
                for (int i = head; i < tail; i++)
                    elementData[i - head] = elementData[i];
            } else {
                for (int i = 0; i < tail; i++)
                    elementData[i + size - tail] = elementData[i];
                for (int i = head; i < elementData.length; i++)
                    elementData[i - head] = elementData[i];
            }
        }
        head = 0;
        tail = head + size;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new CyclicArrayDequeIterator();
    }

    private class CyclicArrayDequeIterator implements Iterator<Item> {

        private int currentPosition = head;

        @Override
        public boolean hasNext() {
            return currentPosition != tail;
        }

        @Override
        public Item next() {
            return elementData[currentPosition++];
        }

    }
}
