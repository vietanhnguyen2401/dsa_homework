/**
 * Class FindDuplicate demonstrates the solution for the finding duplicate problem using binary search tree.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Exercise2;
public class FindDuplicate
{
    /**
     * Constructor for objects of class FindDuplicate
     */
    public FindDuplicate()
    {
    }

    public static void main()
    {
        int[] a = {5,7,5,3,2,5,10,3,3};
        BinarySearchTree t = new BinarySearchTree();
        
        for (int i=0; i<a.length; i++)
            if (t.insert(a[i],t) == false)
            {
                System.out.println(a[i]+" is a duplicate number!");
            }       
    }
}
