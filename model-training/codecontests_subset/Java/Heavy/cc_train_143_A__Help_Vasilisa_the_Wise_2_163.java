import java.util.*;
public class Main
{
	 public static void main(String args[])
    {
        Scanner in  = new Scanner(System.in);
        int r1 = in.nextInt();
        int r2 = in.nextInt();
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        int d1 = in.nextInt();
        int d2 = in.nextInt();
        int flag=0;
        for(int i=1 ; i<=9 ; i++)
        {
            for(int j=1 ; j<=9 ; j++)
            {
                for(int k=1 ; k<=9 ; k++)
                {
                    for(int l=1 ; l<=9 ; l++)
                    {
                        if(i!=j&&i!=k&&i!=l&&j!=k&&j!=l&&k!=l)
                        {
                            if(r1==(i+j)&&r2==(k+l)&&c1==(i+k)&&c2==(j+l)&&d1==(i+l)&&d2==(j+k))
                            {
                                System.out.println(i+" "+j);
                                System.out.println(k+" "+l);
                                flag=1;
                            }
                            if(flag==1) break;
                        }
                    }
                    if(flag==1) break;
                }
                if(flag==1) break;
            }
            if(flag==1) break;
        }
        if(flag==0) System.out.println("-1");
        }
}
