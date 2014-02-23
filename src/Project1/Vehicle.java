package Project1;

/**
 * @author Mark Judy <mjudy1@umbc.edu>
 * @version 1.0
 *          Date: 2/13/14
 *          Time: 5:34 PM
 */
public class Vehicle
{
    private char type;
    private int timeEntered;

    /**
     * Default constructor for Vehicle class. Initializes type and timeEntered to default values.
     */
    public Vehicle()
    {
        type ='z';
        timeEntered = -1;
    }//end Vehicle()

    /**
     * Constructor that initializes type to newType and timeEntered to time.
     *
     * @param newType - Defines the type of Vehicle to be created.
     * @param time - Defines the time that the Vehicle entered the intersection.
     */
    public Vehicle (char newType, int time)
    {
        type = newType;
        timeEntered = time;
    }//end Vehicle(char, int)

    /**
     * Retrieves the type of Vehicle object this is. 'c' for car, 't' for truck.
     *
     * @return - returns a character representing the vehicle type.
     */
    public char getType()
    {
        return type;
    }//end getType()

    /**
     * Changes the type of Vehicle object this is.
     *
     * @param type - a new type to be specified for this Vehicle.
     */
    public void setType(char type)
    {
        this.type = type;
    }//end setType(char)

    /**
     * Retrieves the time that this Vehicle entered the intersection in the traffic simulation.
     *
     * @return - an integer that specifies the time the Vehicle entered the intersection.
     */
    public int getTimeEntered()
    {
        return timeEntered;
    }//end getTimeEntered()

    /**
     * Changes the time that this Vehicle entered the intersection.
     *
     * @param timeEntered - integer specifying a new entry time for the Vehicle.
     */
    public void setTimeEntered(int timeEntered)
    {
        this.timeEntered = timeEntered;
    }//end setTimeEntered(int)

    /**
     * Prepares the data contained in this Vehicle object for printing by creating a string containing the data.
     *
     * @return - string containing this Vehicle object's data.
     */
    public String toString()
    {
        String str = "Type: " + type + " Time Entered: " + timeEntered;
        return str;
    }//end toString()
}//end Vehicle class
