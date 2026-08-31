import java.util.Scanner;

public class FoxDividingCheese {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int twos1 = 0;
        int twos2 = 0;
        int threes1 = 0;
        int threes2 = 0;
        int fives1 = 0;
        int fives2 =0; 
        
        while(a%2 == 0)
        {
            a/=2;
            twos1++;
        }
        while(b%2 == 0)
        {
            b/=2;
            twos2++;
        }
        while(a%3 == 0)
        {
            a/=3;
            threes1++;
        }
        
        while(b%3 == 0)
        {
            b/=3;
            threes2++;
        }
        while(a%5 == 0)
        {
            a/=5;
            fives1++;
        }
        while(b%5 == 0)
        {
            b/=5;
            fives2++;
        }
        
        if(a != b)
            System.out.println(-1);
        else
        {
            System.out.println((Math.abs(twos1-twos2)+Math.abs(threes1-threes2)+Math.abs(fives1-fives2)));
        }
        
        
    }
}
