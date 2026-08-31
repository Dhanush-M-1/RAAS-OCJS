import java.util.Scanner;
public class mai{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        int a,b,c,ans=0;
        for(int i=0;i<t;i++)
        {
            a=scan.nextInt();
            b=scan.nextInt();
            c=scan.nextInt();
            while(c>=2&&b>=1)
            {
                ans+=3;c-=2;b--;
            }
            while(b>=2&&a>=1)
            {
                ans+=3;b-=2;a--;
            }
            System.out.println(ans);ans=0;
        }  
    }
}