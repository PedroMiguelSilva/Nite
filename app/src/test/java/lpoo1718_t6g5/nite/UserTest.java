package lpoo1718_t6g5.nite;

import org.junit.Test;

import static org.junit.Assert.*;


public class UserTest {

    @Test
    public void CheckIfStaticIdForUser_isCorrect(){
        User usr1 = new User("Pedro","myemail@gmail.com");
        User usr2 = new User("Miguel","myemail@gmail.com");
        assertEquals((Integer)0,usr1.getId());
        assertEquals((Integer)1,usr2.getId());
    }
}