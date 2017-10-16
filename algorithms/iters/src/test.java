public class test {
    public static void main(String[] args) {
        PeekingIncreasingIterator it0 = new PeekingIncreasingIterator(0, 20, 5);
        PeekingIncreasingIterator it1 = new PeekingIncreasingIterator(0, 20, 5);
        PeekingIncreasingIterator it2 = new PeekingIncreasingIterator(0, 20, 5);
        MergingPeekingIncreasingIterator it = new MergingPeekingIncreasingIterator(it0, it1, it2);
        while (it.hasNext())
            System.out.println(it.next());
    }
}
