public class Date
{
    private final int month;
    private final int day;
    private final int year;

    public Date(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(String date)
    {
        String[] fields = date.split("/");
        this.month = Integer.parseInt(fields[0]);
        this.day = Integer.parseInt(fields[1]);
        this.year = Integer.parseInt(fields[2]);
    }

    public int month()
    {
        return month;
    }

    public int day()
    {
        return day;
    }

    public int year()
    {
        return year;
    }

    public String toString()
    {
        return month() + "/" + day() + "/" + year();
    }
}
