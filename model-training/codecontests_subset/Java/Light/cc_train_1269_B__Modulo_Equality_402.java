import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CodeChef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            for (int i=0;i<n;i++)
                a[i]=sc.nextInt();
            for (int i=0;i<n;i++)
                b[i]=sc.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);
            int min=m+1,ans=0;
            for(int i=0;i<n;i++)
            {
                ans=(b[0]-a[i]+m)%m;
                boolean possible=true;
                for(int j=1;j<n;j++)
                {
                    if( (a[(i+j)%n]+ans)%m ==b[j] ) continue;
                    possible=false;
                }
                if(possible) min=Math.min(ans,min);

            }
            System.out.println(min);

        }
    }