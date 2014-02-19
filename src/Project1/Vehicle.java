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

    public Vehicle()
    {
        type ='z';
        timeEntered = -1;
    }

    public Vehicle (char newType, int time)
    {
        type = newType;
        timeEntered = time;
    }

    public char getType()
    {
        return type;
    }

    public void setType(char type)
    {
        this.type = type;
    }

    public int getTimeEntered()
    {
        return timeEntered;
    }

    public void setTimeEntered(int timeEntered)
    {
        this.timeEntered = timeEntered;
    }

    public String toString()
    {
        String str = "Type: " + type + " Time: " + timeEntered;
        return str;
    }
}
