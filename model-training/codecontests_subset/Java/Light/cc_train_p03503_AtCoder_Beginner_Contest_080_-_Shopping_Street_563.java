import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int[][] F=new int[N][10];
        for(int i=0;i<N;i++){
            for(int j=0;j<10;j++){
                F[i][j]=sc.nextInt();
            }
        }
        int[][] P=new int[N][11];
        for(int i=0;i<N;i++){
            for(int j=0;j<11;j++){
                P[i][j]=sc.nextInt();
            }
        }
        
        int ans=0;
        int[] O=new int[10];
        for(int k=1;k<=1023;k++){
            int pre=0;
            for(int i=0;i<10;i++){
                O[i]=k/((int)Math.pow(2,i))%2;
            }
            int[] dup=new int[N];
            for(int i=0;i<N;i++){
                dup[i]=0;
                for(int j=0;j<10;j++){
                    dup[i]+=O[j]*F[i][j];
                }
            }
            for(int i=0;i<N;i++){
                pre+=P[i][dup[i]];
            }
            if(k==1){
                ans=pre;
            }else if(pre>ans){
                ans=pre;
            }
        }
        System.out.println(ans);
    }
}