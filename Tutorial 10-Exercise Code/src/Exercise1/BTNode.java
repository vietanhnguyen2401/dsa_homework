/**
 * Write a description of class BTNode here.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Exercise1;
public class BTNode
{
    private String label;
    
    /**
     * Constructor for objects of class BTNode
     */
    public BTNode(String label)
    {
        this.label=label;
    }

    public void setLabel(String label)
    {
        this.label=label;
    }
    
    public String getLabel()
    {
        return label;
    }
}
