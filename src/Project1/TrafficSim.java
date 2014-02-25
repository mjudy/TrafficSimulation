package Project1;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Mark Judy <mjudy1@umbc.edu>
 * @version 1.0
 *          Date: 2/13/14
 *          Time: 4:48 PM               
 */
public class TrafficSim
{
    private Queue<Vehicle> northbound;
    private Queue<Vehicle> southbound;
    private Queue<Vehicle> westbound;
    private Queue<Vehicle> eastbound;
    private Project1.LinkedList<ResultVehicle> results;
    private IntersectionFlowRate flowRate;


    /**
     * Constructor for the TrafficSim class. Initializes traffic queues, results linked list and IntersectionFlowRate
     * class. Also reads the input file and prints the initial board state before starting the traffic simulation.
     *
     * @param filename - name of file to be read by readFromFile(filename).
     */
    public TrafficSim (String filename)
    {
        northbound = new LinkedList<Vehicle>();
        southbound = new LinkedList<Vehicle>();
        westbound = new LinkedList<Vehicle>();
        eastbound = new LinkedList<Vehicle>();
        results = new Project1.LinkedList<ResultVehicle>();
        flowRate = new IntersectionFlowRate();

        readFromFile(filename);
        simulation();
        System.out.println(printResults());
    }//end TrafficSim (String)

    /**
     * Reads the input data from a file specified by the filename parameter then sets the
     * flow rate for cars and trucks in each direction.
     *
     * @param filename - name of file to be read
     * @return - Returns false is file read fails. Returns true on success.
     */
    private boolean readFromFile(String filename)
    {
        char type;
        String temp;
        int carRate;
        int truckRate;

        File file = new File(filename);

        try
        {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine())
            {
                temp = scan.next();
                type = temp.charAt(0);
                carRate = scan.nextInt();
                truckRate = scan.nextInt();

                switch (type)
                {
                    case 'N':
                        flowRate.setNorthFlowRateCars(carRate);
                        flowRate.setNorthFlowRateTrucks(truckRate);
                        break;
                    case 'S':
                        flowRate.setSouthFlowRateCars(carRate);
                        flowRate.setSouthFlowRateTrucks(truckRate);
                        break;
                    case 'E':
                        flowRate.setEastFlowRateCars(carRate);
                        flowRate.setEastFlowRateTrucks(truckRate);
                        break;
                    case 'W':
                        flowRate.setWestFlowRateCars(carRate);
                        flowRate.setWestFlowRateTrucks(truckRate);
                        break;
                }
            }
            //close the file
            scan.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }//end readFromFile(String)

