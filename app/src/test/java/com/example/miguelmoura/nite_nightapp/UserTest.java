package lpoo1718_t6g5.nite;

import com.example.miguelmoura.nite_nightapp.Model.User;

import org.junit.Test;

import static org.junit.Assert.*;


public class UserTest {

    @Test
    public void test_formatEmail(){
        User user = new User("email@gmail.com");
        user.formatEmail();
        assertEquals("email@gmail" + user.getDOT_SUBSTITUTE_STRING() +"com",user.getEmail());
    }

    @Test
    public void test_unformatEmail(){
        User user = new User();
        user = new User("email@gmail" + user.getDOT_SUBSTITUTE_STRING() +"com");
        user.unformatEmail();
        assertEquals("email@gmail.com",user.getEmail());
    }

    @Test
    public void test_WrongSize_emailTooShort(){
        User user = new User("short");
        String answer = user.isValid();
        assertEquals("Email too short",answer);
    }

    @Test
    public void test_WrongSize_emailTooLong(){
        User user = new User("toolongtoolongtoolongtoolongtoollongtoolongtoolonlongtoolongtoolonlongtoolongtoolonlongtoolongtoolonongtoolongtoolong");
        String answer = user.isValid();
        assertEquals("Email too long",answer);
    }

    @Test
    public void test_RightSize_noAt(){
        User user = new User("oolongtoongtool.ong");
        String answer = user.isValid();
        assertEquals("Email missing \"@\"",answer);
    }

    @Test
    public void test_RightSize_noDot(){
        User user = new User("oolongtoongtool@ong");
        String answer = user.isValid();
        assertEquals("Email missing \".\"",answer);
    }

    @Test
    public void test_RightSize_RightElements_wrongOrder(){
        User user = new User("oolongtoong.tool@ong");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("Email \"@\" must be before \".\"",answer);
    }

    @Test
    public void test_validEmail(){
        User user = new User("oolongtoong@ool.ong");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("Phone number must be a number",answer);
    }

    @Test
    public void test_PhoneNumber_tooShort(){
        User user = new User("user","oolongtoong@ool.ong","123","2000","passwords");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("Phone number must be greater than 900000000",answer);
    }

    @Test
    public void test_PhoneNumber_tooLong(){
        User user = new User("user","oolongtoong@ool.ong","990000001","20003452","passwords");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("Phone number must be less than 990000000",answer);
    }

    @Test
    public void test_birth_notANumber(){
        User user = new User("user","oolongtoong@ool.ong","970000001","ola","passwords");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("Birth year must be a number",answer);
    }

    @Test
    public void test_birth_TooLow(){
        User user = new User("user","oolongtoong@ool.ong","970000001","1000","passwords");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("Birth Date must be greater than 1990",answer);
    }

    @Test
    public void test_birth_TooHigh(){
        User user = new User("user","oolongtoong@ool.ong","970000001","3000","passwords");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("Birth Date must be less than 2001",answer);
    }

    @Test
    public void test_Password_tooShort(){
        User user = new User("user","oolongtoong@ool.ong","970000001","2000","asda");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("Password too short",answer);
    }

    @Test
    public void test_Password_tooLong(){
        User user = new User("user","oolongtoong@ool.ong","970000001","2000","aserwerewrwerwerwerwerwerwerwerwerda");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("Password too long",answer);
    }

    @Test
    public void test_UserValid(){
        User user = new User("user","oolongtoong@ool.ong","970000001","2000","aserwerewrwerwa");
        user.formatEmail();
        String answer = user.isValid();
        assertEquals("validUser",answer);
    }
}