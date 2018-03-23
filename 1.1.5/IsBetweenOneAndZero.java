/*
* 如果double类型的变量x和y都严格位于0和1之间则打印true，否则打印false。
*/

public class IsBetweenOneAndZero
{
	public static void main(String[] args)
	{
		boolean is_true = true;
		for (int i = 0; i < 2; i++)
		{
			double d = Double.parseDouble(args[i]);
			if (d <= 0.0 || d >= 1.0)
			{
				is_true = false;
				break;
			}
		}
		System.out.println(is_true);
	}
}
