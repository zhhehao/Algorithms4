/*
* 打印一个二维布尔数组的内容，使用'*'表示真，使用空格表示假。
* 打印行号和列号。
*/

public class Print2DBool
{
	public static void main(String[] args)
	{
		boolean[][] a = {
			{true, false, false, true},
			{false, false, true, true},
			{true, true, true, true},
			{true, false, true, false}
		};

		print2D(a, 4, 4);
	}

	public static void print2D(boolean[][] a, int row, int col)
	{
		System.out.print("    ");

		for (int i = 1; i <= col; i++)
			System.out.printf("%4d", i);

		System.out.println();

		for (int i = 0; i < row; i++)
		{
			System.out.printf("%4d", i+1);
			for (int j = 0; j < col; j++)
			{
				if (a[i][j])
					System.out.printf("%4c", '*');
				else
					System.out.print("    ");
			}
			System.out.println();
		}
	}
}
