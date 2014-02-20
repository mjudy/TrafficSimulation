package Project1;

/**
 * @author theghv
 * @version 1.0
 *          Date: 2/13/14
 *          Time: 5:37 PM
 */
public class LinkedList
{
    private Node head;
    private int count;

    /**
     * Default constructor to initialize the LinkedList with a head node, and an empty count of list members.
     */
    public LinkedList()
    {
        head = new Node(null);
        count = 0;
    }

    /**
     * Adds a new member to the end of the list. Increments the count of members in the list.
     *
     * @param data - Object of any type to be added to the linked list.
     */
    public void add (ResultVehicle data)
    {
        Node temp = new Node(data);
        Node current = head;

        while(current.getNext() != null)
        {
            current = current.getNext();
        }

        current.setNext(temp);
        count++;
    }

    /**
     * Adds a new member to the list at the given index. Increments the count of members in the list.
     *
     * @param data - Object of any type to be added to the linked list.
     * @param index - integer specifying where in the list to add the object.
     */
    public void add (ResultVehicle data, int index)
    {
        Node temp = new Node(data);
        Node current = head;

        for (int i = 1; i < index && current.getNext() != null; i++)
        {
            current = current.getNext();
        }

        temp.setNext(current.getNext());
        current.setNext(temp);
        count++;
    }

    /**
     * Returns the object stored at a given index in the list.
     *
     * @param index - integer specifying what object in the list to get the data from.
     * @return - returns
     */
    public ResultVehicle get (int index)
    {
        if(index <= 0)
        {
            return null;
        }

        Node current = head.getNext();
        for(int i = 1; i < index; i++)
        {
            if (current.getNext() == null)
            {
                return null;
            }

            current = current.getNext();
        }

        return current.getData();
    }

    public boolean remove (int index)
    {
        if (index < 1 || index > size())
        {
            return false;
        }

        Node current = head;
        for (int i = 1; i < index; i++)
        {
            if (current.getNext() == null)
            {
                return false;
            }

            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        count--;
        return true;
    }

    public int size()
    {
        return count;
    }

    public String toString()
    {
        Node current = head.getNext();
        String str = "";
        while (current != null)
        {
            str += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return str;
    }

    private class Node
    {
        Node next;
        ResultVehicle data;

        public Node (ResultVehicle newData)
        {
            next = null;
            data = newData;
        }

        public Node (ResultVehicle newData, Node nextNode)
        {
            next = nextNode;
            data = newData;
        }

        public ResultVehicle getData ()
        {
            return data;
        }

        public void setData (ResultVehicle newData)
        {
            data = newData;
        }

        public Node getNext ()
        {
            return next;
        }

        public void setNext (Node nextNode)
        {
            next = nextNode;
        }
    }
}