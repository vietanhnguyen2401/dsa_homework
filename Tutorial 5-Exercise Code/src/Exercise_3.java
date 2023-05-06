/**
 * Radix sort is used to sort N strings, each string has M characters.
 * The time complexity of the algorithm is O(M*(N+10)).
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
import java.util.Scanner;

public class Exercise_3
{
    /**
     * Constructor for objects of class Exercise_3
     */
    public Exercise_3()
    {
    }

    public static void print_list(String [] a)
    {
        for (int i=0; i<a.length; i++)
        {
           System.out.print(a[i]+" | ");
        }        
        System.out.println(" ");
    }

    /**
     * This method sorts the array of strings based on the value of character #d (column d).
     * Counting sort algorithm is used as a stable sort method (with m=255 because the range of elements
     * in counting sort is 0..255).     
     * 
     * @author (nxthang) 
     * @version (1.0)
     */
    
    public static void Column_Sort(String [] a, String [] b, int d)
    {
        int [] c;
        c=new int[256];
        for (int i=0; i<=255; i++)
            c[i]=0;
            
        for (int i=0; i<a.length; i++)
        {
            int pos=a[i].charAt(d);
            c[pos]=c[pos]+1;  
        }      
        
        for (int i=1; i<=255; i++)
            c[i]=c[i]+c[i-1];
        
        for (int i=a.length-1; i>=0; i--)
        {
            int pos=a[i].charAt(d);;
            b[c[pos]-1]=a[i];
            c[pos]=c[pos]-1;
        }

        System.out.println("Sorted array in column "+d+"(character # "+d+")");
        print_list(b);
    }   
    
     /**
     * This method implements Radix sort algorithm to sort an input array of strings a, where each string element has m character.
     * The result is stored in array b.
     * 
     * @author (nxthang) 
     * @version (1.0)
     */
    public static void Radix_Sort(String [] a, String [] b, int m)
    {
        for (int i=m-1; i>=0; i--)
        {
            Column_Sort(a,b,i);
            a=b;
        }
    }


    
    public static void main(String[]args)
    {
        int n,m;
        String [] a; 
        String [] b;
        
        System.out.println("Please input the integer N:");
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();        
        System.out.println("Please input the integer M:");
        m=scanner.nextInt();        
        //Remove newline character after calling nextInt()
        String tmp=scanner.nextLine();
        
        a=new String[n];
        b=new String[n];
        
        for (int i=0; i<n; i++)
        {
            System.out.println("Please input the string a["+i+"]" + "(a["+i+"] must have "+m+" characters):");
            a[i]=scanner.nextLine();
        }        
        
        System.out.println("The list of strings is: ");
        print_list(a);

        Radix_Sort(a,b,m);
        
        System.out.println("The list of sorted strings is: ");       
        print_list(b);        

    }
    
}
