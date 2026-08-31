import java.util.Scanner;

public class p604C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int[] a=new int[n];
            int k=n/2-1;
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            while((k>=0)&&(k+1<n)&&(a[k]==a[k+1]))
                k--;
            int[] b={0,0,0};
            b[0]=1;
            while((b[0]<=k)&&(a[b[0]]==a[b[0]-1]))
                b[0]++;
            b[1]=2*b[0]<=k?b[0]+1:0;
            if(b[1]>0)
            {
                while((b[1]+b[0]<=k)&&(a[b[1]+b[0]]==a[b[1]+b[0]-1]))
                    b[1]++;
            }
            b[2]=Math.max(0,k+1-b[0]-b[1]);
            if(b[2]<=b[0]||b[1]<=b[0])
                b[0]=b[1]=b[2]=0;
            System.out.println(b[0]+" "+b[1]+" "+b[2]);
        }
    }
}
