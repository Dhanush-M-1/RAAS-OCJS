import java.util.*;
public class _545c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        for(int i=0;i<n;i++) {
            int x = sc.nextInt();
            int h = sc.nextInt();
            mat[i][0] = x;
            mat[i][1] = h;
        }
       long left=0,right=0,c=0;
        for(int i=1;i<n-1;i++) {
            left = mat[i][0] - mat[i][1];
            right = mat[i][0] + mat[i][1];

            if(left>mat[i-1][0])
                c++;
            else if(right<mat[i+1][0]){
                 c++;
                 mat[i][0]+=mat[i][1];
            }
        }
        if(n>1)
            c++;
        System.out.println(c+1);
    }
}
