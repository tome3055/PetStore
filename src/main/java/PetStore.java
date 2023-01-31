import java.util.Date;

public class PetStore {
    private User[] users = new User[10];
    private int numberofusers;
    private Pet[] pets = new Pet[20];
    private int numberofpets;
    private History history;
    public PetStore()
    {
        numberofpets = 0;
        numberofusers = 0;
        for(int i = 0; i < users.length; i++)
        {
            users[i] = new User();
        }
        for(int i = 0; i < pets.length; i++)
        {
            pets[i] = new Pet();
        }
        history = new History();
    }

    public boolean addPet(Pet pet)
    {
        if(numberofpets > 19)
        {
            return false;
        }
        if(!pets[numberofpets].getExists())
        {
            pets[numberofpets] = pet;
            System.out.println(pets[numberofpets].toString() + " is now added to the PetStore");
            numberofpets += 1;
            return true;
        }
        return false;
    }

    public boolean addUser(User user)
    {
        if(numberofusers > 9)
        {
            return false;
        }
        if(!users[numberofusers].getExists())
        {
            users[numberofusers] = user;
            System.out.println(users[numberofusers].toString() + " is now added to the PetStore");
            numberofusers += 1;
            return true;
        }
        return false;
    }

    public void listUsers()
    {
        for (int i = 0; i < numberofusers; i++) {
            System.out.println(Integer.toString(i + 1) + ". " + users[i].toString());
        }
    }
    public void listPets()
    {
        for (int i = 0; i < numberofpets; i++) {
            System.out.println(Integer.toString(i + 1) + ". " + pets[i].toString());
        }
    }

    public boolean buypet(int usernumber, int petnumber)
    {
        if(usernumber > 10 || petnumber > 20)
        {
            return false;
        }
        if(users[usernumber - 1].getExists() && pets[petnumber - 1].getExists()) //if pet and user exists
        {
            if(!pets[petnumber - 1].getOwner().getExists()) { //if pet doesn't have an owner
                if (users[usernumber - 1].getBudget().ispossibletosubtract(pets[petnumber - 1].getPrice())) {//if owner can afford pet
                    // generate user, pet and money to save in historylog
                    Money historybudget = new Money(users[usernumber - 1].getBudget().getAmount());
                    User historyuser = new User(users[usernumber - 1].getFirstname(), users[usernumber - 1].getLastname(), users[usernumber - 1].getEmail(), historybudget);
                    Pet historypet = new Pet(pets[petnumber - 1].getName(), pets[petnumber - 1].getType(), pets[petnumber - 1].getDescription(), pets[petnumber - 1].getDateofbirth());
                    Date date = new Date(System.currentTimeMillis());
                    HistoryLog log = new HistoryLog(date, historyuser, historypet, true);
                    history.addLog(log);


                    pets[petnumber - 1].setOwner(users[usernumber - 1]);//set pet's owner
                    users[usernumber - 1].getBudget().subtract(pets[petnumber - 1].getPrice());//subtract the money from user's budget
                    return true;
                }
                else {
                    //if user doesn't have enough money
                    Date date = new Date(System.currentTimeMillis());
                    HistoryLog log = new HistoryLog(date, users[usernumber - 1], pets[petnumber - 1], false);
                    history.addLog(log);
                    return false;
                }
            }
            else
            {
                //if pet already has an owner
                Date date = new Date(System.currentTimeMillis());
                HistoryLog log = new HistoryLog(date, users[usernumber - 1], pets[petnumber - 1], false);
                history.addLog(log);

                return false;
            }
        }
        else
        {
            //user or pet doesn't exist in petstore
            return false;
        }
    }
    private void sortUsersbybudget()
    {
        for(int i = 0; i < numberofusers; i++)
        {
            for (int j = i + 1; j < numberofusers; j++)
            {
                float ibudget = users[i].getBudget().getAmount();
                float jbudget = users[j].getBudget().getAmount();
                if(ibudget > jbudget)
                {
                    User tmp = users[i];
                    users[i] = users[j];
                    users[j] = tmp;
                }
            }
        }
    }

    private void sortPetsbyprice()
    {
        for(int i = 0; i < numberofpets; i++)
        {
            for (int j = i + 1; j < numberofpets; j++)
            {
                float iprice = pets[i].getPrice().getAmount();
                float jprice = pets[j].getPrice().getAmount();
                if(iprice > jprice)
                {
                    Pet tmp = pets[i];
                    pets[i] = pets[j];
                    pets[j] = tmp;
                }
            }
        }
    }
    public void autoBuy()
    {
        sortUsersbybudget();
        sortPetsbyprice();

        int pet = 0;
        for(int i = 0; i < numberofusers; i++)
        {
            if(pet >= numberofpets)
            {
                break;
            }

            if (buypet(i + 1, pet + 1))
            {
                pet += 1;
            }
        }
    }

    public String  history()
    {
        return history.log();
    }

    public void historydetails()
    {
        System.out.println(history.toString());
    }
}
