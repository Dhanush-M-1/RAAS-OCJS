import java.util.Scanner;

public class cf1382A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j=0; j<t; j++) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int m = sc.nextInt();
            int b[] = new int[m];
            int pos[] = new int[1001]; //to track
            boolean found = false;
            int s = 0; //first num in subsequence
            for(int i=0; i<n; i++) {
                a[i] = sc.nextInt();
                pos[a[i]]++;
            }

            for(int i=0; i<m; i++) {
                b[i] = sc.nextInt();
                if(pos[b[i]] > 0) {
                    found = true;
                    s = b[i];
                }
            }

            if(found) {
                System.out.println("YES");
                System.out.println(1 + " " + s);
            }
            else
                System.out.println("NO");
        }
        sc.close();
    }
}