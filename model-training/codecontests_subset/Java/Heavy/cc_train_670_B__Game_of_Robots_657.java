import java.io.*;
public class Robots
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String a[]=br.readLine().split(" ");
        int n=Integer.parseInt(a[0]);
        int k=Integer.parseInt(a[1]);
        String b[]=br.readLine().split(" ");
        int id[]=new int[n];
        for(int x=0;x<n;x++)
        {
            id[x]=Integer.parseInt(b[x]);
        }
        int t=1;
        while(true)
        {
            if(k-t>0)
                k=k-t;
            else
            {
                System.out.println(id[k-1]);
                break;
            }
            t++;
        }
    }
}