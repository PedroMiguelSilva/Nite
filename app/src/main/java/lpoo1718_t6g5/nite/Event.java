package lpoo1718_t6g5.nite;

import java.util.Date;

/**
 * Represents an Event
 * @version 1.0
 * @since 1.0
 * @author PedroMiguelSilva
 */
public class Event {

    /**
     * Identifier for each Event (must be unique for each Event
     */
    private static Integer currentID = 0;

    /**
     * Unique identifier of the Event
     */
    private final Integer id;

    /**
     * Date of the Event
     */
    private Date date;

    /**
     * Place where the Event will take place
     */
    private Club club;

    /**
     * Brief description of the Event
     */
    private String description;

    /**
     * Creates an Event in the given Date in the given Club
     * @param date
     *          Date when the Event will take place
     * @param club
     *          Club where the Event will take place
     */
    public Event(Date date, Club club){
        this.id = currentID;
        currentID++;
        this.date = date;
        this.club = club;
        this.description = "";
    }

    /**
     * Returns the unique id of the Event
     * @return unique id of the Event
     */
    public Integer getId(){
        return this.id;
    }
}