    /**
     * Prints the state of the intersection during the traffic simulation.
     */
    private void printBoard()
    {
        int i;
        String str = "";

        System.out.printf("%4s%6d\n", "SB", southbound.size());
        switch(southbound.size())
        {
            case 0:
                for (i = 0; i < 6; i++)
                    System.out.println();
                break;
            case 1:
                for(i = 1; i < 6; i++)
                    System.out.println();
                System.out.printf("%8c\n",southbound.peek().getType());
                break;
            case 2:
                for(i = 2; i < 6; i++)
                    System.out.println();
                System.out.printf("%8c\n", 'x');
                System.out.printf("%8c\n", southbound.peek().getType());
                break;
            case 3:
                for(i = 3; i < 6; i++)
                    System.out.println();
                for(i = 0; i < 2; i++)
                    System.out.printf("%8c\n", 'x');
                System.out.printf("%8c\n", southbound.peek().getType());
                break;
            case 4:
                for(i = 4; i < 6; i++)
                    System.out.println();
                for(i = 0; i < 3; i++)
                    System.out.printf("%8c\n", 'x');
                System.out.printf("%8c\n", southbound.peek().getType());
                break;
            case 5:
                System.out.println();
                for(i = 0; i < 4; i++)
                    System.out.printf("%8c\n", 'x');
                System.out.printf("%8c\n", southbound.peek().getType());
                break;
                default:
            case 6:
                for(i = 0; i < 5; i++)
                    System.out.printf("%8c\n", 'x');
                System.out.printf("%8c\n", southbound.peek().getType());
                break;
        }

        switch (eastbound.size())
        {
            case 0:
                for(i = 0; i < 6; i++)
                    str += " ";
                break;
            case 1:
                for (i = 1; i < 6; i++)
                    str += " ";
                str += eastbound.peek().getType();
                break;
            case 2:
                for (i = 2; i < 6; i++)
                    str += " ";
                for (i = 1; i < 2; i++)
                    str += "x";
                str += eastbound.peek().getType();
                break;
            case 3:
                for (i = 3; i < 6; i++)
                    str += " ";
                for (i = 1; i < 3; i++)
                    str += "x";
                str += eastbound.peek().getType();
                break;
            case 4:
                for ( i = 4; i < 6; i++)
                    str += " ";
                for (i = 1; i < 4; i++)
                    str += "x";
                str += eastbound.peek().getType();
                break;
            case 5:
                str += " ";
                for (i = 1; i < 5; i++)
                    str += "x";
                str += eastbound.peek().getType();
                break;
            default:
            case 6:
                for (i = 1; i < 6; i++)
                    str += "x";
                str += eastbound.peek().getType();
        }

        str += "   ";

        switch (westbound.size())
        {
            case 0:
                break;
            case 1:
                str += westbound.peek().getType();
                break;
            case 2:
                str += westbound.peek().getType();
                for (i = 1; i < 2; i++)
                    str += "x";
                break;
            case 3:
                str += westbound.peek().getType();
                for (i = 1; i < 3; i++)
                    str += "x";
                break;
            case 4:
                str += westbound.peek().getType();
                for (i = 1; i < 4; i++)
                    str += "x";
                break;
            case 5:
                str += westbound.peek().getType();
                for (i = 1; i < 5; i++)
                    str += "x";
                str += " ";
                break;
            default:
            case 6:
                str += westbound.peek().getType();
                for (i = 1; i < 6; i++)
                    str += "x";
        }

        System.out.println("EB: " + eastbound.size());
        System.out.println(str);
        System.out.println("\t\t\tWB: " + westbound.size());

        switch(northbound.size())
        {
            case 0:
                for (i = 0; i < 6; i++)
                    System.out.println();
                break;
            case 1:
                System.out.printf("%8c\n",northbound.peek().getType());
                for(i = 1; i < 6; i++)
                    System.out.println();
                break;
            case 2:
                System.out.printf("%8c\n", northbound.peek().getType());
                System.out.printf("%8c\n", 'x');
                for(i = 2; i < 6; i++)
                    System.out.println();
                break;
            case 3:
                System.out.printf("%8c\n", northbound.peek().getType());
                for(i = 0; i < 2; i++)
                    System.out.printf("%8c\n", 'x');
                for(i = 3; i < 6; i++)
                    System.out.println();
                break;
            case 4:
                System.out.printf("%8c\n", northbound.peek().getType());
                for(i = 0; i < 3; i++)
                    System.out.printf("%8c\n", 'x');
                for(i = 4; i < 6; i++)
                    System.out.println();
                break;
            case 5:
                System.out.printf("%8c\n", northbound.peek().getType());
                for(i = 0; i < 4; i++)
                    System.out.printf("%8c\n", 'x');
                System.out.println();
                break;
            default:
            case 6:
                System.out.printf("%8c\n", northbound.peek().getType());
                for(i = 0; i < 5; i++)
                    System.out.printf("%8c\n", 'x');
                break;
        }
        System.out.printf("%4s%6d\n", "NB", northbound.size());
    }//end printBoard()

    /**
     * Empties the results list to find how many vehicles, and of what type, went through the intersection and calculates
     * average wait times for each vehicle.
     *
     * @return - returns results string
     */
    private String printResults()
    {
        int count = 0, carCount = 0, truckCount = 0;
        double waitTime, avgWait = 0;
        String str;

        for (int i = 1; i <= results.size(); i++)
        {
            if (results.get(i).getType() == 'c')
                carCount++;
            else
                truckCount++;

            waitTime = results.get(i).getTimeExited() - results.get(i).getTimeEntered();
            avgWait += waitTime;
            count++;
        }

        avgWait /= results.size();

        str = "The final results are:\n" + "The number of vehicles that passed through the intersection is: " +
            count + "\n" + "The number of cars that passed through the intersection is: " + carCount + "\n" +
            "The number of trucks that passed through the intersection is: " + truckCount + "\n" +
            "The average wait time for this intersection is: " + avgWait;
        return str;
    }//end printResults()

