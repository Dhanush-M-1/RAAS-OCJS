import java.util.*;
public class tr2
{
    public static void main(String args[])
    {
        
    int t;
    Scanner sc=new Scanner(System.in);
    t=sc.nextInt();
    
    while(t!=0)
    {
        int n,arr[],c=0,sum=0,k=0;
        n=sc.nextInt();
        
        arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        
        for(int i=0;i<n;i++)
{
    k=k+1;
    sum=arr[i]+arr[k];
    for(int j=n-1;j>k;j--)
    {
        if(sum<arr[j] || sum==arr[j])
        {
            System.out.print(i+1);
          System.out.print(" ");
            System.out.print(k+1);
           System.out.print(" ");
            System.out.println(j+1);
            c=1;
            break;
        }
    }
    break;}
    if(c==0)
    System.out.println(-1);
    t=t-1;
    
}
}
}    
    
            
