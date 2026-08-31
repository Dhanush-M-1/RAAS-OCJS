import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m=Integer.parseInt(inp[1]);
            String s = br.readLine();
            String[] in = br.readLine().split(" ");
            int[] b = new int[m];
            for(int i=0;i<m;i++)
                b[i] = Integer.parseInt(in[i]);
            int[] c = new int[26];
            int[] a = new int[n+1];
            for(int i=0;i<m;i++)
            {
                int x = b[i];
                a[0]++;
                a[x]--;
            }
            for(int i=1;i<n+1;i++)
            {
                a[i] += a[i-1];
            }
            for(int i=0;i<n;i++)
            {
                int p = s.charAt(i)-'a';
                c[p]++;
                c[p] += a[i];
            }
            for(int i=0;i<26;i++)
                bw.write(c[i]+" ");
            bw.write("\n");
        }
        bw.flush();
    }
}