import java.util.Scanner;
public class Xorn 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n,d,k=-1,m=0,j;
        int o[]=new int[3];
        n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
          String s=sc.nextLine();
          d=s.length();
          for( j=0;j<d;j++)
           {
             
             if(s.charAt(j)==' ')
              {
                o[++k]=Integer.parseInt(s.substring(m,j));
                m=j+1;
               
              }
            }
           o[2]=Integer.parseInt(s.substring(m,j));
         if(o[2]%3==0)
            System.out.println(o[0]);
        else if(o[2]%3==1)
            System.out.println(o[1]);
        else
            System.out.println(o[0]^o[1]);
        k=-1;
        m=0;
        }
    }
}