    /**
     * Runs the traffic simulation. Initializes the simulation with 2 cars going each direction in the intersection.
     */
    private void simulation()
    {
        int time = 0;
        int priorityTime = 0;
        String str;
        boolean santa = true; //traffic light. true means that cars can travel northbound to visit santa.
        int truckWait1 = 2, truckWait2 = 2;
        boolean carWait1 = true, carWait2 = true;

        //initialize intersection with 2 cars in each direction
        for(int i = 0; i < 2; i++)
        {
            northbound.add(new Vehicle ('c', time));
            southbound.add(new Vehicle ('c', time));
            eastbound.add(new Vehicle ('c', time));
            westbound.add(new Vehicle ('c', time));
        }
        printBoard();
        System.out.println("N/S Light Green. Time: " + time + "\n----------------------------------------------------------\n");

        while (time < 120)
        {
            time++;
            priorityTime++;
            if (santa)
            {
                if (northbound.size() > 0)
                {
                    if (carWait1 && northbound.peek().getType() == 'c')
                    {
                        carWait1 = false;
                    }
                    else if (truckWait1 > 0  && northbound.peek().getType() == 't')
                    {
                        truckWait1--;
                    }
                    if (!carWait1)
                    {
                        results.add(new ResultVehicle(northbound.peek().getType(), northbound.peek().getTimeEntered(), time));
                        northbound.remove();
                        carWait1 = true;
                    }
                    if (truckWait1 == 0)
                    {
                        results.add(new ResultVehicle(northbound.peek().getType(), northbound.peek().getTimeEntered(), time));
                        truckWait1 = 2;
                        northbound.remove();
                    }
                }

                if (southbound.size() > 0)
                {
                    if (carWait2 && southbound.peek().getType() == 'c')
                    {
                        carWait2 = false;
                    }
                    else if (truckWait2 > 0  && southbound.peek().getType() == 't')
                    {
                        truckWait2--;
                    }
                    if (!carWait2)
                    {
                        results.add(new ResultVehicle(southbound.peek().getType(), southbound.peek().getTimeEntered(), time));
                        southbound.remove();
                        carWait2 = true;
                    }
                    if (truckWait2 == 0)
                    {
                        results.add(new ResultVehicle(southbound.peek().getType(), southbound.peek().getTimeEntered(), time));
                        truckWait2 = 2;
                        southbound.remove();
                    }
                }
            }

            if (!santa)
            {
                if (eastbound.size() > 0)
                {
                    if (carWait1 && eastbound.peek().getType() == 'c')
                    {
                        carWait1 = false;
                    }
                    else if (truckWait1 > 0  && eastbound.peek().getType() == 't')
                    {
                        truckWait1--;
                    }
                    if (!carWait1)
                    {
                        results.add(new ResultVehicle(eastbound.peek().getType(), eastbound.peek().getTimeEntered(), time));
                        eastbound.remove();
                        carWait1 = true;
                    }
                    if (truckWait1 == 0)
                    {
                        results.add(new ResultVehicle(eastbound.peek().getType(), eastbound.peek().getTimeEntered(), time));
                        truckWait1 = 2;
                        eastbound.remove();
                    }
                }

                if (westbound.size() > 0)
                {
                    if (carWait2 && westbound.peek().getType() == 'c')
                    {
                        carWait2 = false;
                    }
                    else if (truckWait2 > 0 && westbound.peek().getType() == 't')
                    {
                        truckWait2--;
                    }
                    if (!carWait2)
                    {
                        results.add(new ResultVehicle(westbound.peek().getType(), westbound.peek().getTimeEntered(), time));
                        westbound.remove();
                        carWait2 = true;
                    }
                    if (truckWait2 == 0)
                    {
                        results.add(new ResultVehicle(westbound.peek().getType(), westbound.peek().getTimeEntered(), time));
                        truckWait2 = 2;
                        westbound.remove();
                    }
                }
            }

            //add cars and trucks to their queues based on their flow rate
            if((time % flowRate.getNorthFlowRateCars()) == 0)
                addVehicle('N', new Vehicle('c', time));
            if((time % flowRate.getNorthFlowRateTrucks()) == 0)
                addVehicle('N', new Vehicle('t', time));
            if((time % flowRate.getSouthFlowRateCars()) == 0)
                addVehicle('S', new Vehicle('c', time));
            if((time % flowRate.getSouthFlowRateTrucks()) == 0)
                addVehicle('S', new Vehicle('t', time));
            if((time % flowRate.getEastFlowRateCars()) == 0)
                addVehicle('E', new Vehicle('c', time));
            if((time % flowRate.getEastFlowRateTrucks()) == 0)
                addVehicle('E', new Vehicle('t', time));
            if((time % flowRate.getWestFlowRateCars()) == 0)
                addVehicle('W', new Vehicle('c', time));
            if((time % flowRate.getWestFlowRateTrucks()) == 0)
                addVehicle('W', new Vehicle('t', time));

            printBoard();
            if (santa)
                str = "N/S Light Green. Time: " + time;
            else
                str = "E/W Light Green, Time: " + time;
            System.out.println(str + "\n----------------------------------------------------------\n");

            if(santa && priorityTime >= 30 && (westbound.size() > 0 || eastbound.size() > 0))
            {
                santa = false;
                priorityTime = 0;
                System.out.println("E/W Light Changed!");
            }
            else if(!santa && priorityTime >= 10 && (eastbound.size() ==  0 && westbound.size() == 0))
            {
                santa = true;
                priorityTime = 0;
                System.out.println("N/S Light Changed!");
            }
            else if(!santa && priorityTime >= 30)
            {
                santa = true;
                priorityTime = 0;
                System.out.println("N/S Light Changed!");
            }
        }
    }//end simulation()

    /**
     * Adds vehicles to their designated lanes during the traffic simulation.
     *
     * @param direction - defines which queue to add a vehicle to
     * @param x - a Vehicle object to add to its designated queue
     * @return - Returns false if an improper direction was specified. Returns true when vehicle addition successful.
     */
    private boolean addVehicle(char direction, Vehicle x)
    {
        switch (direction)
        {
            case 'N':
                northbound.add(x);
                break;
            case 'S':
                southbound.add(x);
                break;
            case 'E':
                eastbound.add(x);
                break;
            case 'W':
                westbound.add(x);
                break;
            default:
                return false;
        }
        return true;
    }//end addVehicle(char, Vehicle)
}//end TrafficSim class