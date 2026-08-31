import java.io.*;
import java.util.*;

public class prob2
{

    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int t=Integer.parseInt(st.nextToken());
        for(int e=1;e<=t;e++)
        {
            br.readLine();
            st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int[] arr=new int[n];
            int[] arr2=new int[m];
            ArrayList<Integer> ans=new ArrayList<>();
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++)
                arr[i]=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++)
                arr2[i]=Integer.parseInt(st.nextToken());
            int index=0,index2=0,flag=0;
            for(int i=1;i<=n+m;i++)
            {
                if(index<n && arr[index]==0)
                {
                    ans.add(0);
                    k++;
                    index++;
                }
                else if(index2<m && arr2[index2]==0)
                {
                    ans.add(0);
                    k++;
                    index2++;
                }
                else if(index<n && arr[index]<=k && arr[index]!=0)
                {
                    ans.add(arr[index]);
                    index++;
                }
                else if(index2<m && arr2[index2]<=k && arr2[index2]!=0)
                {
                    ans.add(arr2[index2]);
                    index2++;
                }
                else
                {
                    flag=-1;
                    break;
                }
            }
            if(flag==-1)
                System.out.println("-1");
            else
            {
                for(Integer i:ans) System.out.print(i+" ");
                System.out.println();
            }
        }
    }
}