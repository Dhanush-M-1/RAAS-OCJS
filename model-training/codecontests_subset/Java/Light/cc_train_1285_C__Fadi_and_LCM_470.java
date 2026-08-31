import java.util.Scanner;


/**
 *
 * @author DELL
 */
public class Codechef {
   static long gcd(long a,long b)
    {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
   static long lcm(long a,long b)
    {
       return (a*b)/gcd(a, b);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long x=sc.nextLong();
        long smallest=x;
        for(long i=1;i<Math.sqrt(x);i++)
        {
            if(x%i==0&&lcm(x/i,i)==x)
            {
                smallest=i;
          }
        }
        System.out.println(smallest +" "+x/smallest);
    }

}
