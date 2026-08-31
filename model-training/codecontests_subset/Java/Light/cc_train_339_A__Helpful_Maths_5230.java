import java.util.*;
public class ordersum
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner (System.in);
        String s=sc.next();
        int n=(s.length()/2)+1;
        int num[]=new int[n];
        int temp=0;
        num[0]=Integer.parseInt(""+s.charAt(0));
        for(int i=1,j=1;i<s.length();i++)
        {
            if(i%2==0)
            {num[j]=Integer.parseInt(""+s.charAt(i));
                j++;}
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(num[j]>num[j+1])
                {   temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        String ns="";
        for(int i=0;i<n-1;i++)
        {
            ns=ns+Integer.toString(num[i])+"+";
        }
            ns=ns+Integer.toString(num[n-1]);
            System.out.print(ns);
            
                    
    }
}
