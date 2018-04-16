import java.util.Iterator;

public class Test
{
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);

        for (Iterator<Integer> it = s.iterator(); it.hasNext();) {
            System.out.print(it.next() + ":");
            s.push(9);
        }
        System.out.println();
    }
}