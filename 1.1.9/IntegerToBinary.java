/*
* 将一个正整数N用二进制表示并转换为一个String类型的值s
*/
public class IntegerToBinary
{
	public static void main(String[] args)
	{
		System.out.println(toBinStr(32));
		System.out.println(toBinStr(15));
		System.out.println(toBinStr(3221321));
		System.out.println(toBinStr(-3221321));
	}

	public static String toBinStr(int N)
	{
		int[] a = new int[32];
		int pos = 31;
		String s = "";
		while (N != 0)
		{
			a[pos--] = N & 1; // 取最后一位
			N = N >>> 1; // 右移一位
		}
		for (int i = pos+1; i < 32; i++)
			s += a[i];
		return s;
	}
}
