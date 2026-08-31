import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args)throws IOException {
		InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        int t=Integer.parseInt(in.readLine());
        int z;
        for(z=0;z<t;z++)
        {
            String str=in.readLine();
            String line[]=str.trim().split(" ");
            int n=Integer.parseInt(line[0]);
            int m=Integer.parseInt(line[1]);
            String st=in.readLine();
            int i,j;
            String s=in.readLine();
            String l[]=s.trim().split(" ");
            int p[]=new int[m];
            for(i=0;i<m;i++)
            {
                p[i]=Integer.parseInt(l[i]);
            }
            int check[]=new int[n+1];
            check[0]+=m;
            for(i=0;i<m;i++)
            {
                check[p[i]]--;
            }
            for(i=1;i<n;i++)
            {
                check[i]+=check[i-1];
            }
            for(i=0;i<n;i++)
            check[i]+=1;
            long ans[]=new long[26];
            for(i=0;i<n;i++)
            {
                char flag=st.charAt(i);
                ans[flag-97]+=check[i];
            }
            for(i=0;i<26;i++)
            System.out.print(ans[i]+" ");
            System.out.println("");
        }
	}
}
