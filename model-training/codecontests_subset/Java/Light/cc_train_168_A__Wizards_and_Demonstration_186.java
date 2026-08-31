import java.util.*;

public class Main{

public static void main(String[] args)
{
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int x = scan.nextInt();
    int y = scan.nextInt();
    if (y*n%100==0)
    {
        System.out.println(Math.max(((y*n/100)-x),0));
    }
    else
    {
        System.out.println(Math.max(((y*n/100)-x+1),0));
    }
    
}
}