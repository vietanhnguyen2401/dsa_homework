import java.util.Scanner;

public class Exercise_2
{

	public static int FindMax(int [] a)
    {
        int max =a[0];
        for (int i=0; i<a.length; i++)
            if (max < a[i])
                max=a[i];
        return max;        
    }
    
    public static void main(String[]args)
    {
        int n;
        int [] a;  

        System.out.println("Please input the integer N:");
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();        

        a=new int[n];
        
        for (int i=0; i<n; i++)
        {
            System.out.println("Please input the integer a["+i+"]:");
            a[i]=scanner.nextInt();
        }        
        
        System.out.println("The list of " + n + " integers is:");
        for (int i=0; i<n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");        
        
        System.out.println("The maximum integer of the list is: " + FindMax(a));
    }
    
}
