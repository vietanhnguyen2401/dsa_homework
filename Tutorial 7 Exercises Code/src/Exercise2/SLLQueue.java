/**
 * Class SLLQueue implement a queue using linked-list data structure. Each element of the queue is an integer.
 * Please refer to Lecture 7 for the detail singly linked list-based queue ADT.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Exercise2;
public class SLLQueue
{
    private QueueNode front;
    private QueueNode rear;

    /**
     * Constructor for objects of class SLLQueue.
     * This constructor creates an empty queue.
     */
    public SLLQueue()
    {
        front=null;
        rear=null;
    }

    /**
     * This operation returns true if the queue is empty, otherwise it returns false
     */    
    public boolean isEmpty()
    {
        if ((front==null)&&(rear==null))
            return true;
        else
            return false;
    }
    
    /**
     * This operation adds a newNode to the queue.
     */        
    public void enqueue(QueueNode newNode)
    {
        if (isEmpty())
        {
            front=newNode;
            rear=newNode;
        }
        else
        {
            rear.setNext(newNode);
            rear=newNode;
        }
    }

    /**
     * This operation returns the node at the front position of the queue and deletes this node.
     */    
    public QueueNode dequeue()
    {
        QueueNode tmp;
        if (!isEmpty())
        {
            tmp=front;
            if (front==rear)    //Queue has only one node
            {                
                front=null;
                rear=null;
            }
            else
                front=front.getNext();
            return tmp;    
        }
        else
            return null;
    }
    
    /**
     * This operation returns an item at the front position of the queue. This item will not be deleted.
     */        
    public QueueNode peek()
    {
        if (!isEmpty())
            return front;
        else
            return null;
    }  
}