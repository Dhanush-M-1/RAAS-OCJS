import java.util.Scanner;
public class maestro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s=3;
        for (int i=0;i<n;i++){
            int t = sc.nextInt();
            if (t==s) {
                System.out.println("NO");
                return;
            }
            if (t==1&&s==3) s=2;
            else if (t==1&&s==2) s=3;
            else if (t==2&&s==1) s=3;
            else if (t==2&&s==3) s=1;
            else if (t==3&&s==1) s=2;
            else if (t==3&&s==2) s=1;
        }
        System.out.println("YES");
    }
}