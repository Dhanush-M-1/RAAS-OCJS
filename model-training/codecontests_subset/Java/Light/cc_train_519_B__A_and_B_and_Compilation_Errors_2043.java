
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int sum=0,sum2=0,sum3=0;
        for(int i=0 ; i<count ; i++)
            sum+=in.nextInt();
        for(int i=0 ; i<count-1 ; i++)
            sum2+=in.nextInt();
        for(int i=0 ; i<count-2 ; i++)
            sum3+=in.nextInt();
        System.out.println(sum-sum2);
        System.out.println(sum2-sum3);

    }
}
