/*
 * 习题: 1.2.14
 */

public class Transaction
{

    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount)
    {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String who()
    {
        return who;
    }

    public Date when()
    {
        return when;
    }

    public double amount()
    {
        return amount;
    }

    public String toString()
    {
        return who() + " 于 " + when() + " 交易 " + amount() + ".";
    }

    public boolean equals(Object x)
    {
        if (this == x)
            return true;
        if (x == null)
            return false;
        if (this.getClass() != x.getClass())
            return false;
        Transaction that = (Transaction)x;
        if (!this.who.equals(that.who))
            return false;
        if (!this.when.equals(that.when))
            return false;
        if (Math.abs(this.amount - that.amount) > 1E-6)
            return false;
        return true;
    }

    public static void main(String[] args)
    {
        // Transaction t = new Transaction("Jack", new Date(4, 4, 2018), 100.05);
        // System.out.println(t);

        Transaction t1 = new Transaction("Jack", new Date(4, 4, 2018), 100.05);
        Transaction t2 = t1;
        System.out.println(t1.equals(t2));

        Transaction t3 = new Transaction("Jack", new Date(4, 4, 2018), 100.05);
        System.out.println(t1.equals(t3));

        Transaction t4 = new Transaction("Jack", new Date(4, 1, 2018), 100.05);
        System.out.println(t1.equals(t4));

        System.out.println(t1.equals(null));
    }
}
