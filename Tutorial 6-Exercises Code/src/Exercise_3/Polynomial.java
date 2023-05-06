package Exercise_3;


/**
 * Write a description of class Polynomial here.
 * @author (nxthang) 
 * @version (1.0)
 * 
 */
public class Polynomial
{
    /**
     * Constructor for objects of class Polynomial
     */
    public Polynomial()
    {
    }

    public static void printPoly(SLListPoly poly)
    {
        int l=poly.getLength();
        String str="";
        SLNodePoly aNode=poly.get(1);
        if (aNode.getDegree()==0)
        {
            str=aNode.getCoeff()+str;        
        }
        else
        {
            if (aNode.getDegree()==1)
                str=aNode.getCoeff()+"*x"+str;        
            else
                str=aNode.getCoeff()+"*x^"+aNode.getDegree()+str;        
        }
        for (int i=2; i<=l; i++)
        {
            SLNodePoly aNode1=poly.get(i);
            if (aNode1.getDegree()==0)
            {
                str=aNode1.getCoeff()+ " + " +str;        
            }
            else
            {
                if (aNode1.getDegree()==1)
                    str=aNode1.getCoeff()+"*x"+ " + " + str;        
                else
                    str=aNode1.getCoeff()+"*x^"+aNode1.getDegree()+ " + "+str;        
            }                        
        }
        System.out.println(str);
        
    }
    
    public static void main(String[]args)
    {
        SLListPoly myPoly=new SLListPoly();
        myPoly.add(new SLNodePoly(4,4));
        myPoly.add(new SLNodePoly(3,3));
        myPoly.add(new SLNodePoly(2,2));
        myPoly.add(new SLNodePoly(1,1));
        myPoly.add(new SLNodePoly(10,0));        
        System.out.println("The original polynomial is: ");
        printPoly(myPoly);
        myPoly.derivative();
        System.out.println("The 1st derivative of the polynomial is: ");        
        printPoly(myPoly);        
    }    
    
}
