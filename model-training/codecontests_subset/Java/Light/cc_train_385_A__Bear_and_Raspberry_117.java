import java.util.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner sc=new Scanner(System.in);
    int i,n,c,x=0,p=0,j=0;
    n=sc.nextInt();
    c=sc.nextInt();
    int a[] =new int[n];
    for(i=0;i<n;i++)
    {
        a[i]=sc.nextInt();
    }
    for(i=0;i<n-1;i++)
    {
        if(a[i]>a[i+1]  )
        {
             
           p=a[i]-a[i+1];
           
            if(p>x)
            {
                
                x=p;
                j=i;
            }
        }
     }
    if(x-c > 0)
    {
        System.out.println(x-c);
    }
    else
    {
        System.out.println(0);
    }
    
    
    }
}
