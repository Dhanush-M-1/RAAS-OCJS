import java.util.*;
public class MulDiv {
    public static void main(String[] args)
    {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        for(int i=0;i<t;i++)
        {
            int co=0,count=1;
            int n=obj.nextInt();
            do
            {
                if(n==1)
                {
                    break;
                }
                else if(n%6==0)
                {
                    n=n/6;
                    count=1;
                }
                else
                {
                    if(count>3)
                    {
                        count=0;
                        break;
                    }
                    n=n*2;
                    count++;
                }
                co++;
            }while(count!=0);
            if(count==0)
            {
                System.out.println("-1");
            }
            else
            {
                System.out.println(co);
            }
        }
    }
}
