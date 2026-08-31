import java.util.*;
import java.util.Arrays;
public class solve
{
    public static void main(String args[])
    {
        Scanner in= new Scanner(System.in);
       int t=in.nextInt();
       while(t!=0)
       {
           t--;
           int n=in.nextInt();
           int m=in.nextInt();
            String s=in.next();
            int p[]=new int[m];
            for(int i=0;i<m;i++)
            p[i]=in.nextInt();
            int al[]=new int[26];
            int dig[][]=new int[n][26];
            dig[0][s.charAt(0)-97]=1;
            for(int i=1;i<n;i++)
            {
                dig[i][s.charAt(i)-97]=1;
                for(int j=0;j<26;j++)
                {
                    dig[i][j]+=dig[i-1][j];
                }
            }
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<26;j++)
                {
                    al[j]=al[j]+dig[p[i]-1][j];
                }
            }
            for(int i=0;i<26;i++)
            al[i]=al[i]+dig[n-1][i];
            for(int i=0;i<26;i++)
            System.out.print(al[i]+" ");
            System.out.println();
    
       }
           
    }
    }