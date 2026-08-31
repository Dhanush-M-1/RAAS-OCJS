import java.util.Scanner;
public class MultiplyDivide
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=1;x<=t;x++)
        {
            int n=sc.nextInt();
            int temp=n;
            int count=0;
            while(temp!=1)
            {
                if(temp%6==0)
                {
                    temp=temp/6;
                    count++;
                }
                else
                {
                    temp=temp*2;
                    count++;
                    if(temp%6!=0)
                    {
                        count=-1;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}