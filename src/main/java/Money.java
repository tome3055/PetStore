public class Money {
    private float amount;
    private String currency;
    private String symbol;
    public Money(float amount, String currency, String symbol)
    {
        this.amount = amount;
        this.currency = currency;
        this.symbol = symbol;
    }

    public Money(float amount)
    {
        this.amount = amount;
        this.currency = "Dollar";
        this.symbol = "$";
    }

    public boolean ispossibletosubtract(Money money) //check if money goes to negative
    {
        if(this.amount - money.amount >= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void subtract(Money money)
    {
        if(ispossibletosubtract(money))
        {
            this.amount -= money.amount;
        }
    }

    public float getAmount()
    {
        return amount;
    }
    public String toString()
    {
        return Float.toString(this.amount) + this.symbol;
    }
}
