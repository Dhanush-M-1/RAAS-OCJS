import java.util.*;
public class Main {

    public static void main(String[] args)
    {
        int t,a,b,n;

        Scanner sc=new Scanner(System.in);

        t=sc.nextInt();

        while(t-->0)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            n=sc.nextInt();

            switch(n%3)
            {
                case 0:System.out.println(a);
                        break;

                case 1:System.out.println(b);
                        break;

                default:System.out.println(a^b);
            }

        }
	// write your code here
    }
}
