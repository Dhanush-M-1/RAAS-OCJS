import java.util.Arrays;
import java.util.Scanner;

public class CF338A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int []x=new int[n];
        int [][]y=new int[105][105];
        int []h=new int[m];
        Arrays.fill(h, 0);
        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
            for(int j=0;j<x[i];j++){
                y[i][j]=sc.nextInt();
                h[y[i][j]-1]=1;
            }
        }
        boolean judge=false;
        for(int i=0;i<m;i++){
            if(h[i]==0)
                judge=true;
        }
        if(judge)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
