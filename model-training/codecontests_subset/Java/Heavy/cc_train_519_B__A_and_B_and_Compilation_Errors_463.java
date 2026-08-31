import java.util.*;
public class Submission {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for(int i=0;i<n;i++)
        {
            int k = input.nextInt();
            sum1 += k;
        }
        for(int i=0;i<n-1;i++)
        {
            int k = input.nextInt();
            sum2 += k;
        }
        for(int i=0;i<n-2;i++)
        {
            int k = input.nextInt();
            sum3 += k;
        }
        System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);
    }
}