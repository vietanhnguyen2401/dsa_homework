package Exercise2;
/**
 * Class ArrayBinaryTree implements Binary Tree data structure using an array. 
 * Binary Tree's nodes are indexed using the numbering scheme introduced in Lecture 09.
 * Node has a string label that is stored in the l array.
 * Please refers to Lecture 09 and week 09 tutorial instruction for more detail on Binary Tree's ADT.
 * @author (nxthang) 
 * @version (1.0)
 */
import java.util.Arrays;
public class ArrayBinaryTree
{
    private static final int maxSize=100; //Maximum possible number of nodes in the tree
    private String[] l;
    
    /**
     * Constructor for objects of class ArrayBinaryTree
     * Create an empty Binary Tree
     */
    public ArrayBinaryTree()
    {
        l = new String[maxSize];
        Arrays.fill(l,null);
    }

    public boolean isEmpty()
    {
        return (l[0]==null);
    }
    
    public void addRoot(String label)
    {
        if (l[0]==null)
        {
            l[0]=label;     
        }
    }
    
    public int getLeftChild(int node)
    {
        return 2*node+1;
    }
    
    public int getRightChild(int node)
    {
        return 2*node+2;
    }
    
    public int getParent(int node)
    {
        return (int)Math.floor((node-1)/2);
    }
    
    public String getNodeLabel(int node)
    {
        return l[node];
    }
    
    public void setNodeLabel(String label, int node)
    {
        l[node]=label;
    }
    
    public void addLeftChild(String label, int node)
    {
        setNodeLabel(label,getLeftChild(node));
    }
    
    public void addRightChild(String label, int node)
    {
        setNodeLabel(label,getRightChild(node));
    }
    
    public void preOrderTraversal(int node)
    {
        if (l[node] != null)
        {
            System.out.print(l[node] + " ");
            preOrderTraversal(getLeftChild(node));
            preOrderTraversal(getRightChild(node));
        }
    }

    public void inOrderTraversal(int node)
    {
        if (l[node] != null)
        {
            inOrderTraversal(getLeftChild(node));
            System.out.print(l[node] + " ");
            inOrderTraversal(getRightChild(node));
        }
    }

    public void postOrderTraversal(int node)
    {
        if (l[node] != null)
        {
            postOrderTraversal(getLeftChild(node));
            postOrderTraversal(getRightChild(node));
            System.out.print(l[node] + " ");
        }
    }
    
    public boolean isLeaf(int node)
    {
        return ((l[getLeftChild(node)]==null)&&(l[getRightChild(node)]==null));
    }
    
    public int getLevel(int node)
    {
        int count=0;
        int tmp=node;
        while (getParent(tmp)!= -1)
        {
            tmp=getParent(tmp);
            count++;
        }
        return count;
    }

    public int getDepth(int node)
    {
        if (isLeaf(node))
            return 0;
        else
        {
            int leftSubTreeDepth=0;
            int rightSubTreeDepth=0;
            if (l[getLeftChild(node)] != null)
                leftSubTreeDepth=getDepth(getLeftChild(node));
            if (l[getRightChild(node)] != null)
                rightSubTreeDepth=getDepth(getRightChild(node));
            if (leftSubTreeDepth > rightSubTreeDepth)
                return 1+leftSubTreeDepth;
            else
                return 1+rightSubTreeDepth;
        }
    }    
    
    public int countLeaves()
    {
        int currentDepth=getDepth(0);
        int estimatedTotalNode=(int)Math.pow(2,currentDepth+1)-1;
        int count=0;
        for (int i=0; i<=estimatedTotalNode; i++)
            if ((l[i]!=null)&&(isLeaf(i)))
                count++;
        return count;        

    }
       
    public int search(String label)
    {
        int currentDepth=getDepth(0);
        int estimatedTotalNode=(int)Math.pow(2,currentDepth+1)-1;
        for (int i=0; i<=estimatedTotalNode; i++)
            if (l[i]==label)
                return i;
        return -1;        
    }
}