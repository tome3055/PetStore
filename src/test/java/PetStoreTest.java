import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PetStoreTest {

    @Test
    void addPet() throws Exception{
        PetStore petstore = new PetStore();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", new Dog(1),"description", date);
        assertEquals(true, petstore.addPet(pet));
    }

    @Test
    void addUser() throws Exception{
        PetStore petstore = new PetStore();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        String firstname = "firstname";
        String lastname = "lastname";
        String email = "email";
        Money money = new Money(100);
        User user = new User(firstname,lastname,email,money);
        assertEquals(true, petstore.addUser(user));
    }

    @Test
    void listUsers() throws Exception{
        PetStore petstore = new PetStore();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        String firstname = "firstname";
        String lastname = "lastname";
        String email = "email";
        Money money = new Money(100);
        User user = new User(firstname,lastname,email,money);
        petstore.addUser(user);
        petstore.listUsers();
    }

    @Test
    void listPets() throws Exception{
        PetStore petstore = new PetStore();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", new Dog(1),"description", date);
        petstore.addPet(pet);
        petstore.listPets();
    }

    @Test
    void buypet() throws Exception{
        PetStore petstore = new PetStore();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", new Dog(1),"description", date);
        String firstname = "firstname";
        String lastname = "lastname";
        String email = "email";
        Money money = new Money(100);
        User user = new User(firstname,lastname,email,money);
        petstore.addPet(pet);
        petstore.addUser(user);
        assertEquals(true, petstore.buypet(1,1));
        assertEquals(false, petstore.buypet(1,1));// buy pet with owner
    }

    @Test
    void autoBuy() throws Exception{
        PetStore petstore = new PetStore();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", new Dog(1),"description", date);
        String firstname = "firstname";
        String lastname = "lastname";
        String email = "email";
        Money money = new Money(100);
        User user = new User(firstname,lastname,email,money);
        petstore.addPet(pet);
        petstore.addUser(user);
        petstore.autoBuy();
    }

    @Test
    void history() throws Exception{
        PetStore petstore = new PetStore();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", new Dog(1),"description", date);
        String firstname = "firstname";
        String lastname = "lastname";
        String email = "email";
        Money money = new Money(100);
        User user = new User(firstname,lastname,email,money);
        petstore.addPet(pet);
        petstore.addUser(user);
        petstore.autoBuy();
        String comparestring = (new Date(System.currentTimeMillis())).toString() + ", 1, 0";
        assertEquals(comparestring, petstore.history());
    }

    @Test
    void historydetails() throws Exception{
        PetStore petstore = new PetStore();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", new Dog(1),"description", date);
        String firstname = "firstname";
        String lastname = "lastname";
        String email = "email";
        Money money = new Money(100);
        User user = new User(firstname,lastname,email,money);
        petstore.addPet(pet);
        petstore.addUser(user);
        petstore.autoBuy();
        petstore.historydetails();
    }
}