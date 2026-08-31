import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int j = 0;j<t;j++) {
            int n = in.nextInt();
            int l[] = new int[n];
            int r[] = new int[n];
            int minR = Integer.MAX_VALUE;
            int maxL = -1;
            for(int i = 0;i<n;i++) {
                l[i] = in.nextInt();
                if(l[i]>maxL) {
                    maxL = l[i];
                }
                r[i] = in.nextInt();
                if(r[i]<minR) {
                    minR = r[i];
                }
            }
            if(maxL>minR) {
                System.out.println(maxL-minR);
            } else {
                System.out.println(0);
            }
        }
    }
}
