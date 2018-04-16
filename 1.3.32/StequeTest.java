import java.util.Iterator;

public class StequeTest
{
    public static void main(String[] args) {
        Steque<Integer> s = new Steque<Integer>();

        System.out.println("size is " + s.size());
        System.out.println("s is empty? " + s.isEmpty());

        s.push(0);
        s.push(1);
        s.push(2);
        s.enqueue(-1);
        s.enqueue(-2);

        System.out.println("size is " + s.size());
        System.out.println("s is empty? " + s.isEmpty());

        for (Iterator<Integer> it = s.iterator(); it.hasNext();) {
            System.out.print(it.next() + ",");
        }
        System.out.println();

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        System.out.println("size is " + s.size());
        System.out.println("s is empty? " + s.isEmpty());

        System.out.println(s.pop());
    }
}