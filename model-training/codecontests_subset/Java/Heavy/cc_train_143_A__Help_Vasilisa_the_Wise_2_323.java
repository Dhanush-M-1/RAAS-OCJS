import java.util.Scanner;

public class HelpVasilisaTheWise2 {
    public static void main(String[] args) {
        int r1,r2,c1,c2,d1,d2;
        int a=0,b=0,c=0,d=0;
        Scanner sc=new Scanner(System.in);
        r1 = sc.nextInt();
        r2 =sc.nextInt();
        c1 =sc.nextInt();
        c2=sc.nextInt();
        d1=sc.nextInt();
        d2=sc.nextInt();
        int i=1,count=0;
        while(i<=9)
        {
            a=i;
            d=d1-a;
            b=r1-a;
            c=r2-d;
            if (b+c==d2 && a+c==c1 && b+d==c2)
            {
                i+=10;
            }
            else
                i++;
            if (i==9)
            {
                if (b+c!=d2 && a+c!=c1 && b+d!=c2 )
            {
                count=-1;
            }
            }
        }
        if (count!=-1)
        {
            if ((a==0 || a>=10 || b==0 || b>=10 || c==0 || c>=10 || d==0 || d>=10))
                System.out.println(-1);
            else if  (a==b || a==c || a==d|| b==c || b==d || c==d)
                System.out.println(-1);
            else{
               System.out.println(a+" "+b);
               System.out.println(c+" "+d);
            }
        }
        else
            System.out.println(count);
    }
}