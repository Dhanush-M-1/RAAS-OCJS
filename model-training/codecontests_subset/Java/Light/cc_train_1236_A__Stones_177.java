

////////////////////---------------------------SHUBHAM CHAUDHARI-------------------------------///////////////////////


import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while (t-->0)
        {
            int A[]=new int[3];
            for(int i=0;i<3;i++)
            {
                A[i]=in.nextInt();
            }
            int max=0;
            while (A[2]>=2&&A[1]>=1)
            {
                max+=3;
                A[1]-=1;
                A[2]-=2;
            }
            while (A[1]>=2&&A[0]>=1)
            {
                max+=3;
                A[1]-=2;
                A[0]-=1;
            }
            System.out.println(max);
        }
        

    }
    static long hcf(long a,long b)
    {
        if(b==0)
            return a;
        return hcf(b,a%b);
    }

}



