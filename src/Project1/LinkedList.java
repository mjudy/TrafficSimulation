package Project1;

/**
 * @author theghv
 * @version 1.0
 *          Date: 2/13/14
 *          Time: 5:37 PM
 */
public class LinkedList<E>
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
    }//end LinkedList()

    /**
     * Adds a new member to the end of the list. Increments the count of members in the list.
     *
     * @param data - Object of any type to be added to the linked list.
     */
    public void add (E data)
    {
        Node temp = new Node(data);
        Node current = head;

        while(current.getNext() != null)
        {
            current = current.getNext();
        }

        current.setNext(temp);
        count++;
    }//end add(E)

    /**
     * Adds a new member to the list at the given index. Increments the count of members in the list.
     *
     * @param data - Object of any type to be added to the linked list.
     * @param index - integer specifying where in the list to add the object.
     */
    public void add (E data, int index)
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
    }//end add (E, int)

    /**
     * Returns the object stored at a given index in the list.
     *
     * @param index - integer specifying what object in the list to get the data from.
     * @return - returns
     */
    public E get (int index)
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
    }//end get (int)

    /**
     * Retrieves the data for the first element in the linked list after the head node.
     *
     * @return - returns the object stored in the first node
     */
    public E getFirst()
    {
        return head.getNext().getData();
    }//end getFirst()

    /**
     * Removes a node at the given index.
     *
     * @param index - location of the node to be removed
     * @return - returns true on successful removal
     */
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
    }//end remove (int)

    /**
     * Removes the first node in the linked list.
     *
     * @return - returns true on successful node removal.
     */
    public boolean removeFirst()
    {
        if (head.getNext() == null)
            return false;
        else
        {
            head.next = head.next.next;
        }
        count--;
        return true;
    }//end removeFirst()

    /**
     * Returns the current size of the list.
     *
     * @return - an integer describing the current size of the list.
     */
    public int size()
    {
        return count;
    }//end size()

    /**
     * Returns a string representation of the linked list.
     *
     * @return - String built from linked list data.
     */
    public String toString()
    {
        Node current = head.getNext();
        String str = "";
        while (current != null)
        {
            str += "[" + current.getData().toString() + "]\n";
            current = current.getNext();
        }
        return str;
    }//end toString()

    /**
     * Node inner class that defines how the nodes in the linked list function.
     */
    private class Node
    {
        Node next;
        E data;

        /**
         * Constructor that accepts only data parameters
         *
         * @param newData - data of any type to be stored in this node
         */
        public Node (E newData)
        {
            next = null;
            data = newData;
        }//end Node (E)

        /**
         * Constructor that accepts data parameters and a reference to another node
         *
         * @param newData - data of any type to be stored in this node.
         * @param nextNode - reference to where this node will point
         */
        public Node (E newData, Node nextNode)
        {
            next = nextNode;
            data = newData;
        }//end Node (E, Node)

        /**
         * Returns the data stored in this node.
         *
         * @return - the data of any type that is stored in this node
         */
        public E getData ()
        {
            return data;
        }//end getData()

        /**
         * Changes the data that this node contains.
         *
         * @param newData - New data to be stored in this node.
         */
        public void setData (E newData)
        {
            data = newData;
        }//end setData(E)

        /**
         * Gets the node following the current node in the linked list.
         *
         * @return - reference to the next node in the list
         */
        public Node getNext ()
        {
            return next;
        }//end getNext()

        /**
         * Sets the current node to point to a specified node.
         *
         * @param nextNode - reference to which the current node should point to
         */
        public void setNext (Node nextNode)
        {
            next = nextNode;
        }//end setNext(Node)
    }//end Node class
}//end LinkedList class