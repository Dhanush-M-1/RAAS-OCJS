import java.util.*;

public class Test {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int count = 0;
        for(int i=0;i<=a;i+=2){
            int rem = n;
            rem = rem - i/2;
            for(int j=0;j<=b&&j<=rem;j++){
                int rem1 = rem - j;
                if(rem1%2==0&&rem1/2<=c)
                    count++;
            }
        }
        System.out.println(count);
    }
}