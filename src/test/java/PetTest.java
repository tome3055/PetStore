import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void age() throws Exception{
        Dog dog = new Dog(1);
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", dog, "description", date);
        assertEquals(0,pet.age());
    }

    @Test
    void getExists() throws Exception{
        Dog dog = new Dog(1);
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet1 = new Pet("name", dog, "description", date);
        Pet pet2 = new Pet();
        assertEquals(true, pet1.getExists());
        assertEquals(false, pet2.getExists());
    }

    @Test
    void getOwner() throws Exception{
        Dog dog = new Dog(1);
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", dog, "description", date);
        String firstname = "firstname";
        String lastname = "lastname";
        String email = "email";
        Money money = new Money(100);
        User user = new User(firstname,lastname,email,money);
        pet.setOwner(user);
        assertEquals(user, pet.getOwner());
    }

    @Test
    void getName() throws Exception{
        Dog dog = new Dog(1);
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", dog, "description", date);
        assertEquals("name", pet.getName());
    }

    @Test
    void getType() throws Exception{
        Cat cat = new Cat();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", cat, "description", date);
        assertEquals(cat, pet.getType());
    }

    @Test
    void getDescription() throws Exception{
        Cat cat = new Cat();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", cat, "description", date);
        assertEquals("description", pet.getDescription());
    }

    @Test
    void getDateofbirth() throws Exception{
        Cat cat = new Cat();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", cat, "description", date);
        assertEquals(date, pet.getDateofbirth());
    }

    @Test
    void getPrice() throws Exception{
        Cat cat = new Cat();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", cat, "description", date);
        Money money = new Money(0);
        assertEquals(money.getAmount(), pet.getPrice().getAmount());
    }

    @Test
    void testToString() throws Exception{
        Cat cat = new Cat();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.05.2022");
        Pet pet = new Pet("name", cat, "description", date);
        Money money = new Money(0);
        String comparestring = "name" + " a " + cat.type + " description: " + "description" + " age:" + "0.0" + " price: " + "0.0$";
        assertEquals(comparestring, pet.toString());
    }
}