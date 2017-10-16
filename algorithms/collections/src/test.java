import java.util.Iterator;


public class test {
    public static void main(String[] args) {
        /*ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 20; i ++)
            stack.push(i);
        for (int i = 0; i < 20; i ++)
            System.out.println(stack.pop());*/

        /*LinkedStack<Integer> stack1 = new LinkedStack<>();
        for (int i = 0; i < 20; i ++)
            stack1.push(i);
        for (int i = 0; i < 20; i ++)
            System.out.println(stack1.pop());*/

        /*LinkedQueue<Integer> stack2 = new LinkedQueue<>();
        for (int i = 0; i < 20; i ++)
            stack2.enqueue(i);
        for (int i = 0; i < 20; i ++)
            System.out.println(stack2.dequeue());*/

        /*TwoStackQueue<Integer> stack3 = new TwoStackQueue<>();
        for (int i = 0; i < 20; i ++)
            stack3.enqueue(i);
        for (int i = 0; i < 20; i ++)
            System.out.println(stack3.dequeue());*/

        /*CyclicArrayQueue<Integer> stack4 = new CyclicArrayQueue<>();
        for (int i = 0; i < 20; i ++)
            stack4.enqueue(i);
        for (int i = 0; i < 20; i ++)
            System.out.println(stack4.dequeue());*/

        LinkedDeque<Integer> stack5 = new LinkedDeque<>();
        for (int i = 0; i < 20; i++)
            stack5.pushFront(i);
        Iterator<Integer> iter = stack5.iterator();
        for (int i = 0; i < 20; i++)
            System.out.println(stack5.popFront());

    }
}
