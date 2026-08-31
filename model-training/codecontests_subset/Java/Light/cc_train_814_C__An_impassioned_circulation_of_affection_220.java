
import java.io.*;
import java.util.*;
public class koyomity 
{
    
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        int dp[][]=new int[26][n+1];
        for(int i=0;i<26;i++)
        {
            char ch=(char)(i+97);
            for(int j=1;j<=n;j++)
            {
                int cou=0,r=0,l=0,max=0,k=0;
                while(k<n)
                {
                    if(cou<=j)
                    {
                        if(s.charAt(k)!=(ch))
                            cou++;
                        k++;
                    }
                    if(cou>j)
                    {
                        if(s.charAt(l)!=ch)
                            cou--;
                        l++;
                    }
                    max=(int)(Math.max(max,k-l));   
                }
                dp[i][j]=max;
            }
        }
        int q=Integer.parseInt(br.readLine());
        for(int z=1;z<=q;z++)
        {
            String st[]=br.readLine().trim().split(" ");
            int m=Integer.parseInt(st[0]);
            char cha=st[1].charAt(0);
            System.out.println(dp[cha-97][m]);
        }
    }
}
