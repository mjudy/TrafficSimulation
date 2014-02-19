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
    private LinkedList results;
    private IntersectionFlowRate flowRate;


    /**
     * Constructor for the TrafficSim class. Initializes traffic queues, results linked list and IntersectionFlowRate
     * class. Also reads the input file and prints the initial board state before starting the traffic simulation.
     *
     * @param filename
     */
    public TrafficSim (String filename)
    {
        northbound = new LinkedList<Vehicle>();
        southbound = new LinkedList<Vehicle>();
        westbound = new LinkedList<Vehicle>();
        eastbound = new LinkedList<Vehicle>();
        results = new LinkedList();
        flowRate = new IntersectionFlowRate();

        readFromFile(filename);
        printBoard();
        simulation();
    }

    private boolean readFromFile(String filename)
    {
        char type = 'z';
        String temp = "";
        int carRate = 0;
        int truckRate = 0;

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

            scan.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

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

    private void simulation()
    {
        int time = 0;

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
            time++;
        }
    }

    private boolean addVehicle(char direction, Vehicle x)
    {
        switch (direction)
        {
            case 'N':
                northbound.add(x);
                System.out.print("");
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
        }
        return true;
    }
}