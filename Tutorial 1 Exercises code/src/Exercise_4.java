import java.util.Scanner;
import java.lang.String;


public class Exercise_4
{
   
    public static int NameSearching(String [] list, String s)
    {
        for (int i=0; i<list.length; i++)
            if (list[i].equals(s))
                return i;
        return -1;
    }
    
    public static void main(String[]args)
    {
        int n;
        String [] names;
        String search_name;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many names in the name list?");        
        n=scanner.nextInt();
        

        scanner.nextLine();//consume newline character \n (when you hit "Enter" on keyboard)
        
        names=new String[n];
        
        for (int i=0; i<n; i++)
        {
            System.out.println("Please enter names["+i+"]:");        
            names[i]=scanner.nextLine();
        }

        System.out.println("The list of names is:");
        for (int i=0; i<names.length; i++)
            System.out.println(names[i]);

        System.out.println("Please enter a name for searching:");
        search_name=scanner.nextLine();
        
        System.out.println("The searching result is: " + NameSearching(names,search_name));
    }
}
