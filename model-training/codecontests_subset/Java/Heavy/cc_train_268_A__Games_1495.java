import java.util.*;
public class A_Games {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int n = in.nextInt();
        int[][] a = new int[n][2];
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j]=in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // System.out.println("i= "+i+" j= "+j);
//                System.out.println("A . = "+a[i][0]);
//                System.out.println("B . = "+a[j][1]);
//                System.out.println("*****************");
               
                if(a[i][0]==a[j][1]){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    
}
