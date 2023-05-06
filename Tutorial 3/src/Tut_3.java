import java.util.Scanner;
public class Tut_3 {
    public static double RecPow(double x, int n)
    {
        //Base case
        if (n==0)
            return 1;
        if (n==1)
            return x;

        if (n % 2 == 0)
            return RecPow(x*x,n/2);
        else
            return x*RecPow(x*x,n/2);

    }
    public static void main(String[]args)
    {
        int n;
        double x;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of x: ");
        x=scanner.nextDouble();

        System.out.println("Please enter the degree n: ");
        n=scanner.nextInt();

        System.out.println("The value of (" + x + ")^" + n + " is: " + RecPow(x,n));
    }
}
