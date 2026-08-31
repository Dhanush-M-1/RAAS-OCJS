import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int r1=Integer.parseInt(st.nextToken()),r2=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int c1=Integer.parseInt(st.nextToken()),c2=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int d1=Integer.parseInt(st.nextToken()),d2=Integer.parseInt(st.nextToken());
        int arr[][]=new int[2][2];
        int i=1,j=1,k=1,l=1;
        for(i=1;i<10;i++)
        {
            arr[0][0]=i;
            for(j=1;j<10;j++)
            {
                if(j==i)
                continue;
                arr[0][1]=j;
                for(k=1;k<10;k++)
                {
                    if(k==j||k==i)
                    continue;
                    arr[1][0]=k;
                    for(l=1;l<10;l++)
                    {
                        if(l==i||l==j||l==k)
                        continue;
                        arr[1][1]=l;
                        if(arr[0][0]+arr[0][1]==r1&&arr[1][0]+arr[1][1]==r2&&arr[0][0]+arr[1][0]==c1&&arr[0][1]+arr[1][1]==c2&&arr[0][0]+arr[1][1]==d1&&arr[0][1]+arr[1][0]==d2)
                        {
                            System.out.println(arr[0][0]+" "+arr[0][1]);
                            System.out.println(arr[1][0]+" "+arr[1][1]);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}