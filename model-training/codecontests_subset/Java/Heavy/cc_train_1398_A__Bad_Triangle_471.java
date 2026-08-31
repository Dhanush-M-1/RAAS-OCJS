import java.util.*;
public class Main {
    static void rev(int []a)
    {
        int i=0,j=a.length-1;
        while(i<j)
        {
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
            i++;j--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
                int N=sc.nextInt();
                int[]a=new int[N];
                for(int i=0;i<N;i++)
                    a[i]=sc.nextInt();
                if(a[0]+a[1]<=a[N-1])
                    System.out.println(1+" "+2+" "+N);
                else
                    System.out.println(-1);
            }


        }

    }



