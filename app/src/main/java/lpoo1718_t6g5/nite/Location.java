package lpoo1718_t6g5.nite;

/**
 * Represents a location in the globe
 * Described with coordinates and also associated with a State and City
 * @version 1.0
 * @since 1.0
 * @author PedroMiguelSilva
 */
public class Location {

    /**
     * Longitude of Location
     * Based on the Prime Meridian
     * Positive values for Eastern half and Negative values for Western half
     */
    private double latitude;

    /**
     * Latitude of Location
     * Based on the Equator
     * Positive values for Northern hemisphere and Negative for Southern hemisphere
     */
    private double longitude;

    /**
     * Name of the State where Location is
     */
    private String state;

    /**
     * Name of the City where Location is
     */
    private String city;

    /**
     * Creates a Location with given latitude and longitude
     * @param latitude
     *              Latitude of Location
     * @param longitude
     *              Longitude of Location
     */
    public Location(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = "";
        this.city = "";
    }

}
