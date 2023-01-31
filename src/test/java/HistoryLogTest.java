import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HistoryLogTest {

    @Test
    void test1() //test status
    {
        Date date = new Date(System.currentTimeMillis());
        User user = new User("firstname", "lastname", "email", new Money(10));
        Dog dog = new Dog(1);
        Pet pet = new Pet("name", dog, "description", date);

        HistoryLog log = new HistoryLog(date, user, pet, false);
        assertEquals(false, log.getStatus());
    }

    @Test
    void test2() //test successful bought pet
    {
        Date date = new Date(System.currentTimeMillis());
        User user = new User("firstname", "lastname", "email", new Money(10));
        Dog dog = new Dog(1);
        Pet pet = new Pet("name", dog, "description", date);

        HistoryLog log = new HistoryLog(date, user, pet, true);
        assertEquals(date.toString() + ", \"" + user.toString() + "\", \"" + pet.toString() + "\", " + "successful", log.toString());
    }
    @Test
    void test3() throws Exception {//test unsuccessful bought pet
        {
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse("05.01.2022");
            User user = new User("firstname", "lastname", "email", new Money(10));
            Dog dog = new Dog(1);
            Pet pet = new Pet("name", dog, "description", date);

            HistoryLog log = new HistoryLog(date, user, pet, false);
            assertEquals(date.toString() + ", \"" + user.toString() + "\", \"" + pet.toString() + "\", " + "unsuccessful", log.toString());
        }
    }
}