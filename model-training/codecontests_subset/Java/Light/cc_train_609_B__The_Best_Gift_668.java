import java.util.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {

Scanner s = new Scanner (System.in);

int n=s.nextInt(),m=s.nextInt();

int arr[] = new int[m];
int vals[] = new int[n];
for (int i=0;i<n;i++){
vals[i]=s.nextInt()-1;
    arr[vals[i]]++;
}
long ans=0;
for (int i=0;i<n;i++)
{
long sum=n;
sum=sum-i;
sum=sum-arr[vals[i]];
ans = ans+ sum;
arr[vals[i]]--;
}
System.out.println(ans);

    
s.close();

    }
    
}