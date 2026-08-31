import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1{
    public static void main(String args[])throws IOException
    {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    long ans=0;
    String s[]=br.readLine().split(" ");
    int n=Integer.parseInt(s[0]);
    int m=Integer.parseInt(s[1]);
    int a[]=new int [m+1];
    String s1[]=br.readLine().split(" ");
    for(int i=0;i<n;i++)
        a[Integer.parseInt(s1[i])]++;
    int b=0;
    for(int i=2;i<=m;i++)
        b+=a[i];
    for(int i=1;i<m;i++)
    {
        ans+=a[i]*b;
        b-=a[i+1];
        
    }
    System.out.println(ans);

br.close();
    }
    
}
