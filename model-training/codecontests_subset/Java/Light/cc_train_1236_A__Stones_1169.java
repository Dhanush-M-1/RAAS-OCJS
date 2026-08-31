import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while((t--)>0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int count=0;
            while(((c/2)>=1)&&b>0)
            {
                c-=2;
                b-=1;
                count+=3;
            }
            while(a>0&&((b/2)>=1))
            {
                b-=2;
                a-=1;
                count+=3;
            }
            System.out.println(count);
        }
    }
}
