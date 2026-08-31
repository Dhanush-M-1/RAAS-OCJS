import java.util.*;
import java.io.*;
public class main{
    public static void main(String  args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String[] s=br.readLine().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            String[] s1=br.readLine().split(" ");
            String[] s2=br.readLine().split(" ");
            Set<Integer> set1=new HashSet();
            Set<Integer> set2=new HashSet();
            for(int i=0;i<n;i++)
            {
                int x=Integer.parseInt(s1[i]);
                set1.add(x);
            }
            int ans=0;
            boolean f=false;
            for(int i=0;i<m;i++)
            {
                int x=Integer.parseInt(s2[i]);
                if(set1.contains(x))
                {
                 ans=x;
                    f=true;
                    break;
                }
            }
            if(f)
            {
                System.out.println("YES");
                System.out.println("1"+" "+ans);
            }else{
                System.out.println("NO");
            }
        }
       
 
    }
}
