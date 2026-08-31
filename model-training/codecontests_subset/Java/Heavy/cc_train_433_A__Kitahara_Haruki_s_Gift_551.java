import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int[] no=new int[n];
int sum=0;
int [] val=new int[2];
int h1,h2;
for(int i1=0;i1<n;i1++)
{
    no[i1]=in.nextInt();
    sum+=no[i1];
    if(no[i1]==100)
        val[0]++;
    else
        val[1]++;
}
Arrays.sort(no);
h1=sum/2;
h2=sum/2;
if(sum%2!=0)
    System.out.println("NO");
else
{
    for(int i=n-1;i>=0;i--)
    {
        if(no[i]<=h1)
        {
            h1-=no[i];
            no[i]=0;
        }
    }
    for(int i=n-1;i>=0;i--)
    {
        if(no[i]<=h2)
        {
            h2-=no[i];
            no[i]=0;
        }
    }
    
}
if(h1==0&&h2==0)
{
System.out.println("YES");  
}
else
    System.out.println("NO");   
in.close();
    }

}
