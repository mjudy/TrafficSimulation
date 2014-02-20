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
    private Project1.LinkedList results;
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
        results = new Project1.LinkedList();
        flowRate = new IntersectionFlowRate();

        readFromFile(filename);
        printBoard();
        simulation();

    }

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
    }

    /**
     * Prints the state of the intersection during the traffic simulation.
     */
    private void printBoard()
    {
        System.out.println("Northbound: \n");
        for(Vehicle x : northbound)
        {
            System.out.println(x.toString());
        }
        System.out.println("Southbound: \n");
        for (Vehicle x : southbound)
        {
            System.out.println(x.toString());
        }
        System.out.println("Eastbound: \n");
        for (Vehicle x : eastbound)
        {
            System.out.println(x.toString());
        }
        System.out.println("Westbound: \n");
        for (Vehicle x : westbound)
        {
            System.out.println(x.toString());
        }
    }

    /**
     * //TODO Add moar comments.
     * Runs the traffic simulation.
     */
    private void simulation()
    {
        int time = 0;
        boolean santa = true; //traffic light. true means that cars can travel northbound to visit santa.
        boolean truckWait1 = false;
        boolean truckWait2 = false;

        //initialize intersection with 2 cars in each direction
        for(int i = 0; i < 2; i++)
        {
            northbound.add(new Vehicle ('c', time));
            southbound.add(new Vehicle ('c', time));
            eastbound.add(new Vehicle ('c', time));
            westbound.add(new Vehicle ('c', time));
        }

        time++;

        while(time <= 120)
        {
            //add cars and trucks to their queues based on their flow rate
            //TODO CHANGE SANTA'S PANTS
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

            if (santa)
            {
                if (northbound.size() > 0)
                {
                    if (!truckWait1 && northbound.peek().getType() == 'c')
                    {
                        results.add(new ResultVehicle(northbound.peek().getType(), northbound.peek().getTimeEntered(), time));
                        northbound.remove();
                    }
                    else if (!truckWait1 && northbound.peek().getType() == 't')
                    {
                        truckWait1 = true;
                    }
                    if (truckWait1)
                    {
                        results.add(new ResultVehicle(northbound.peek().getType(), northbound.peek().getTimeEntered(), time));
                        northbound.remove();
                    }
                }

                if (southbound.size() > 0)
                {
                    if (!truckWait2 && southbound.peek().getType() == 'c')
                    {
                        results.add(new ResultVehicle(southbound.peek().getType(), southbound.peek().getTimeEntered(), time));
                        southbound.remove();
                    }
                    else if (!truckWait2 && southbound.peek().getType() == 't')
                    {
                        truckWait2 = true;
                    }
                    if (truckWait2)
                    {
                        results.add(new ResultVehicle(southbound.peek().getType(), southbound.peek().getTimeEntered(), time));
                        southbound.remove();
                    }
                }
            }

            if (!santa)
            {
                if (eastbound.size() > 0)
                {
                    if (!truckWait1 && eastbound.peek().getType() == 'c')
                    {
                        results.add(new ResultVehicle(eastbound.peek().getType(), eastbound.peek().getTimeEntered(), time));
                        eastbound.remove();
                    }
                    else if (!truckWait1 && eastbound.peek().getType() == 't')
                    {
                        truckWait1 = true;
                    }
                    if (truckWait1)
                    {
                        results.add(new ResultVehicle(eastbound.peek().getType(), eastbound.peek().getTimeEntered(), time));
                        eastbound.remove();
                    }
                }

                if (westbound.size() > 0)
                {
                    if (!truckWait2 && westbound.peek().getType() == 'c')
                    {
                        results.add(new ResultVehicle(westbound.peek().getType(), westbound.peek().getTimeEntered(), time));
                        westbound.remove();
                    }
                    else if (!truckWait2 && westbound.peek().getType() == 't')
                    {
                        truckWait2 = true;
                    }
                    if (truckWait2)
                    {
                        results.add(new ResultVehicle(westbound.peek().getType(), westbound.peek().getTimeEntered(), time));
                        westbound.remove();
                    }
                }
            }
            printBoard();
            time++;
        }
    }

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
    }
}