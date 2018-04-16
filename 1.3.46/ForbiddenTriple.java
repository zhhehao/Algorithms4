/**
 * 习题 1.3.46
 * 
 * 思路：
 * 
 * 利用习题1.3.3来测试
 */

public class ForbiddenTriple
{
    private static int max;
    private static int min;
    private static boolean getMaxMin(Queue<Integer> q) {
        // 为了简化，此处不作队列长度的检查
        max = q.dequeue();
        min = q.dequeue();
        while (min > max) {
            max = min;
            if (q.isEmpty()) {
                return false;
            }
            min = q.dequeue();
        }
        return true;
    }
    public static boolean hasForbiddenTriple(String s) {
        String[] str = s.split(" ");
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < str.length; i++) {
            q.enqueue(Integer.parseInt(str[i]));
        }
        if (!getMaxMin(q)) {
            return true;
        }

        while (!q.isEmpty()) {
            int num = q.peek();
            if (num > max) { // 重新获取 max 和 min
                if (!getMaxMin(q)) {
                    return true;
                }
                continue;
            }
            if (num < min) { // 更新min
                min = q.dequeue();
                continue;
            }
            if (num > min) { // 发现三元组
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasForbiddenTriple("4 3 2 1 0 9 8 7 6 5"));
        System.out.println(hasForbiddenTriple("4 6 8 7 5 3 2 9 0 1"));
        System.out.println(hasForbiddenTriple("2 5 6 7 4 8 9 3 1 0"));
        System.out.println(hasForbiddenTriple("4 3 2 1 0 5 6 7 8 9"));
        System.out.println(hasForbiddenTriple("1 2 3 4 5 6 9 8 7 0"));
        System.out.println(hasForbiddenTriple("0 4 6 5 3 8 1 7 2 9"));
        System.out.println(hasForbiddenTriple("1 4 7 9 8 6 5 3 0 2"));
        System.out.println(hasForbiddenTriple("2 1 4 3 6 5 8 7 9 0"));
    }    
}