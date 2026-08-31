//package pkg379a.pkgnew.year.candles;
import java.util.Scanner;
public class NewYearCandles 
{
    public static void main(String[] args)    
    {
        int a,b;
        int sum,tukra;
        
        Scanner in=new Scanner(System.in);
        
        a=in.nextInt();
        b=in.nextInt();
        
        sum=a;
        tukra=a;
        
        while(tukra>=b)
        {
            a=tukra/b;
            sum+=a;
            tukra=(tukra%b)+a;
        }
        
        System.out.print(sum);
    }
    
}
