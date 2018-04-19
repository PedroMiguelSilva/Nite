package lpoo1718_t6g5.nite;

import java.util.ArrayList;

/**
 * Represents a Club where Events can take place
 * @version 1.0
 * @since 1.0
 * @author PedroMiguelSilva
 */
public class Club {

    /**
     * Location of the Club
     */
    private Location location;

    /**
     * Name of the Club
     */
    private String name;

    /**
     * Array of the events that will take place in this Club
     */
    private ArrayList<Event> futureEvents;

    /**
     * Creates a Club with given location and name
     * @param location
     *              Location of the Club
     * @param name
     *              Name of the Club
     */
    public Club(Location location, String name) {
        this.location = location;
        this.name = name;
        futureEvents = new ArrayList<>();
    }
}
