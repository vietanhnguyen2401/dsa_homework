/**
 * Write a description of class SLLStackApp here.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Exercise1;
public class SLLStackApp
{
    /**
     * Constructor for objects of class SLLStackApp
     */
    public SLLStackApp()
    {
    }

    public static void copyStack(SLLStack scr, SLLStack des)
    {
        SLLStack tmp=new SLLStack();
        StackNode node;
        do
        {
            node=scr.pop();
            if (node != null)
                tmp.push(node);
        }
        while (node != null);
        do
        {
            node=tmp.pop();
            if (node != null)
            {
                scr.push(node);
                des.push(node);
            }
        }
        while (node != null);        
    }
    
    public static void printStack(SLLStack s)
    {
        SLLStack tmp=new SLLStack();
        copyStack(s,tmp);
        StackNode node;
        do
        {
            node=tmp.pop();
            if (node != null)
                System.out.println(node.getData());
        }
        while (node != null);
    }
    
    public static void main(String[]args)
    {
        SLLStack s=new SLLStack();
        System.out.println("Push three nodes into the Stack:");     
        
        //StackNode A = new StackNode('A');
        //s.push(A);
        
        s.push(new StackNode('A'));
        
        s.push(new StackNode('B'));
        s.push(new StackNode('C'));
        System.out.println("Print out all stack's node:");
        printStack(s);
        StackNode topNode=s.peek();
        System.out.println("The current top node of the Stack is: "+topNode.getData());
        topNode=s.pop();
        System.out.println("Pop one node from the Stack. Returned node is: "+topNode.getData());
        topNode=s.peek();
        System.out.println("Now, the current top node of the Stack is: "+topNode.getData());
        System.out.println("Push two nodes into the Stack:");        
        s.push(new StackNode('D'));
        s.push(new StackNode('E'));        

        SLLStack s1=new SLLStack();
        copyStack(s,s1);
        System.out.println("Copy s to s1. Print out all s1's nodes:");
        printStack(s1);
        
    }    
}