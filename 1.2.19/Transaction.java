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

    public Transaction(String transaction)
    {
        String fields[] = transaction.split(" ");
        this.who = fields[0];
        this.when = new Date(fields[1]);
        this.amount = Double.parseDouble(fields[2]);
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
        Transaction t = new Transaction("Turing 5/22/1939 11.99");
        System.out.println(t);
    }
}
