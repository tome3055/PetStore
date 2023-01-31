import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Welcome to PetStore Manager\n" +
                    "To add a user please type \"adduser\" or user: TestFirstName, TestLastName, test@email.com, 5;\n" +
                    "To add a pet please type \"addpet\" or pet: DogName, dog, Labrador Retriever, 01.05.2017, 3;\n" +
                    "To buy a pet type \"buy\"\n" +
                    "To list users type \"listusers\"\n"+
                    "To list pets type \"listpets\"\n" +
                    "To automatically buy pets type \"autobuy\"\n" +
                    "To view history type \"history\"\n" +
                    "To view details history type \"historydetails\"\n");
            PetStore petStore = new PetStore();
            while (true){
            String stmp = in.nextLine();
            if(stmp.equals("exit"))
            {
                break;
            }
            String command;
            if(stmp.contains(";"))
            {
                command = stmp.substring(0, stmp.indexOf(":"));
                String[] details = stmp.substring(stmp.indexOf(":") + 1, stmp.indexOf(";")).split(",");
                if (command.equals("user")) {
                    if(details.length != 4)
                    {
                        continue;
                    }
                    String firstname = details[0];
                    String lastname = details[1];
                    String email = details[2];
                    Money budget = new Money(Float.parseFloat(details[3]));
                    if(budget.getAmount() > 0)
                    {
                        User newuser = new User(firstname, lastname, email, budget);
                        petStore.addUser(newuser);
                    }
                } else if (command.equals("pet")) {
                    String description = "";
                    Date dateofbirth = null;
                    Species type = new Species();
                    if (details[1].equals(" cat")) {
                        if(details.length != 4)
                        {
                            continue;
                        }
                        type = new Cat();
                        description = details[2];
                        dateofbirth = new SimpleDateFormat("dd.MM.yyyy").parse(details[3]);
                    } else if (details[1].equals(" dog")) {
                        if(details.length != 5)
                        {
                            continue;
                        }
                        System.out.println("Rating:");
                        type = new Dog(Float.parseFloat(details[4]));
                        description = details[2];
                        dateofbirth = new SimpleDateFormat("dd.MM.yyyy").parse(details[3]);
                    }
                    else
                    {
                        continue;
                    }
                    String name = details[0];
                    Pet newpet = new Pet(name, type, description, dateofbirth);
                    petStore.addPet(newpet);
                }
            }
            else
            {
                command = stmp;
                switch (command) {
                    case "adduser" -> {
                        System.out.println("Firstname:");
                        String firstname = in.nextLine();
                        System.out.println("Lastname:");
                        String lastname = in.nextLine();
                        System.out.println("Email:");
                        String email = in.nextLine();
                        System.out.println("Budget:");
                        Money budget = new Money(Float.parseFloat(in.nextLine()));
                        if(budget.getAmount() > 0)
                        {
                            User newuser = new User(firstname, lastname, email, budget);
                            petStore.addUser(newuser);
                        }

                    }
                    case "addpet" -> {
                        System.out.println("Name:");
                        String name = in.nextLine();
                        System.out.println("Species (cat or dog):");
                        Species species = new Species();
                        String type = in.nextLine();
                        if (type.equals("cat")) {
                            species = new Cat();
                        } else if (type.equals("dog")) {
                            System.out.println("Rating:");
                            species = new Dog(Float.parseFloat(in.nextLine()));
                        }
                        System.out.println("Description:");
                        String description = in.nextLine();
                        System.out.println("Date of birth in the following format dd.MM.yyyy:");
                        Date dateofbirth = new SimpleDateFormat("dd.MM.yyyy").parse(in.nextLine());
                        Pet newpet = new Pet(name, species, description, dateofbirth);
                        petStore.addPet(newpet);
                    }
                    case "listusers" ->  {petStore.listUsers();}
                    case "listpets" -> {petStore.listPets();}
                    case "buy" -> {
                        System.out.println("Select a user by selecting the number assosiated with the user");
                        petStore.listUsers();
                        int user = Integer.parseInt(in.nextLine());
                        System.out.println("Select a pet by selecting the number assosiated with the pet");
                        petStore.listPets();
                        int pet = Integer.parseInt(in.nextLine());
                        if(petStore.buypet(user, pet))
                        {
                            System.out.println("Buying a pet was not successful");
                        }
                    }
                    case "autobuy" -> {petStore.autoBuy();}
                    case "history" -> {System.out.println(petStore.history());}
                    case "historydetails" -> {petStore.historydetails();}
                }
            }

            }
        }
    }
}