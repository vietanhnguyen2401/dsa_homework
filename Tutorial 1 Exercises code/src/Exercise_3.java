import java.util.Scanner;

public class Exercise_3
{
    public static void SimpleSort(int [] a)
    {       
    	for (int i=0; i<a.length-1; i++)
    	{
            int min=a[i];
            int pos=i;
            for (int j=i+1; j<a.length; j++)
                if (min>a[j])
                {
                    min=a[j];
                    pos=j;
                }
            int tmp=a[i];
            a[i]=min;
            a[pos]=tmp;
        }
    }
    
    public static void print_array(int [] a)
    {
        for (int i=0; i<a.length; i++)
        {
           System.out.print(a[i]+" ");
        }        
        System.out.println(" ");
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
        
        System.out.println("The list of integers is: ");
        print_array(a);

        SimpleSort(a);
        
        System.out.println("The list of sorted integers is: ");       
        print_array(a);
    }
}
