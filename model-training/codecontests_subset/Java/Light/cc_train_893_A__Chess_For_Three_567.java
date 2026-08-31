import java.util.*;
public class me
{
   public static void main(String[] args)
   {
      Scanner br=new Scanner(System.in);
     int n=br.nextInt();
     int flag1=1;
     int flag2=1;
     int flag3=0;
     int res=0;
     for(int i=0;i<n;i++)
     {
        int win=br.nextInt();
        if(win==1 && flag1==1 && flag2==1)
        {
           flag2=0;
           flag3=1;
        }else if(win==1 && flag1==1 && flag3==1)
        {
           flag3=0;
           flag2=1;
        }else if(win==2 && flag2==1 && flag3==1)
        {
           flag3=0;
           flag1=1;
        }else if(win==2 && flag2==1 && flag1==1)
        {
           flag1=0;
           flag3=1;
        }else if(win==3 && flag3==1 && flag1==1)
        {
           flag1=0;
           flag2=1;
        }else if(win==3 && flag3==1 && flag2==1)
        {
           flag2=0;
           flag1=1;
        }else
        {
           res=1;
           break;
        }
     }if(res==0)
     System.out.println("YES");
     else
     System.out.println("NO");
   }
}