
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int stone =0;
            if(b==0)
                System.out.println(0);
            else
            {
                if(b>= c/2) {
                    stone += (c / 2) * 2;
                    stone += (c / 2);
                    b = b - c / 2;
                }
                else
                {
                    stone += b*2;
                    stone +=b;
                    b=0;
                }
                if(a>=b/2) {
                    stone += (b / 2) * 2;
                    stone += (b / 2);
                }
                else
                {
                    stone +=a*2;
                    stone +=a;
                }
                System.out.println(stone);
            }

        }
    }
}
