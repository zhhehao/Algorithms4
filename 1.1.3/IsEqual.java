/*
* 从命令行得到三个参数，如果它们都相同则打印euqal，否则打印not equal
*/

public class IsEqual
{
	public static void main(String[] args)
	{
		int[] a = new int[3];
		for (int i = 0; i < 3; i++)
		{
			a[i] = Integer.parseInt(args[i]);
		}

		if (a[0] == a[1] && a[0] == a[2])
			System.out.println("equal");
		else
			System.out.println("not equal");
	}
}
