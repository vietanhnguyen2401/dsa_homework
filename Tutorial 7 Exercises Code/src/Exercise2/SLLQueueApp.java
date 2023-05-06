/**
 * Write a description of class SLLQueueApp here.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Exercise2;
public class SLLQueueApp
{
    /**
     * Constructor for objects of class SLLQueueApp
     */
    public SLLQueueApp()
    {
    }

    public static void copyQueue(SLLQueue scr, SLLQueue des)
    {
        SLLQueue tmp=new SLLQueue();
        QueueNode node;
        do
        {
            node=scr.dequeue();
            if (node != null)
                tmp.enqueue(node);
        }
        while (node != null);
        do
        {
            node=tmp.dequeue();
            if (node != null)
            {
                scr.enqueue(node);
                des.enqueue(node);
            }
        }
        while (node != null);        
    }
    
    public static void printQueue(SLLQueue q)
    {
        SLLQueue tmp=new SLLQueue();
        copyQueue(q,tmp);
        QueueNode node;
        do
        {
            node=tmp.dequeue();
            if (node != null)
                System.out.print(node.getData()+" ");
        }
        while (node != null);
        System.out.println(" ");
    }
    
    public static void main(String[]args)
    {
        SLLQueue q=new SLLQueue();
        System.out.println("Enqueue three nodes into the queue:");                
        q.enqueue(new QueueNode(1));
        q.enqueue(new QueueNode(2));
        q.enqueue(new QueueNode(3));
        System.out.println("Print out all queue's node:");
        printQueue(q);
        QueueNode frontNode=q.peek();
        System.out.println("The current front node of the queue is: "+frontNode.getData());
        frontNode=q.dequeue();
        System.out.println("Dequeue one node from the queue. Returned node is: "+frontNode.getData());
        frontNode=q.peek();
        System.out.println("Now, the current front node of the queue is: "+frontNode.getData());
        System.out.println("Enqueue two nodes into the queue:");        
        q.enqueue(new QueueNode(4));
        q.enqueue(new QueueNode(5));        

        SLLQueue q1=new SLLQueue();
        copyQueue(q,q1);
        System.out.println("Copy q to q1. Print out all q1's nodes:");
        printQueue(q1);
    }    
}
