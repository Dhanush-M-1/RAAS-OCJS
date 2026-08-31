import java.util.Scanner;
public class LCMChallenge {
public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        long n=input.nextLong();
        long b;
        if(n>=3){
          if(n%2==0){
            if(n%3==0){
              n-=1;
              b=((n-1)*(n-2))/gcd(n-1,n-2);
                System.out.println((n*b)/gcd(n, b));
            }   
            else{
                b=((n-1)*(n-3))/gcd(n-1,n-3);
                System.out.println((n*b)/gcd(n, b));
                
            }
          }
          else{
              b=((n-1)*(n-2))/gcd(n-1,n-2);
              System.out.println((n*b)/gcd(n, b));

          }
          }
        
     else if(n==2)
            System.out.println(2);
        else
            System.out.println(1);
}

public static long gcd(long a, long b)
{
    while (b > 0)
    { 
        long temp = b;
        b = a % b; 
        a = temp;
      }
    return a;
}
}