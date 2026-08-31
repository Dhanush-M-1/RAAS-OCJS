import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();
        
        long D =b*b-4*a*c;
        double sD;               
        
        if(a == 0 && b == 0 && c == 0)
        {
            System.out.println(-1);
        }
        
        else
        {    
            if(D>0 && a != 0)
            {
                sD = Math.sqrt((double)D);
                System.out.println(2);
                if((double)-(b+sD)/(2*a) < -(b-sD)/(2*a))
                {
                    System.out.println((double)-(b+sD)/(2*a));
                    System.out.println((double)-(b-sD)/(2*a));
                }
                else
                {
                    System.out.println((double)-(b-sD)/(2*a));
                    System.out.println((double)-(b+sD)/(2*a));                
                }

            }

            else if(D == 0 && a!= 0 )
            {
                System.out.println(1);
                System.out.println((double)-b/(2*a));
            }

            else if(a == 0 && b != 0)
            {
                System.out.println(1);
                System.out.println((double)-c/b);
            }

            else
            {
                System.out.println(0);
            }
    }
    }

}
