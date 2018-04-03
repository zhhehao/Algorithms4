/*
问题：编写一个Point2D的用例，从命令行接受一个整数N。在单位正方形中生成N个随机点，然后计算两点之间的最近距离。

思路：
    1，Point2D数组存储点，使用二层循环计算最短距离
    2，画图

*/

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class Point2DTest
{
    public static void main(String[] args)
    {

        int N = Integer.parseInt(args[0]);

        // 绘制正方形
        StdDraw.setXscale(0, 1.0);
        StdDraw.setYscale(0, 1.0);
        StdDraw.setPenRadius(.005);
        StdDraw.setPenColor(StdDraw.RED);

        Point2D[] a = new Point2D[N];

        // 生成N个点，并绘制
        for (int i = 0; i < N; i++)
        {
            a[i] = new Point2D(StdRandom.random(), StdRandom.random());
            a[i].draw();
        }


        double minDist = 2.0; // 因为两点之间最大距离是1.0
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            {
                if (i == j)
                    continue;
                double d = a[i].distanceTo(a[j]);
                if ( d < minDist)
                    minDist = d;
            }

        // StdOut.printf("最短距离是：%.4f\n", minDist);
        StdOut.printf("Shortest dist is %.4f\n", minDist);
    }
}
