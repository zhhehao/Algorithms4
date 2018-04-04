/*
 * 习题 1.2.6
 * 思路：在s1中寻找s2的第一个字符，找到位置后，把s1分成两个串，前后交换形成新串，再与s2比较。
 */

public class CircularRotation
{
    public static void main(String[] args)
    {
        String s1 = args[0];
        String s2 = args[1];

        if (cir(s1, s2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean cir(String s1, String s2)
    {
        int index = s1.indexOf(s2.charAt(0), 0);

        while(index != -1)
        {
            String s3 = s1.substring(index) + s1.substring(0, index);
            if (s2.equals(s3))
                return true;
            index = s1.indexOf(s2.charAt(0), index+1);
        }

        return false;
    }
}
