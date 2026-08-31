
import java.util.Scanner;


public class New_Year_Candles_379A {
    public static void main(String[] args) {
        Scanner In=new Scanner(System.in);
        int a,b,d,sum=0;
        
        a=In.nextInt();
        b=In.nextInt();
        sum=a;
        while(a>=b){
            d=a/b;
            a=d+(a%b);
            sum=sum+d;
        }
        System.out.println(sum);
    }
  
}
