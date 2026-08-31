import java.util.*; 
import java.io.*; 
import java.lang.Math; 
public class Main
{ 
  
    public static void main(String[] args)
{ 
     Scanner in=new Scanner(System.in); 
    int i,n,m,t,y,z,j,k=0,c=0;
    t=in.nextInt();
    for(j=0;j<t;j++)
    {
        c=0;
        n=in.nextInt();
        m=in.nextInt();
        int a[] = new int[n];
        for(i=0;i<n;i++)
    {
        a[i]=in.nextInt();
    }
    ArrayList<Integer> b= new ArrayList<Integer>(m); 
    for(i=0;i<m;i++)
    {
        b.add(in.nextInt());
    }
    for(i=0;i<n;i++)
    {
        if(b.contains(a[i])==true)
        {
            c=1;
            k=a[i];
        }
    }
        if(c==1)
        {
            System.out.println("YES");
            System.out.print("1 "+k);
            System.out.println();
        }
        else
        System.out.println("NO");
    }
} 
}