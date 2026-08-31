import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
       // int t=Integer.parseInt(br.readLine());
    //    while(t-->0)
     //   {
            //int n=Integer.parseInt(br.readLine());
            
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            //int n=Integer.parseInt(str[2]);
            
            int arr[][]=new int[n][3];
            for(int i=0;i<n;i++)
            {
                str=br.readLine().split(" ");
                arr[i][0]=Integer.parseInt(str[0]);
                arr[i][1]=Integer.parseInt(str[1]);
                arr[i][2]=Integer.parseInt(str[2]);
            }
            int ac=0,bc=0;
            for(int i=0;i<n;i++)
            {
                if(arr[i][1]==1)
                ac++;
                if(arr[i][2]==1)
                bc++;
            }
            if(ac<k||bc<k)
            pw.println(-1);
            else
            {
                ArrayList<Integer> ab=new ArrayList<>();
                ArrayList<Integer> a=new ArrayList<>();
                ArrayList<Integer> b=new ArrayList<>();
                for(int i=0;i<n;i++)
                {
                    if(arr[i][1]==1&&arr[i][2]==1)
                    ab.add(arr[i][0]);
                    else if(arr[i][1]==1)
                    a.add(arr[i][0]);
                    else if(arr[i][2]==1)
                    b.add(arr[i][0]);
                }
                Collections.sort(ab);
                Collections.sort(b);
                Collections.sort(a);
                long ans=0;
                if(a.size()==0||b.size()==0)
                {
                    for(int j=0;j<k;j++)
                    ans=ans+ab.get(j);
                }
                else
                {
                    ac=k;
                    bc=k;
                    int i=0,j=0,p=0;
                    while(i<ab.size()&&j<a.size()&&p<b.size()&&ac>0&&bc>0)
                    {
                        if(a.get(j)+b.get(p)<ab.get(i))
                        {
                            ac--;
                            bc--;
                            ans=ans+a.get(j)+b.get(p);
                            j++;
                            p++;
                        }
                        else
                        {
                            ac--;
                            bc--;
                            ans=ans+ab.get(i);
                            i++;
                        }
                    }
                    if(i==ab.size())
                    {
                        while(ac>0&&bc>0)
                        {
                            ac--;
                            bc--;
                            ans=ans+a.get(j)+b.get(p);
                            j++;
                            p++;
                        }
                    }
                    else
                    {
                        while(ac>0&&bc>0)
                        {
                            ac--;
                            bc--;
                            ans=ans+ab.get(i);
                            i++;
                        }
                    }
                }
                pw.println(ans);
            }
      //  }
        pw.flush();
        pw.close();
    }
}