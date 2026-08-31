import java.util.Scanner;

public class Array_Sharpening
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            long a[] = new long[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextLong();
            boolean  b=true;
            int w =0;
            int mid;
            if(n%2==0)
                mid=(n/2)-1;
            else
                mid=n/2;
            int i=0;
            int j=n-1;
            while(i<mid)
            {
//            for(i=0,j=n-1;i<m;i++,j--)
                if(a[i]<w || a[j]<w){
                    b=false;
                    break;
                }
                i++;
                j--;
                w++;
            }
            if(b)
            {
                if(n%2==0)
                {
                    int p=(n/2)-1;
                    int q=n/2;
                    if((a[p]>=w && a[q]>=w+1) || (a[p]>=w+1 && a[q]>=w))
                        b=true;
                    else
                        b=false;
                }
                else{
                    int p=(n/2);
                    if(a[p]>=w) b=true;
                    else b=false;
                }
            }
            if(b) System.out.println("Yes");
            else
                System.out.println("No");
















//            SystemNo");





        }




    }
}
