import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        String s1, s2;
        s1 = sc.next();
        s2 = sc.next();
        System.out.print(s1 + " ");
        System.out.println(s2);
        int t;
        t = sc.nextInt();
        while (t > 0)
        {
            String s3 = sc.next();
            if (s3.equals(s1))
            {
                s1 = sc.next();
            }
            else
            {
                s2 = sc.next();
            }
            System.out.print(s1 + " ");
            System.out.println(s2);
            
            t--;
        }
	}
}