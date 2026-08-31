
import java.util.Scanner;

public class HelpVasilisaTheWise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1,r2,c1,c2,d1,d2;
        r1=sc.nextInt();
        r2=sc.nextInt();
        c1=sc.nextInt();
        c2=sc.nextInt();
        d1=sc.nextInt();
        d2=sc.nextInt();
        for(int i=1;i<=9;i++)
        {
            for(int j=1;j<=9;j++)
            {
                for(int k=1;k<=9;k++)
                {
                    for(int l=1;l<=9;l++)
                    {
                        if((i+j==r1)&&(k+l==r2)&&(i+k==c1)&&(j+l==c2)&&(i+l==d1)&&(j+k==d2)&&(i!=j)&&(i!=k)&&(i!=l)&&(j!=k)&&(j!=l)&&(k!=l))
                        {
                            System.out.println(i+" "+j);
                            System.out.println(k+" "+l);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("-1");
    }
}
