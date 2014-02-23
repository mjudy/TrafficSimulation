package Project1;

/**
 * @author Mark Judy <mjudy1@umbc.edu>
 * @version 1.0
 *          Date: 2/13/14
 *          Time: 5:28 PM
 */
public class IntersectionFlowRate
{
    private int eastFlowRateCars, westFlowRateCars,
            northFlowRateCars, southFlowRateCars,
            eastFlowRateTrucks, westFlowRateTrucks,
            northFlowRateTrucks, southFlowRateTrucks;

    /**
     * Default constructor for IntersectionFlowRate. Initializes the flow rates for cars and trucks in each direction to 0.
     */
    public IntersectionFlowRate()
    {
        eastFlowRateCars = 0;
        westFlowRateCars = 0;
        northFlowRateCars = 0;
        southFlowRateCars = 0;
        eastFlowRateTrucks = 0;
        westFlowRateTrucks = 0;
        northFlowRateTrucks = 0;
        southFlowRateTrucks = 0;
    }//end IntersectionFlowRate

    /**
     * Returns the flow rate of cars travelling east.
     *
     * @return - number of seconds between each car
     */
    public int getEastFlowRateCars()
    {
        return eastFlowRateCars;
    }//end getEastFlowRateCars

    /**
     * Sets the flow rate for cars travelling east.
     *
     * @param eastFlowRateCars - new rate of cars per minute
     */
    public void setEastFlowRateCars(int eastFlowRateCars)
    {
        this.eastFlowRateCars = 60 / eastFlowRateCars;
    }//end setEastFlowRateCars(int)

    /**
     * Returns the flow rate of cars travelling west.
     *
     * @return - number of seconds between each car
     */
    public int getWestFlowRateCars()
    {
        return westFlowRateCars;
    }//end getWestFlowRateCars()

    /**
     * Sets the flow rate for cars travelling west.
     *
     * @param westFlowRateCars - new rate of cars per minute.
     */
    public void setWestFlowRateCars(int westFlowRateCars)
    {
        this.westFlowRateCars = 60 / westFlowRateCars;
    }//end setWestFlowRateCars(int)

    /**
     * Returns the flow rate of cars travelling north
     *
     * @return - number of seconds between each car
     */
    public int getNorthFlowRateCars()
    {
        return northFlowRateCars;
    }//end getNorthFlowRateCars()

    /**
     * Sets the flow rate for cars travelling North
     *
     * @param northFlowRateCars - new rate of cars per minute
     */
    public void setNorthFlowRateCars(int northFlowRateCars)
    {
        this.northFlowRateCars = 60 / northFlowRateCars;
    }//end setNorthFlowRateCars(int)

    /**
     * Returns the flow rate of cars travelling south
     *
     * @return - number of seconds between each car
     */
    public int getSouthFlowRateCars()
    {
        return southFlowRateCars;
    }//end getSouthFlowRateCars()

    /**
     * Sets the flow rate for cars travelling south
     *
     * @param southFlowRateCars - new rate of cars per minute
     */
    public void setSouthFlowRateCars(int southFlowRateCars)
    {
        this.southFlowRateCars = 60 / southFlowRateCars;
    }//end setSouthFlowRateCars(int)

    /**
     * Returns the flow rate of trucks travelling east
     *
     * @return - number of seconds between each truck
     */
    public int getEastFlowRateTrucks()
    {
        return eastFlowRateTrucks;
    }//end getEastFlowRateTrucks()

    /**
     * Sets the flow rate for trucks travelling east
     *
     * @param eastFlowRateTrucks - number of trucks per minute
     */
    public void setEastFlowRateTrucks(int eastFlowRateTrucks)
    {
        this.eastFlowRateTrucks = 60 /  eastFlowRateTrucks;
    }//end setEastFlowRateTrucks(int)

    /**
     * Returns the flow rate of trucks travelling west
     *
     * @return - number of seconds between trucks
     */
    public int getWestFlowRateTrucks()
    {
        return westFlowRateTrucks;
    }//end getWestFlowRateTrucks()

    /**
     * Sets the flow rate for trucks travelling west.
     *
     * @param westFlowRateTrucks - number of trucks per minute
     */
    public void setWestFlowRateTrucks(int westFlowRateTrucks)
    {
        this.westFlowRateTrucks = 60 / westFlowRateTrucks;
    }//end setWestFlowRateTrucks(int)

    /**
     * Returns the flow rate of trucks travelling north
     *
     * @return - number of seconds between trucks
     */
    public int getNorthFlowRateTrucks()
    {
        return northFlowRateTrucks;
    }//end getNorthFlowRateTrucks()

    /**
     * Sets the flow rate for trucks travelling north
     *
     * @param northFlowRateTrucks - number of trucks per minute
     */
    public void setNorthFlowRateTrucks(int northFlowRateTrucks)
    {
        this.northFlowRateTrucks = 60 / northFlowRateTrucks;
    }//end setNorthFlowRateTrucks(int)

    /**
     * Returns the flow rate of trucks travelling south
     *
     * @return - number of seconds between trucks
     */
    public int getSouthFlowRateTrucks()
    {
        return southFlowRateTrucks;
    }//end getSouthFFlowRateTrucks()

    /**
     * Sets the flow rate for trucks travelling south
     *
     * @param southFlowRateTrucks - number of trucks per minute
     */
    public void setSouthFlowRateTrucks(int southFlowRateTrucks)
    {
        this.southFlowRateTrucks = 60 / southFlowRateTrucks;
    }//end setSouthFlowRateTrucks(int)
}
