import java.io.*;
public class Apple
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String ar[]=br.readLine().split(" ");
        int a[]=new int[n];
        int sum=0;
        int c_200=0,c_100=0;
        for(int x=0;x<n;x++)
        {
            a[x]=Integer.parseInt(ar[x]);
            if(a[x]==100)
                c_100++;
            else
                c_200++;
            sum+=a[x];
        }
        int d=sum/100;
        if(d%2==0 && n!=1)
        {
            int half=sum/2;
            boolean ans=false;
            for(int x=0;x<=c_200;x++)
            {
                if(200*x<=half && half-200*x<=c_100*100)
                    ans=true;
            }
            if(ans==true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        else
        {
            System.out.println("NO");
        }
    }
}