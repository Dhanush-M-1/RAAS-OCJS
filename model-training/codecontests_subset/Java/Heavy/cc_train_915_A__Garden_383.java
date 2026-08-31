
import java.util.Scanner;

public class A915 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int k=sc.nextInt();
        long count=0;
        int count2=1;
        for (int i=0;i<a;i++)
        {
            long b=sc.nextLong();
            if (k%b==0) {
                long nn = k / b;
                if (count2 == 1) {
                    count = nn;
                    count2--;
                } else {
                    if (count != 0 && nn < count) {
                        count = nn;
                    }

                }
            }
        }
        System.out.println(count);
    }
}
