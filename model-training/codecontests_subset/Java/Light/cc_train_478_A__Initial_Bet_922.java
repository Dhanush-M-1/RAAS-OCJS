import java.util.Scanner;
public class cf478 {
    public  static  void main(String[] args)
    {
        int c1,c2,c3,c4,c5,r;
        Scanner sc=new Scanner(System.in);
        c1=sc.nextInt();
        c2=sc.nextInt();
        c3=sc.nextInt();
        c4=sc.nextInt();
        c5=sc.nextInt();
        int sum=c1+c2+c3+c4+c5;
        r=sum/5;
        if(sum%5==0)
        {
            if(r==0)
                System.out.print("-1\n");
            else
            System.out.print(r+"\n");
        }
        else
        {
            System.out.print("-1\n");
        }
    }
}
