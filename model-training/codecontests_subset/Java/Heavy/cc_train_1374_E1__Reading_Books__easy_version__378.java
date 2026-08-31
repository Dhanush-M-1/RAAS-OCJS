import java.util.*;
 
public class E1_Reading_Books_easy_version_ {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int i=0;
        ArrayList<Integer> al=new ArrayList<>();
        ArrayList<Integer> bl=new ArrayList<>();
        ArrayList<Integer> cl=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            
            if(b==1&&c==1)
            {
                cl.add(a);
            }
            else if(b==1)
            {
                al.add(a);
            }
            else if(c==1)
            {
                bl.add(a);
            }
        }
        Collections.sort(al);
        Collections.sort(bl);
        Collections.sort(cl);
        int n1=al.size();
        int n2=bl.size();
        int n3=cl.size();
        long dp1[]=new long[n1+1];
        long dp2[]=new long[n2+1];
        long dp3[]=new long[n3+1];
        dp1[0]=0;
        dp2[0]=0;
        dp3[0]=0;
        
        for(i=1;i<=n1;i++)
        {
            dp1[i]=dp1[i-1]+al.get(i-1);
 
        }
        for(i=1;i<=n2;i++)
        {
            dp2[i]=dp2[i-1]+bl.get(i-1);
        }
        for(i=1;i<=n3;i++)
        {
            dp3[i]=dp3[i-1]+cl.get(i-1);
        }
        
        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));
        // System.out.println(Arrays.toString(dp3));
        int ans=Integer.MAX_VALUE;
        for(int cnt=0;cnt<Math.min(k+1,n3+1);cnt++)
        {
            // System.out.println(" cnt= "+cnt);
            // if(cnt==4)
            // {
            //     System.out.println((k-cnt)+" * "+n1+" "+n2+" "+n3);
            // }
            if(((k-cnt)>=0)&&(n2>(k-cnt-1))&&(n1>(k-cnt-1)))
            {
                //System.out.println(" cnt= "+cnt);
                ans=Math.min(ans,(int)(dp3[cnt]+dp2[k-cnt]+dp1[k-cnt]));
            }
        }
        if(ans==Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(ans);
        }
 
        // PriorityQueue<Integer> al=new PriorityQueue<>();
        // PriorityQueue<Integer> bl=new PriorityQueue<>();
        // PriorityQueue<Integer> cl=new PriorityQueue<>();
        // int cnst=1000000000;
        // for(i=0;i<n;i++)
        // {
        //     int a=sc.nextInt();
        //     int b=sc.nextInt();
        //     int c=sc.nextInt();
            
        //     if(b==1&&c==1)
        //     {
        //         cl.add(a);
        //     }
        //     else if(b==1)
        //     {
        //         al.add(a);
        //     }
        //     else if(c==1)
        //     {
        //         bl.add(a);
        //     }
        // }
        // System.out.println(al);
        // System.out.println(bl);
        // System.out.println(cl);
        // k=k*2;
        // long ans=0;
        // while(k>0&&(!al.isEmpty()||!bl.isEmpty()||!cl.isEmpty()))
        // {
        //     int a=al.isEmpty()?cnst:al.peek();
        //     int b=bl.isEmpty()?cnst:bl.peek();
        //     int c=cl.isEmpty()?cnst:cl.peek();
        //     System.out.print(" a= "+a+" b= "+b+" c= "+c+" ");
        //     if(c<a&&c<b)
        //     {
        //         k=k-2;
        //         int t=0;
        //         t=cl.poll();
 
        //         ans+=t;
        //     }
        //     else if(b<a)
        //     {
        //         if(c<=(2*b))
        //         {
        //             k=k-2;
        //             int t=cl.poll();
        //             ans+=t;
        //         }
        //         else
        //         {
        //             k--;
        //             int t=bl.poll();
        //             ans+=t;
        //         }
        //     }
        //     else if(a<b)
        //     {
        //         if(c<=(2*a))
        //         {
        //             k=k-2;
        //             int t=cl.poll();
        //             ans+=t;
        //         }
        //         else
        //         {
        //             k--;
        //             int t=al.poll();
        //             ans+=t;
        //         }
        //     }
        //     System.out.println(" ans= "+ans);
        // }
        // if(k==0)
        // System.out.println(ans);
        // else
        // System.out.println(-1);
    }
}