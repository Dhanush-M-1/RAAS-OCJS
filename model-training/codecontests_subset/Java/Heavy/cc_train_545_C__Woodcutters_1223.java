import java.io.*;
import java.util.*;
public class Solution
{
    static int H[];
    static int X[];
    static int N;
    static long dp[][];
    
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j,k;
        N=sc.nextInt();
        X=new int[N+1];
        H=new int[N+1];
        dp=new long[N+1][4];
        for(i=1;i<=N;i++)
        {
            X[i]=sc.nextInt();
            H[i]=sc.nextInt();
        }
        
        for(i=0;i<=N;i++)
        Arrays.fill(dp[i],-1);
        
        System.out.println(find(1,0,0));
    }
    
    public static long find(int id,int state,int dist)
    {
        //  state--> 1>> left , 2>> stand still , 3>> right
        
        if(id==N+1)
        return 0;
        
        if(dp[id][state]!=-1)
        return dp[id][state];
        
        long A,B,C;
        A=B=C=0;
        
        if(id==1||(X[id]-H[id]>X[id-1]&&X[id]-H[id]>dist))
        A=1+find(id+1,1,X[id]);
        else 
        A=find(id+1,2,X[id]);
        
        B=find(id+1,2,X[id]);
        
        if(id==N||(X[id]+H[id]<X[id+1]))
        C=1+find(id+1,3,X[id]+H[id]);
        else 
        C=find(id+1,2,X[id]);
        
        return dp[id][state]=Math.max(A,Math.max(B,C));
    }
}