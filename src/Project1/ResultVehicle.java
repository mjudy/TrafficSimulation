package Project1;

/**
 * @author Mark Judy <mjudy1@umbc.edu>
 * @version 1.0
 *          Date: 2/19/14
 *          Time: 9:40 PM
 */
public class ResultVehicle
{
    private char type;
    private int timeEntered, timeExited;

    /**
     * Default constructor for ResultVehicle class. Initializes type and timeEntered to default values.
     */
    public ResultVehicle()
    {
        type ='z';
        timeEntered = -1;
        timeExited = -1;
    }//end ResultVehicle()

    /**
     * Constructor that initializes type to newType and timeEntered to time.
     *
     * @param newType - Defines the type of ResultVehicle to be created.
     * @param time - Defines the time that the ResultVehicle entered the intersection.
     * @param exit - Defines the time that the ResultVehicle exited the intersection.
     */
    public ResultVehicle (char newType, int time, int exit)
    {
        type = newType;
        timeEntered = time;
        timeExited = exit;
    }//end ResultVehicle (char, int, int)

    /**
     * Retrieves the type of ResultVehicle object this is. 'c' for car, 't' for truck.
     *
     * @return - returns a character representing the ResultVehicle type.
     */
    public char getType()
    {
        return type;
    }//end getType()

    /**
     * Changes the type of ResultVehicle object this is.
     *
     * @param type - a new type to be specified for this ResultVehicle.
     */
    public void setType(char type)
    {
        this.type = type;
    }//end getType(char)

    /**
     * Retrieves the time that this ResultVehicle entered the intersection in the traffic simulation.
     *
     * @return - an integer that specifies the time the ResultVehicle entered the intersection.
     */
    public int getTimeEntered()
    {
        return timeEntered;
    }//end GetTimeEntered()

    /**
     * Changes the time that this ResultVehicle entered the intersection.
     *
     * @param timeEntered - integer specifying a new entry time for the ResultVehicle.
     */
    public void setTimeEntered(int timeEntered)
    {
        this.timeEntered = timeEntered;
    }//end setTimeEntered(int)

    /**
     * Returns the time this ResultVehicle exited the intersection.
     *
     * @return - an integer that specifies at what second this vehicle exited the intersection.
     */
    public int getTimeExited()
    {
        return timeExited;
    }//end getTimeExited()

    /**
     * Sets the time that this ResultVehicle exited the intersection.
     *
     * @param timeExited - new time to specify when this Result Vehicle exited the intersection.
     */
    public void setTimeExited(int timeExited)
    {
        this.timeExited = timeExited;
    }//end setTimeExited(int)

    /**
     * Prepares the data contained in this ResultVehicle object for printing by creating a string containing the data.
     *
     * @return - string containing this ResultVehicle object's data.
     */
    public String toString()
    {
        String str = "Type: " + type + " Time Entered: " + timeEntered + " Time Exited: " + timeExited;
        return str;
    }//end toString()
}//end ResultVehicle class
