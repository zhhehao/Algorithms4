/*
 * 习题: 1.2.13
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



    public static void main(String[] args)
    {
        Transaction t = new Transaction("Jack", new Date(4, 4, 2018), 100.05);
        System.out.println(t);
    }
}
