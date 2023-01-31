import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void test1() //test dog message
    {
        float rating = 1;
        Dog dog = new Dog(rating);
        String name = "name";
        User user = new User("firstname", "lastname", "email", new Money(10));
        String teststring = "Woof, dog " + name + " has owner " + user.getFirstname() + " " + user.getLastname();
        assertEquals(teststring, dog.speak(name, user));
    }
}