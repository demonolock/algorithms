import java.util.Comparator;
import java.util.Iterator;

/**
 * Итератор возвращающий последовательность из N возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 *
 * Time = O(n + k * log n),
 *  n — количество итераторов
 *  k — суммарное количество элементов
 */
public class MergingPeekingIncreasingIterator implements Iterator<Integer> {

    PeekingIncreasingIterator iter[] = new PeekingIncreasingIterator[10];

    private Comparator<PeekingIncreasingIterator> comparator = (p1, p2) -> p1.peek().compareTo(p2.peek());

    public MergingPeekingIncreasingIterator(PeekingIncreasingIterator... peekingIterator) {
        /* TODO: implement it */
//        for (int i = 0; i < peekingIterator.length; i++) {
//            peekingIterator[i].hasNext();
//        }
        iter = peekingIterator;
    }

    @Override
    public boolean hasNext() {
        for (int i = 0; i < iter.length; i++)
            if (iter[i].hasNext())
                return true;
        return false;
    }

    @Override
    public Integer next() {
        PeekingIncreasingIterator min;
        int i = 0;
        while (!iter[i].hasNext())
            i++;
        min = iter[i];
        for (; i < iter.length; i++)
            if (iter[i].hasNext())
                if (comparator.compare(iter[i], min) < 0)
                    min = iter[i];
        return min.next();
    }
}
