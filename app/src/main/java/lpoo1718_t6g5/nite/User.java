package lpoo1718_t6g5.nite;

/**
 * Represents a User of the App
 * It can be used for the current user or for communication purposes
 * @version 1.0
 * @since 1.0
 * @author PedroMiguelSilva
 */
public class User {

    /**
     * Identifier for each User (must be unique for each User)
     */
    private static Integer currentID = 0;

    /**
     * Unique identifier of the User
     */
    private final Integer id;

    /**
     * Name of the User
     */
    private String name;

    /**
     * Email of the User
     */
    private String email;

    /**
     * Constructs an User with given name and email
     * @param name
     *              Name of the User
     * @param email
     *              Email of the User
     */
    public User(String name, String email){
        this.id = currentID;
        currentID++;
        this.name = name;
        this.email = email;
    }

    /**
     * Returns the id of the User
     * @return id of the User
     */
    public Integer getId(){
        return this.id;
    }
}
