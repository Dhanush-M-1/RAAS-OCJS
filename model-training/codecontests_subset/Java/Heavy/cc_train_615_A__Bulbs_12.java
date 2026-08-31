import java.util.Scanner;


public class Bulb {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int q[]=new int[10010];
        int t=0,r=0;
        for(int i=0;i<n;i++)
        {
            int a=s.nextInt();
            for(int j=t;j<r+a;j++,t++)
            {
                q[t]=s.nextInt();
        
            }
            r=t;
            //System.out.println("t:"+t);
        }
        int c[]=new int[101];
        int k=0;
        while(q[k]!=0)
        {
            c[q[k]]++;
            k++;
        }
        //for(int i=0;i<10;i++)
            //System.out.println(q[i]);
        //for(int i=0;i<10;i++)
            //System.out.println(c[i]);
        int f=0;
        for(int i=1;i<=m;i++)
        {
            if(c[i]==0)
                {
                    System.out.println("NO");
                    f=1;
                    break;
                }
        }
        
        if(f==0)
            System.out.println("YES");
    }

}
