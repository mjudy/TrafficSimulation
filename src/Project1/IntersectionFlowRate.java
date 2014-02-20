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
    }

    public int getEastFlowRateCars()
    {
        return eastFlowRateCars;
    }

    public void setEastFlowRateCars(int eastFlowRateCars)
    {
        this.eastFlowRateCars = 60 / eastFlowRateCars;
    }

    public int getWestFlowRateCars()
    {
        return westFlowRateCars;
    }

    public void setWestFlowRateCars(int westFlowRateCars)
    {
        this.westFlowRateCars = 60 / westFlowRateCars;
    }

    public int getNorthFlowRateCars()
    {
        return northFlowRateCars;
    }

    public void setNorthFlowRateCars(int northFlowRateCars)
    {
        this.northFlowRateCars = 60 / northFlowRateCars;
    }

    public int getSouthFlowRateCars()
    {
        return southFlowRateCars;
    }

    public void setSouthFlowRateCars(int southFlowRateCars)
    {
        this.southFlowRateCars = 60 / southFlowRateCars;
    }

    public int getEastFlowRateTrucks()
    {
        return eastFlowRateTrucks;
    }

    public void setEastFlowRateTrucks(int eastFlowRateTrucks)
    {
        this.eastFlowRateTrucks = 60 /  eastFlowRateTrucks;
    }

    public int getWestFlowRateTrucks()
    {
        return westFlowRateTrucks;
    }

    public void setWestFlowRateTrucks(int westFlowRateTrucks)
    {
        this.westFlowRateTrucks = 60 / westFlowRateTrucks;
    }

    public int getNorthFlowRateTrucks()
    {
        return northFlowRateTrucks;
    }

    public void setNorthFlowRateTrucks(int northFlowRateTrucks)
    {
        this.northFlowRateTrucks = 60 / northFlowRateTrucks;
    }

    public int getSouthFlowRateTrucks()
    {
        return southFlowRateTrucks;
    }

    public void setSouthFlowRateTrucks(int southFlowRateTrucks)
    {
        this.southFlowRateTrucks = 60 / southFlowRateTrucks;
    }
}
