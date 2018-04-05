/*
 * 习题 1.2.16
 */

public class Rational
{
	private final int numerator;
	private final int denominator;

	public Rational(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Rational plus(Rational that)
	{
		long d = (long)this.denominator * (long)that.denominator;
		long n = (long)this.numerator * (long)that.denominator +
				 (long)that.numerator * (long)this.denominator;
		return factors((int)n, (int)d);
	}

	public Rational minus(Rational that)
	{
		long d = (long)this.denominator * (long)that.denominator;
		long n = (long)this.numerator * (long)that.denominator -
				 (long)that.numerator * (long)this.denominator;
		return factors((int)n, (int)d);
	}

	public Rational times(Rational that)
	{
		long d = (long)this.denominator * (long)that.denominator;
		long n = (long)this.numerator * (long)that.numerator;
		return factors((int)n, (int)d);
	}

	public Rational divides(Rational that)
	{
		long d = (long)this.denominator * (long)that.numerator;
		long n = (long)this.numerator * (long)that.denominator;
		return factors((int)n, (int)d);
	}

	public boolean equals(Object x)
	{
		if (this == x)
			return true;
		if (x == null)
			return false;
		if (this.getClass() != x.getClass())
			return false;
		Rational that = (Rational) x;
		if (this.numerator != that.numerator || this.denominator != that.denominator)
			return false;
		return true;
	}

	public String toString()
	{
		if (numerator == 0 || denominator == 1)
			return "This rational number is " + numerator; // 处理分子为0或分母为1的情况
		if (denominator < 0) // 处理分母为负数的情况
			return "This rational number is -" + numerator + "/" + denominator * -1;
		return "This rational number is " + numerator + "/" + denominator;
	}

	private Rational factors(int numerator, int denominator)
	{
		if (numerator == 0) // 如果分子为0，直接返回
			return new Rational(numerator, denominator);

		int flag = 0; // 如果分子比分母小，为了下面的 gcd算法，交换分子、分母
		if (numerator < denominator) {
			int t = numerator;
			numerator = denominator;
			denominator = t;
			flag = 1;
		}

		int f = gcd(numerator, denominator);
		while (f != 1) {
			numerator /= f;
			denominator /= f;
			f = gcd(numerator, denominator);
		}

		if (flag == 0)
			return new Rational(numerator, denominator);
		return new Rational(denominator, numerator);
	}

	private int gcd(int a, int b) // 辗转相除法
	{
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	public static void main(String[] args)
	{
		int numerator_a = Integer.parseInt(args[0]);
		int denominator_a = Integer.parseInt(args[1]);
		int numerator_b = Integer.parseInt(args[2]);
		int denominator_b = Integer.parseInt(args[3]);
		Rational a = new Rational(numerator_a, denominator_a);
		Rational b = new Rational(numerator_b, denominator_b);
		Rational c = new Rational(numerator_a, denominator_a);

		System.out.println(a.plus(b));
		System.out.println(a.minus(b));
		System.out.println(a.times(b));
		System.out.println(a.divides(b));
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
	}
}
