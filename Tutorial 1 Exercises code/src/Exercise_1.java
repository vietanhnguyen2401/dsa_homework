import java.util.Scanner;
import java.lang.String;

public class Exercise_1
{

    public static int CountChar(String s)
    {
        int count=0;
        for (int i=0; i<s.length(); i++)
        if (s.charAt(i) !=' ')
            count++;
        return count;    
    }
    
    public static void main(String[]args)
    {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name: ");        
        name=scanner.nextLine();
        System.out.println("The total characters of that name is: "+CountChar(name));        
    }    
}
