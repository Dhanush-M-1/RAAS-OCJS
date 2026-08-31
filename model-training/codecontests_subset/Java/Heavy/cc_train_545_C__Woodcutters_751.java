import java.util.Scanner;

public class Woodcutters {
    public static int dp[][]=new int[100005][2];
    public static int x[]=new int[100005];
    public static int h[]=new int[100005];
    public static int MX(int a,int b){return (a>b)?a:b;}
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        while(inp.hasNext()){
            int n=inp.nextInt();
            for(int i=1;i<=n;i++){
                x[i]=inp.nextInt();
                h[i]=inp.nextInt();
            }
            x[0]=-2000000000;
            h[0]=0;
            x[n+1]=2000000004;
            dp[0][0]=dp[0][1]=0;
            for(int pos=1;pos<=n;pos++){
                for(int right=0;right<=1;right++){
                    dp[pos][right]=dp[pos-1][1];
                    if(right==1&&x[pos]+h[pos]<x[pos+1]) dp[pos][right]=MX(dp[pos][right],1+dp[pos-1][1]);
                    if(x[pos-1]+h[pos-1]<x[pos]-h[pos])dp[pos][right]=MX(dp[pos][right],1+dp[pos-1][1]);
                    else if(x[pos-1]<x[pos]-h[pos]) dp[pos][right]=MX(dp[pos][right],1+dp[pos-1][0]);
                }
            }
            System.out.println(dp[n][1]);
        }
        inp.close();
    }
}