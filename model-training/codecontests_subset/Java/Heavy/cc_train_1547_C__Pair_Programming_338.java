
import java.util.Scanner;

public class PairProgramming {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int k=sc.nextInt();
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[m];
           int c[]=new int[n+m];
           boolean f=true;
            for (int i = 0; i < n; i++) {
                a[i]=sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i]=sc.nextInt();
            }
            int p=0,q=0,cc=0;
            for (int i = 0; i < n+m; i++) {
                if(p<n && a[p]<=k){
                    c[cc]=a[p];
                    cc++;
                    if(a[p]==0){
k++;
                    }
                    p++;
                }
                else if(q<m && b[q]<=k){
                    c[cc]=b[q];
                    cc++;
                    if(b[q]==0){
                        k++;
                    }
                    q++;
                }
                else {
                    System.out.println(-1);
                    f=false;
                    break;
                }
            }
            if(f){
            for (int i = 0; i <n+m ; i++) {
                System.out.print(c[i]+" ");
            }
    }
            System.out.println();
    }}
}
