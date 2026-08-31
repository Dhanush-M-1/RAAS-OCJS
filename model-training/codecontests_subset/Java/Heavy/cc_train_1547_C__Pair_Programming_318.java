import java.util.*;

public class B{
    static void sort(int[] A){

        int n = A.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            int tmp = A[i];
            int randomPos = i + rnd.nextInt(n-i);
            A[i] = A[randomPos];
            A[randomPos] = tmp;
        }
        Arrays.sort(A);
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        long mod=1000000007l;
        int cases=sc.nextInt();

        while(cases>0)
        {
            cases--;
            int k=sc.nextInt();
            int m=sc.nextInt();
            int n=sc.nextInt();
            int a[]=new int[m];
            int b[]=new int[n];

            for(int j=0;j<m;j++)
            {
                a[j]=sc.nextInt();
            }

            for(int j=0;j<n;j++)
            {
                b[j]=sc.nextInt();
            }

            boolean pos=true;
            StringBuilder ans=new StringBuilder();
            int c1=0;
            int c2=0;
            for(int j=0;j<n+m;j++)
            {
                int a1=1000;
                int b1=1000;
                if(c1<m)
                {
                    a1=a[c1];
                }

                if(c2<n)
                {
                    b1=b[c2];
                }

                if(a1<b1)
                {
                    if(k<a1)
                    {
                        pos=false;
                        break;
                    }
                    else if(a1==0)
                    {
                        ans.append(0+" ");
                        c1++;
                        k++;
                    }
                    else
                    {
                        ans.append(a1+" ");
                        c1++;
                    }
                }
                else
                {
                    if(k<b1)
                    {
                        pos=false;
                        break;
                    }
                    else if(b1==0)
                    {
                        ans.append(0+" ");
                        c2++;
                        k++;
                    }
                    else
                    {
                        ans.append(b1+" ");
                        c2++;
                    }
                }
            }

            if(pos)
            {
                System.out.println(ans);
            }
            else
            {
                System.out.println(-1);
            }


        }

    }
}
