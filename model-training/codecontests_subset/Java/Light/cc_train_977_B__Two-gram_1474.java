import java.util.*;
public class prg
{
    
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
       int n=Integer.valueOf(sc.next());
       String s=sc.next();
       int count[]=new int[n];
       for(int i=0;i<n;i++)
       count[i]=0;
       
       for(int i=0;i<n-1;i++)
       {
           String a=s.substring(i,i+2);
           
           for(int j=i+1;j<n-1;j++)
           if(s.substring(j,j+2).equals(a))
           count[i]++;
}

int max=0;
for(int i=2;i<n;i++)
if(count[i]>count[max])
max=i;

System.out.println(s.substring(max,max+2));
}
}
           
       