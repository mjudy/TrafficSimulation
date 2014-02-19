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

    public LinkedList()
    {
        head = new Node(null);
        count = 0;
    }

    public void add (Object data)
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

    public void add (Object data, int index)
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

    public Object get (int index)
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
        Object data;

        public Node (Object newData)
        {
            next = null;
            data = newData;
        }

        public Node (Object newData, Node nextNode)
        {
            next = nextNode;
            data = newData;
        }

        public Object getData ()
        {
            return data;
        }

        public void setData (Object newData)
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