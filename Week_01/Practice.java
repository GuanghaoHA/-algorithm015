package leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Practice {

    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.search(1));

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);

        /*
        [1, 2, 1, 3, 4]
        3
        4
        3
        1
        [1, 2, 1]
        */

    }

    @Test
    public void testQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("one");
        queue.offer("three");
        queue.offer("four");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);

        /*
        [one, two, one, three, four]
        one
        two
        [two, one, three, four]
        */

    }

    @Test
    public void testDeque() {
        Deque<String> deque = new LinkedList<>();
        deque.offerFirst("one");
        deque.offerFirst("two");
        deque.offerFirst("three");
        deque.offerFirst("four");
        deque.offerLast("six");
        System.out.println(deque);
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pop());
        System.out.println(deque);

        /*
        [four, three, two, one, six]
        six
        four
        three
        [two, one, six]
        */

    }

}
