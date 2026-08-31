import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
public class MyClass {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int t=sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(),
                m=sc.nextInt();
            String s=sc.next();
            s=s.trim();
            int[] p=new int[m];
            for(int i=0;i<m;i++)
                p[i]=sc.nextInt();
                int[][] dp=new int[26][n];
                for(int i=0;i<26;i++) {
                    for(int j=0;j<n;j++) {
                        if(j!=0)
                            dp[i][j]=dp[i][j-1];
                        if((s.charAt(j)-'a')==i)
                            dp[i][j]++;
                    }
                }
            int[] ct=new int[26];
            for(int i=0;i<m;i++) {
                for(int j=0;j<26;j++)
                    ct[j]+=dp[j][p[i]-1];
            }
            for(int j=0;j<n;j++)
                ct[s.charAt(j)-'a']++;
            for(int i=0;i<25;i++)
                pw.print(ct[i]+" ");
            pw.println(ct[25]);
        }
        pw.close();
    }
}