import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    Date date = new Date(System.currentTimeMillis());
    User user = new User("firstname", "lastname", "email", new Money(10));
    Dog dog = new Dog(1);
    Pet pet = new Pet("name", dog, "description", date);
    @Test
    void test1() //test log allowed and not allowed = 1
    {
        History history = new History();
        HistoryLog log1 = new HistoryLog(date, user, pet, true);
        HistoryLog log2 = new HistoryLog(date, user, pet, false);

        history.addLog(log1);
        history.addLog(log2);
        String comparestring = (new Date(System.currentTimeMillis())).toString() + ", 1, 1";

        assertEquals(comparestring, history.log());
    }
    @Test
    void test2() //test log allowed 1 notallowed 0
    {
        History history = new History();
        HistoryLog log1 = new HistoryLog(date, user, pet, true);

        history.addLog(log1);
        String comparestring = (new Date(System.currentTimeMillis())).toString() + ", 1, 0";

        assertEquals(comparestring, history.log());
    }
    @Test
    void test3() //test log allowed 0 notallowed 1
    {
        History history = new History();
        HistoryLog log1 = new HistoryLog(date, user, pet, false);

        history.addLog(log1);
        String comparestring = (new Date(System.currentTimeMillis())).toString() + ", 0, 1";

        assertEquals(comparestring, history.log());
    }

    @Test
    void test4() //test toString()
    {
        History history = new History();
        HistoryLog log1 = new HistoryLog(date, user, pet, true);
        HistoryLog log2 = new HistoryLog(date, user, pet, false);

        history.addLog(log1);
        history.addLog(log2);

        String comparestring = log1.toString() + "\n" + log2.toString() + "\n";

        assertEquals(comparestring, history.toString());
    }

    @Test
    void test5() //test more than 10 logs
    {
        History history = new History();

        for(int i = 0; i < 15; i++)
        {
            boolean flag = false;
            if(i % 2 == 0)
            {
                flag = true;
            }
            HistoryLog log = new HistoryLog(date, user, pet, flag);
            history.addLog(log);

        }
    }

}