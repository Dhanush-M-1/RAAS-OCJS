import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])
    {
        long start=System.currentTimeMillis();
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=1;
        while(T-->0)
        {
            String arr[]={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100"
            ,"1101","1110","1111"};
            int n=input.nextInt();
            char ch[][]=new char[n][n];
            for(int i=0;i<n;i++)
            {
                String s=input.next();
                int x=0;
                for(int j=0;j<s.length();j++)
                {
                    char c=s.charAt(j);
                    int v=(c);
                    if(v>=65 && v<=70)
                    {
                        v-=55;
                    }
                    else
                    {
                        v-=48;
                    }
                    for(int k=0;k<4;k++)
                    {
                        ch[i][x]=arr[v].charAt(k);
                        x++;
                    }
                }
            }
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=1;i<=Math.sqrt(n);i++)
            {
                if(n%i==0)
                {
                    if(i==n/i)
                    {
                        list.add(i);
                    }
                    else
                    {
                        list.add(i);
                        list.add(n/i);
                    }
                }
            }
            Collections.sort(list,Collections.reverseOrder());
            int in=0;
            for(int i=0;i<list.size();i++)
            {
                int f=list.get(i);
                int flag=0;
                for(int j=0;j<n;j+=f)
                {
                    for(int k=0;k<n;k+=f)
                    {
                        int x=0;
                        char val=0;
                        int y=0;
                        for(int l=j;l<j+f;l++)
                        {
                            for(int m=k;m<k+f;m++)
                            {
                                char c=ch[l][m];
                                if(x==0)
                                {
                                    val=c;
                                    x=1;
                                }
                                else
                                {
                                    if(val!=c)
                                    {
                                        y=1;
                                        break;
                                    }
                                }
                            }
                            if(y==1)
                            {
                                break;
                            }
                        }
                        if(y==1)
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        break;
                    }
                }
                if(flag==0)
                {
                    in=list.get(i);
                    break;
                }
            }
            out.println(in);
        }
        //long end=System.currentTimeMillis();
        //out.println(end-start);
        out.close();
    }
    public static ArrayList<Integer> primeFactors(int n)
    {
        ArrayList<Integer> list=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        while(n%2==0)
        {
            if(!set.contains(2))
            {
                set.add(2);
                list.add(2);
            }
            n/=2;
        }
        for(int i=3;i<=Math.sqrt(n);i+=2)
        {
            while(n%i==0)
            {
                if(!set.contains(i))
                {
                    set.add(i);
                    list.add(i);
                }
                n/=i;
            }
        }
        if(n>2)
        {
            if(!set.contains(n))
            {
                set.add(n);
                list.add(n);
            }
        }
        return list;
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
        long nextLong()
        {
            return Long.parseLong(next());
        }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}