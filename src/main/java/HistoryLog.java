import java.util.Date;

public class HistoryLog {
    private Date dateofexecution;
    private User user; //stored user info when buying the pet
    private Pet pet; //stored pet info when buying the pet
    private boolean status;

    public HistoryLog(Date date, User user, Pet pet, boolean status)
    {
        this.dateofexecution = date;
        this.user = user;
        this.pet = pet;
        this.status = status;
    }
    public boolean getStatus()
    {
        return this.status;
    }
    public String toString()
    {
        String returnstring = dateofexecution.toString() + ", \"" + user.toString() + "\", \"" + pet.toString() + "\", ";
        if(status)
        {
            returnstring += "successful";
        }
        else
        {
            returnstring += "unsuccessful";
        }
        return returnstring;
    }
}
