
/**
 * API 
 * public class ResizingArrayQueueOfStrings
 * -------------------------------------------
 *              ResizingArrayQueueOfStrings()
 *      void    enqueue(String s)
 *      String  dequeue()
 *      boolean isEmpty()
 *      int     size()
 */

public class TestCase
{
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
        System.out.println(q.size());
        System.out.println(q.isEmpty());

        q.enqueue("first string");
        q.enqueue("second string");
        q.enqueue("third string");
        System.out.println(q.size());
        System.out.println(q.dequeue());
        System.out.println(q.size());
        q.enqueue("fourth string");
        System.out.println(q.size());

        System.out.println(q.isEmpty());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        // 测试空队列出列异常
        // System.out.println(q.dequeue());

        // 测试resize功能
        for (int i = 0; i < 100; i++) {
            q.enqueue("a");
            // System.out.println("arr's size is " + q.arrLength());
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(i + ": " + q.dequeue());
            // System.out.println("arr's size is " + q.arrLength());
        }

    }
}