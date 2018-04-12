import java.util.Iterator;

public class StackTest
{
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            s.push(i);
        }

        System.out.println("遍历栈s：");
        for (Iterator<Integer> it = s.iterator(); it.hasNext();) {
            System.out.print(it.next() + ",");
        }
        System.out.println();

        Stack<Integer> t = new Stack<Integer>(s);
        System.out.println("遍历栈t：");
        for (Iterator<Integer> it = t.iterator(); it.hasNext();) {
            System.out.print(it.next() + ",");
        }
        System.out.println();
    }
}