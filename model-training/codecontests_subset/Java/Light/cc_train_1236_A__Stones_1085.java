import java.util.Scanner;

public class _1236A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int cnt1 = 0,cnt2=0,d=b;
            while (b>=1 && c>=2) {
                c -= 2;
                b -= 1;
                cnt2 += 3;
            }
            while(a>=1 && b>=2) {
                a-=1;
                b-=2;
                cnt1+=3;
            }
            System.out.println(cnt1+cnt2);
        }
    }
}
