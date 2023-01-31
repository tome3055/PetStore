public class User {
    private String firstname;
    private String lastname;
    private String email;
    private Money budget;
    private boolean exists;
    public User()
    {
        firstname = "";
        lastname = "";
        email = "";
        budget = null;
        exists = false;
    }
    public User(String firstname, String lastname, String email, Money budget)
    {
        exists = true;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.budget = budget;
    }
    public String getFirstname()
    {
        return firstname;
    }
    public String getLastname()
    {
        return lastname;
    }
    public String getEmail()
    {
        return email;
    }
    public Money getBudget()
    {
        return budget;
    }
    public boolean getExists()
    {
        return exists;
    }
    public String toString()
    {
        if(this.exists)
            return firstname + " " + lastname + " email:" + email  + " budget: " + budget.toString();
        else
            return "";
    }
}
