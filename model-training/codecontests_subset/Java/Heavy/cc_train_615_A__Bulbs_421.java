import java.util.Scanner;

/**
 * Created by pantism on 08/01/2016.
 */
public class Bulbs {
    public static void main(String[] args) {
        // Use the Scanner class
        Scanner sc = new Scanner(System.in);

        int i, j;
        int n = sc.nextInt();
        int m = sc.nextInt();

        int c[] = new int[m];
        for(i=0;i<m;i++) c[i]=0;

        for(i=0;i<n;i++) {
            int nr = sc.nextInt();
            for(j=0;j<nr;j++) {
                int q = sc.nextInt();
                c[q-1]=1;
            }
            //for(j=0;j<m;j++) System.out.print(c[j]);
            //System.out.println();
        }

        boolean result=true;
        for(i=0;i<m;i++) if(c[i]==0) result=false;
        if(result) System.out.println("YES");
        else System.out.println("NO");
    }
}


/*
3 4
2 1 4
3 1 3 1
1 2
 */
