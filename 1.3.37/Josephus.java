/**
 * 习题 1.3.37
 * 
 * 思路：
 * 1，把N个数按顺序加入队列
 * 2，一边出列一边计数，如果计数不到M，出列的数再入列
 * 3，如果计数到了M，则打印并不再入列
 * 
 * 输入： %java Josephus 7 2
 * 输出： 1 3 5 0 4 2 6 
 */

public class Josephus
{
    public static void main(String[] args) {
        // 接受输入的参数N和M
        int N = Integer.parseInt(args[0]);
        final int M = Integer.parseInt(args[1]);

        // 定义一个计数器
        int count = 0;

        // 创建队列
        Queue<Integer> q = new Queue<Integer>();

        // 把所有序号入列
        for (int i = 0; i < N; i++) {
            q.enqueue(i);
        }

        // 开始计数，并入列、出列，如果队列空了，循环结束
        while (!q.isEmpty()) {
            int man = q.dequeue();
            count++;
            if (count == M) {
                System.out.print(man + " ");
                count = 0;
                continue;
            }
            q.enqueue(man);
        }

        System.out.println();
    }
}