import java.io.*;
import java.util.*;



public class test
{   
       

    public static void main(String args[]) throws IOException
    {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);

        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Long> aa = new ArrayList<Long>();
        ArrayList<Long> bb = new ArrayList<Long>();
        ArrayList<Long> cc = new ArrayList<Long>();

        String s1[] = br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            aa.add(Long.parseLong(s1[i]));
        }
        Collections.sort(aa);

        String s2[] = br.readLine().split(" ");
        for(int i=0;i<n-1;i++)
        {
            bb.add(Long.parseLong(s2[i]));
        }
        Collections.sort(bb);
        long g=0;
        bb.add(g);

        String s3[] = br.readLine().split(" ");
        for(int i=0;i<n-2;i++)
        {
            cc.add(Long.parseLong(s3[i]));
        }
        Collections.sort(cc);
        long h = 0;
        cc.add(h);
        cc.add(h);
        
        for(int j=0;j<n;j++)    
        {
            long x = aa.get(j);
            long y = bb.get(j);
            if(x!=y)
            {
                
                System.out.println(x);
                break;
            }
        }

        for(int k=0;k<n;k++)
        {
            long x = bb.get(k);
            long y = cc.get(k);
            if(x!=y)
            {
                System.out.println(x);
                break;
            }
        }
/*
        for(int i=0;i<n;i++)
        {
            System.out.print(aa.get(i)+ " ");
        }
        System.out.println();
        
        for(int i=0;i<n;i++)
        {
            System.out.print(bb.get(i)+ " ");
        }   

        System.out.println();
        for(int i=0;i<n;i++)
        {
            System.out.print(cc.get(i)+ " ");
        }   
*/
        
    }

            


   

}