package Exercise1;
/**
 * Class ArrayTreeApp demonstrates an example about how to use ArrayTree class.
 * @author (nxthang) 
 * @version (1.0)
 */
public class ArrayTreeApp
{
    /**
     * Constructor for objects of class ArrayTreeApp
     */
    public ArrayTreeApp()
    {
    }
    
    public static void main(String[]args)
    {
        ArrayTree T=new ArrayTree();
        T.addNode("A",-1);
        T.addNode("B",0);
        T.addNode("C",0);
        T.addNode("D",0);
        T.addNode("G",3);        
        T.addNode("E",2);
        T.addNode("H",4);
        T.addNode("I",4);        
        T.addNode("F",2);
        T.addNode("K",5);
        System.out.println("Total leaves of the tree: " + T.countLeaves());
        System.out.println("The depth of the tree: " + T.getDepth());
        System.out.println("The node which has label H is: " + T.search("H"));
    }
}
