import java.util.Scanner;
 
public class mul2
{
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int flag = 0;
            int cnt = 0;
            while (n != 1) {
                if (n >= 6 && n % 6 == 0) {
                    n = n / 6;
                    cnt++;
                } else {
                    cnt++;
                    n = n * 2;
                }
                if (cntsetbits(n) && n != 1) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("-1");
            else
                System.out.println(cnt);
        }
    }
    public static boolean cntsetbits(int n)
    {
        int cnt=0;
        while (n>0)
        {
            if((n&1)==1)
                cnt++;
            if(cnt>1)
                return false;
            n=n>>1;
        }
        return true;
    }
}