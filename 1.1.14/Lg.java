/*
* 编写一个静态方法lg()，接受一个整形参数N，返回不大于log2N的最大整数。
* 不要使用Math库。
*/

public class Lg
{
	public static void main(String[] args)
	{
		int T = lg(1024);
		if (T > 0)
			System.out.println("T is " + T);
	}

	public static int lg(int N)
	{
		if (N <= 0)
		{
			System.out.println("N应该是一个大于0的整数。");
			return -1;
		}

		int T = 1, cnt = 0;

		while (T <= N)
		{
			T = T << 1;
			cnt++;
		}

		return  cnt-1;
	}
}
