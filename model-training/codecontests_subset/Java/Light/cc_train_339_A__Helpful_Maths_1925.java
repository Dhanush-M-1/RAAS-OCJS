import java.util.*;
public class test
{
   public static void main(String args[])
   {
       Scanner sc=new Scanner(System.in);
       String s=sc.next();
       int i;
       char a[]=s.toCharArray();
       int l=s.length();
       //for(i=0;i<l;i++)
      //  System.out.print(a[i]);
       int c[]=new int[3];
       for(i=0;i<l;i++)
       {
        if(a[i]=='1')
         c[0]++;
        if(a[i]=='2')
         c[1]++;
        if(a[i]=='3')
         c[2]++;
       }
       if(c[0]==1 &&l==1)
        System.out.println("1");
       else if(c[1]==0 &&c[2]==0 &&c[0]>1) 
       {
        for(i=0;i<c[0]-1;i++)
         System.out.print("1+");
         System.out.print("1");
       }
       else
       {
        for(i=0;i<c[0];i++)
         System.out.print("1+");   
       }
      if(c[1]==1 &&l==1)
        System.out.println("2");
       else if(c[2]==0 && c[1]>0)
       {
       for(i=0;i<c[1]-1;i++)
        System.out.print("2+");
        System.out.print("2");
       }
       else
        for(i=0;i<c[1];i++)
         System.out.print("2+");
      if(c[2]==1 &&l==1)
        System.out.println("3");
       else
       for(i=0;i<c[2];i++)
       if(c[2]==1||i==c[2]-1)
        System.out.print("3");
        else
        System.out.print("3+");
        
    }
}