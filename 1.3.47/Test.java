import java.util.Iterator;

public class Test
{
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s2.push(-1);
        s2.push(-2);
        s2.push(-3);
        s1.catenation(s2);

        for (Iterator<Integer> it = s1.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Queue<Integer> q1 = new Queue<Integer>();
        Queue<Integer> q2 = new Queue<Integer>();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q2.enqueue(-1);
        q2.enqueue(-2);
        q2.enqueue(-3);
        q1.catenation(q2);

        for (Iterator<Integer> it = q1.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Steque<Integer> t1 = new Steque<Integer>();
        Steque<Integer> t2 = new Steque<Integer>();
        t1.enqueue(1);
        t1.enqueue(2);
        t1.enqueue(3);
        t2.enqueue(-1);
        t2.enqueue(-2);
        t2.enqueue(-3);
        t1.catenation(t2);

        for (Iterator<Integer> it = t1.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}