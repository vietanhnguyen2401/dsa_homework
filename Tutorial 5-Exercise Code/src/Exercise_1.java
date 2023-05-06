/**
 * Given a list of N students including students name and students mark (an integer in the range 0..10).
 * This program show the name of M students who has the highest marks.
 * Counting sort algorithm is used to sort the list based on student's mark. The time complexity of this program is O(n)
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
import java.util.Scanner;
import java.lang.String;

public class Exercise_1
{
    /**
     * Constructor for objects of class Exercise_1
     */
    public Exercise_1()
    {
    }

    public static void print_student_list(String [] names, int [] marks)
    {
        int n=marks.length;
        System.out.println("");        
        System.out.println("The list of " + n +" students is");
        for (int i=0; i<n; i++)
            System.out.println("Name: "+names[i]+"  Mark: "+ marks[i]);
        System.out.println("");    
    }

    /**
     * This method employs Counting sort to sort the list of N students by their mark (from 0 .. 10)
     */    
    public static void sort_student_by_mark(String [] names, int [] marks, String [] newnames, int [] newmarks)
    {
        int [] c;
        c=new int[11];
        //Initialize the array c to all zeros
        for (int i=0; i<=10; i++)
            c[i]=0;
            
        for (int i=0; i<marks.length; i++)
            c[marks[i]]=c[marks[i]]+1;  //c[i] now contains the number of mark elements equal to i

        for (int i=1; i<=10; i++)
            c[i]=c[i]+c[i-1];  //c[i] now contains the number of mark elements less than or equal to i

        for (int i=marks.length-1; i>=0; i--)
        {
            newmarks[c[marks[i]]-1]=marks[i];
            newnames[c[marks[i]]-1]=names[i];
            c[marks[i]]=c[marks[i]]-1;
        }        
    }
    
    /**
     * This method shows the first M students from the sorted list
     */    
    public static void show_students(String [] names, int [] marks, int m)
    {
        System.out.println("The list of " + m +" students who has the highest mark is:");
        for (int i=names.length-1; i>=names.length-m; i--)
            System.out.println("Name: "+names[i]+"  Mark: "+ marks[i]);

    }
    
    public static void main(String[]args)
    {
        int n,m;
        int [] marks;  
        String [] names;
        int [] newmarks;  
        String [] newnames;
        
        System.out.println("How many students in the list? ");
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();        
        System.out.println("Please input M: ");
        m=scanner.nextInt();               
        //Remove newline character after calling nextInt()
        String tmp=scanner.nextLine();            
        
        marks=new int[n];
        names=new String[n];
        
        for (int i=0; i<n; i++)
        {
            System.out.println("Please input the name and mark of student "+i+":");
            System.out.println("Name: ");
            names[i]=scanner.nextLine();
            System.out.println("Mark: ");            
            marks[i]=scanner.nextInt();
            //Remove newline character after calling nextInt()
            tmp=scanner.nextLine();            
        }               

        print_student_list(names,marks);
        
        newmarks=new int[n];
        newnames=new String[n];        
        sort_student_by_mark(names,marks,newnames,newmarks);
        show_students(newnames,newmarks,m);
    }    
}
