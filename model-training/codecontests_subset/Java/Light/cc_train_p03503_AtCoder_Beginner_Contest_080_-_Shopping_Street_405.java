import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int F[][]=new int[N][10];
        int P[][]=new int[N][11];
        int result[]=new int[N];
        int ans=-(1<<30),tmp=0;
        Arrays.fill(result,0);
        for(int i=0;i<N;i++){
            for(int j=0;j<10;j++){
                F[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<11;j++){
                P[i][j]=sc.nextInt();
            }
        }
        for(int i=1;i<(1<<10);i++){
            int c=0;
            for(int j=0;j<N;j++){
                int cc=0;
                for(int k=0;k<10;k++){
                    if(((i>>k)&1)==1&&F[j][k]==1){
                        cc++;
                    }
                }
                c+=P[j][cc];
            }
            ans=Math.max(ans, c);
        }
        System.out.println(ans);
    }
}