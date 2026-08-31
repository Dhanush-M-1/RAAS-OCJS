import java.io.*;
import java.util.*;

public final class codeForces
{
    static String c="abacaba";
    static  int found(String X)
    {
        int count=0;
        for(int i=0; i<X.length()-6; i++)
            if(X.substring(i,i+7).equals(c))count++;
        return count;
    }

    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        {
            int T=Integer.parseInt(in.readLine());
            while(T-->0)
            {
                StringTokenizer st;
                st=new StringTokenizer(in.readLine());
                int n=Integer.parseInt(st.nextToken());
                int m=Integer.parseInt(st.nextToken());
                int A[]=new int[n];
                int B[]=new int[m];
                Map<Integer,Integer> mpA=new HashMap<>();
                Map<Integer,Integer> mpB=new HashMap<>();
                st=new StringTokenizer(in.readLine());
                for(int i=0; i<n; i++)
                {
                    A[i]=Integer.parseInt(st.nextToken());
                    mpA.put(A[i],1);
                }
                int k=0;
                int b=0;
                st=new StringTokenizer(in.readLine());
                for(int i=0; i<m; i++)
                {
                    b=Integer.parseInt(st.nextToken());
                    if(mpA.containsKey(b))
                    {
                        k=1;
                        break;
                    }
                }
                if(k==0)
                System.out.println("NO");
                else
                {
                    System.out.println("YES");
                    System.out.println(1+" "+b);
                }

            }
        }  
    }
}

/* StringTokenizer st;
st=new StringTokenizer(in.readLine());
int n=Integer.parseInt(st.nextToken());
int q=Integer.parseInt(st.nextToken());
int c=Integer.parseInt(st.nextToken());
int A[][]=new int[n][3];
for(int i=0; i<n; i++)
{
st=new StringTokenizer(in.readLine());
A[i][0]=Integer.parseInt(st.nextToken());
A[i][1]=Integer.parseInt(st.nextToken());
A[i][2]=Integer.parseInt(st.nextToken());
}
while(q-->0)            
{
st=new StringTokenizer(in.readLine());
long t=Long.parseLong(st.nextToken());
int x1=Integer.parseInt(st.nextToken());
int y1=Integer.parseInt(st.nextToken());
int x2=Integer.parseInt(st.nextToken());
int y2=Integer.parseInt(st.nextToken());
long b=0;
for(int i=0; i<n; i++)
{
int x=A[i][0];
int y=A[i][1];

if(x>=x1 && x<=x2 && y>=y1 && y<=y2)
{
b+=(A[i][2]+t)%(c+1);
}
}
System.out.println(b);
}            
 */

