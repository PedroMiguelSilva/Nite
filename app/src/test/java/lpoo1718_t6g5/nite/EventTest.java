package lpoo1718_t6g5.nite;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void CheckIfStaticIdForEvent_isCorrect(){
        Location loc = new Location(0,0);
        Club club1 = new Club(loc,"Night Club");
        Event event1 = new Event(new Date(),club1);
        Event event2 = new Event(new Date(),club1);
        assertEquals((Integer)0,event1.getId());
        assertEquals((Integer)1,event2.getId());
    }
}