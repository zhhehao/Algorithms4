/*
* 打印出一个M行N列的二维数组的转置（交换行和列）
*/

public class ArrayTran
{
	public static void main(String[] args)
	{
		int[][] a = {
			{1, 1, 1, 1},
			{2, 2, 2, 2},
			{3, 3, 3, 3}
		};
		
		arrayTran(a);
	}
	
	public static void arrayTran(int[][] a)
	{
		System.out.println("正常顺序");
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		
		
		System.out.println("转置顺序");
		for (int i = 0; i < a[0].length; i++) 
		{
			for (int j = 0; j < a.length; j++)
				System.out.print(a[j][i]+" ");
			System.out.println();
		}
	}
}