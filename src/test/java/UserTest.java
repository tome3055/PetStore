import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test1() //test empty user
    {
        User user = new User();
        assertEquals(false ,user.getExists());
        assertEquals("", user.toString());
        assertEquals("", user.getFirstname());
        assertEquals("", user.getLastname());
        assertEquals("", user.getEmail());
        assertEquals(null, user.getBudget());
    }

    @Test
    void test2() //test declaring user
    {
        String firstname = "firstname";
        String lastname = "lastname";
        String email = "email";
        Money money = new Money(100);
        User user = new User(firstname,lastname,email,money);
        assertEquals(true ,user.getExists());
        assertEquals(firstname + " " + lastname + " email:" + email  + " budget: " + money.toString(), user.toString());
        assertEquals(firstname, user.getFirstname());
        assertEquals(lastname, user.getLastname());
        assertEquals(email, user.getEmail());
        assertEquals(money, user.getBudget());
    }
}