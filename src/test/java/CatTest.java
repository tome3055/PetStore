import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void test1() //test cat message
    {
        Cat cat = new Cat();
        String name = "name";
        User user = new User("firstname", "lastname", "email", new Money(10));
        String teststring = "Meow, cat " + name + " has owner " + user.getFirstname() + " " + user.getLastname();
        assertEquals(teststring, cat.speak(name, user));
    }
}