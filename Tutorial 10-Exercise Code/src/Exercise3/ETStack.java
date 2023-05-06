/**
 * Class ETStack implements an array-based stack data structure. Each element of the stack is an expression tree.
 * Please refer to Lecture 7 for the array-based stack ADT, lecture 10 for expression tree in detail. 
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Exercise3;
public class ETStack
{
    private ExpressionTree[] items;
    private static final int maxSize=100;
    private int top;
    /**
     * Constructor for objects of class ETStack.
     * This construtor creates an empty stack.
     */
    public ETStack()
    {
        items=new ExpressionTree[maxSize];
        top=-1;
    }

    /**
     * This operation returns true if the stack is empty, otherwise it returns false
     */    
    public boolean isEmpty()
    {
        if (top==-1)
            return true;
        else
            return false;
    }
    
    /**
     * This operation returns true if the stack is full, otherwise it returns false
     */    
    public boolean isFull()
    {
        if (top==maxSize-1)
            return true;
        else
            return false;
    }
    
    /**
     * This operation adds a newItem to the stack
     */        
    public void push(ExpressionTree newItem)
    {
        if (!isFull())
        {
            top++;
            items[top]=newItem;
        }
    }

    /**
     * This operation returns the item at the top position of the stack and deletes this item.
     */    
    public ExpressionTree pop()
    {
        if (!isEmpty())
        {
            ExpressionTree tmp=items[top];
            top--;
            return tmp;
        }
        else
            return null;  //Return null if stack is empty
    }
    
    /**
     * This operation returns an item at the top position of the stack. This item will not be deleted.
     */        
    public ExpressionTree peek()
    {
        if (!isEmpty())
            return items[top];
        else
            return null;  //Return -1 if stack is empty
    }
    
}
