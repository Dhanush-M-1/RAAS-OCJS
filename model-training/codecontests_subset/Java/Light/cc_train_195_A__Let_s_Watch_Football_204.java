import java.util.*;

public class LetsWatchFootball195A
{
    public static void main(String[] args) 
    {
        // Set up scanner
        Scanner sc = new Scanner(System.in); 
        // System.out.println("Enter a");
        int a = sc.nextInt();
        // System.out.println("Enter b");
        int b = sc.nextInt();
        // System.out.println("Enter c");
        int c = sc.nextInt();
        
        int needed = c * (a-b);
        if (needed%b == 0)
        {
            System.out.println(needed/b);
        }
        else
        {
            System.out.println(needed/b + 1);
        }
    }
}