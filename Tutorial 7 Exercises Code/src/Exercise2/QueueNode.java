/**
 * Class QueueNode implement an elements (a node) of a queue using singly linked list data structure.
 * Each element of the queue contains an integer (data) and a reference variable named next.
 * Please refer to Lecture 6 for the Node ADT in detail.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Exercise2;
public class QueueNode
{
    private int data;
    private QueueNode next;

    /**
     * Constructor for objects of class QueueNode
     * This constructor create a node from an input integer (data)
     */
    public QueueNode(int data)
    {
        this.data=data;
        this.next=null;
    }

    /**
     * This operation sets the next reference to the node specify in the parameter (next)
     */    
    public void setNext(QueueNode next)
    {
        this.next=next;
    }

    /**
     * This operation return the next reference
     */    
    public QueueNode getNext()
    {
        return this.next;
    }

    /**
     * This operation assigns data of the node to the input integer (data)
     */        
    public void setData(int data)
    {
        this.data=data;
    }

    /**
     * This operation return the current data of the node
     */        
    public int getData()
    {
        return this.data;
    }    
}