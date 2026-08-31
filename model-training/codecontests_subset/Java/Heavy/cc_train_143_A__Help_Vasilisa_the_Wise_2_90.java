import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

public class a102 {
    public static void debug(Object... obs) {
        System.out.println(Arrays.deepToString(obs));
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int r1=sc.nextInt();
        int r2=sc.nextInt();
        int c1=sc.nextInt();
        int c2=sc.nextInt();
        int d1=sc.nextInt();
        int d2=sc.nextInt();
        
        
        int[]z={1,2,3,4,5,6,7,8,9};
        
        for(int i=1;i<10;i++)
        {
            for(int j=1;j<10;j++)
            {
                if(i==j)continue;
                for(int k=1;k<10;k++)
                {
                    if(k==i)continue;
                    if(k==j)continue;
                    for(int l=1;l<10;l++)
                    {
                        if(l==i)continue;
                        if(l==j)continue;
                        if(l==k)continue;
                        
                        if(i+j==r1 && k+l==r2 && i+k==c1 && j+l==c2 && i+l==d1 && j+k==d2)
                        {
                            
                            System.out.println(i+" "+j);
                            System.out.println(k+" "+l);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
        
    }
}
