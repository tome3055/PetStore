import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Pet {
    private User owner;
    private String name;
    private Species type;
    private String description;
    private java.util.Date dateofbirth;
    private Money price;
    private boolean exists;
    public Pet()
    {
        exists = false;
    }
    public Pet(String name, Species type, String description, java.util.Date dateofbirth)
    {
        this.owner = new User();
        this.name = name;
        this.description = description;
        this.dateofbirth = dateofbirth;
        this.type = type;
        exists = true;
        if(type.type.equals("Dog"))
        {
            price = new Money(age() + type.rating);
        }
        else if(type.type.equals("Cat"))
        {
            price = new Money(age());
        }
    }

    public int age()
    {
        if(!exists)
            return 0;

        long difference_In_Time = (new Date(System.currentTimeMillis()).getTime() - dateofbirth.getTime());
        float years = difference_In_Time / (1000l * 60 * 60 * 24 * 365);
        return (int)years;
    }

    public boolean setOwner(User owner)
    {
        if(!exists)
            return false;
        if(!this.owner.getExists())
        {
            this.owner = owner;
            message();
            return true;
        }
        else
        {
            System.out.println(toString() + " already has an owner.");
            return true;
        }
    }

    public boolean getExists()
    {
        return exists;
    }

    public User getOwner()
    {
        if(!exists)
            return null;
        return owner;
    }

    public String getName()
    {
        if(!exists)
            return "";
        return name;
    }

    public Species getType()
    {
        if(!exists)
            return null;
        return type;
    }
    public String getDescription()
    {
        if(!exists)
            return "";
        return description;
    }
    public Date getDateofbirth()
    {
        if(!exists)
            return null;
        return dateofbirth;
    }
    public Money getPrice()
    {
        if(!exists)
            return null;
        return price;
    }
    public void printPet()
    {
        if(!exists)
            return;
        System.out.println(toString() + "\n");
    }

    public String toString()
    {
        if(!exists)
            return "";
        return name + " a " + type.type + " description: " + description + " age:" + Float.toString(age()) + " price: " + price.toString();
    }

    public void message()
    {
        if(!exists)
            return;
        type.message(name, owner);
    }
}
