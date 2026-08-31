import java.util.Scanner;

public class P478A
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int summ=0;
        
        for (int x=0; x<5; x++) {
            summ += sc.nextInt();
        }
        
        if (summ % 5 == 0 && summ != 0) {
            System.out.print(summ/5);
        }
        else {
            System.out.print(-1);
        }
    }
}