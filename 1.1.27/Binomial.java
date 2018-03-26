/*

需求：二项分布(概率论与数理统计，这个不太懂)。估计binomial(100, 50, 0.25)将会产生的递归调用次数。
	  试验了一下，题目代码非常慢，直接ctrl-c了。

思路：观察题目的代码，可以发现此算法的递归调用次数过多，并且有大量的重复计算。
	  可以考虑重用计算过的值。利用动态规划的思想。

结果：动态规划确实可以解决此类问题，结果秒出。

*/

public class Binomial
{
	public static double binomial1(int N, int k, double p)
	{
		if (N == 0 && k == 0) return 1.0;
		if (N < 0 || k < 0) return 0.0;
		return (1.0-p)*binomial1(N-1, k, p) + p*binomial1(N-1, k-1, p);
	}

	public static double binomial2(int N, int k, double p)
	{
		double[][] dp = new double[N+1][k+1];

		for (int i = 0; i <= N; i++)
			dp[i][0] = Math.pow(1.0 - p, i);
		dp[0][0] = 1.0;

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= k; j++)
				dp[i][j] = (1.0-p) * dp[i-1][j] + p * dp[i-1][j-1];

		return dp[N][k];
	}

	public static void main(String[] args)
	{
		int N = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		double p = Double.parseDouble(args[2]);
		// System.out.println(binomial1(N, k, p));
		System.out.println(binomial2(N, k, p));
	}
}
