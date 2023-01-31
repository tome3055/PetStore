import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void ispossibletosubtract() {
        Money money1 = new Money(10);
        Money money2 = new Money(5);

        assertEquals(false, money2.ispossibletosubtract(money1));
        assertEquals( true, money1.ispossibletosubtract(money2));
    }

    @Test
    void getAmount() {
        Money money = new Money(10);
        assertEquals(10, money.getAmount());
    }

    @Test
    void testToString1() {
        Money money = new Money(10);
        assertEquals("10.0$", money.toString());
    }

    @Test
    void testToString2() {
        Money money = new Money(10, "Euro", "€");
        assertEquals("10.0€", money.toString());
    }
}