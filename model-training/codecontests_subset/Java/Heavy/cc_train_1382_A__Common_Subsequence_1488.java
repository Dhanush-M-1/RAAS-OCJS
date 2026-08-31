import java.util.Arrays;
import java.util.Scanner;

public class A658 {
    public static void main(String[] args)
    {
        int t;
        Scanner s=new Scanner(System.in);
        t=s.nextInt();
        while(t-->0)
        {
            int m;
            int n;
            int i,j;
            m=s.nextInt();
            n=s.nextInt();
            int a[]=new int[m];
            int b[]=new int[n];
            boolean flag=false;
            for( i=0;i<m;i++)
                a[i]=s.nextInt();
            for( i=0;i<n;i++)
                b[i]=s.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);
            outer:
            for(i=0;i<m;i++)
                for(j=0;j<n;j++)
                    if(a[i]==b[j]) {
                        System.out.println("YES");
                        System.out.println(1 + " " + a[i]);
                        flag = true;
                        break outer;
                    }
                        if(flag==false)
                            System.out.println("NO");

                    }


        }
    }

