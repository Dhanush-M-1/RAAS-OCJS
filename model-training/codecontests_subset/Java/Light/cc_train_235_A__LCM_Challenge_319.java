import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{

    public static long gcd(long a,long b){
        return a%b==0?b:gcd(b,a%b);
    }

    public static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner =new Scanner(System.in);
//        Scanner scanner =new Scanner(new FileInputStream("src/in.txt"));


        long n = scanner.nextLong();

        if(n<3){
            System.out.println(n);
        }
        else if(n%2==1){
            System.out.println(n*(n-1)*(n-2));
        }else{
            long ans=0;
            for(long i=n-2;i>=1;i--){
                ans=Math.max(ans,lcm(n*(n-1),i));
                if(n*(n-1)*i<ans){
                    break;
                }
            }
            for(long i=n-3;i>=1;i--){
                ans=Math.max(ans,lcm((n-1)*(n-2),i));
                if((n-1)*(n-2)*i<ans){
                    break;
                }
            }
            System.out.println(ans);

        }






    }
}