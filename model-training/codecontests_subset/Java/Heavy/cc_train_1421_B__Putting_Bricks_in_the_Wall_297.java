
    //package cf;
    import java.io.*;
    import java.util.*;
    import java.util.jar.JarOutputStream;

    public class Temp_Class {
        static int p=1000000007;
static class pr
{
    int x;
    int y;

    public pr(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

        public static void main(String[] args) throws Exception{
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
            FastReader sc=new FastReader();
            int t=sc.nextInt();
            StringBuilder sb2=new StringBuilder();
            while(t-- >0)
            {
                StringBuilder sb=new StringBuilder();
                int n=sc.nextInt();
                char ch[][]=new char[n][n];
                for(int i=0;i<n;i++)
                {
                    ch[i]=sc.nextLine().toCharArray();
                }
                List<pr> l1=new ArrayList<>();
                List<pr> l2=new ArrayList<>();
                if(ch[0][2]=='1')
                {
                    l1.add(new pr(0,2));
                }
                else {
                    l2.add(new pr(0, 2));
                }
                if(ch[1][1]=='1')
                {
                    l1.add(new pr(1,1));
                }
                else {
                    l2.add(new pr(1, 1));
                }
                if(ch[2][0]=='1')
                {
                    l1.add(new pr(2,0));
                }
                else {
                    l2.add(new pr(2, 0));
                }
                int c=0;
                if(ch[1][0]==ch[0][1]&&l1.size()!=3&&l2.size()!=3)
                {
                    if(ch[1][0]=='1')
                    {
                        for(int i=0;i<l1.size();i++)
                        {
                            c++;
                            pr cur=l1.get(i);
                            sb.append((cur.x+1)+" "+(cur.y+1));
                            sb.append("\n");
                        }
                    }
                    else
                    {
                        for(int i=0;i<l2.size();i++)
                        {
                            c++;
                            pr cur=l2.get(i);
                            sb.append((cur.x+1)+" "+(cur.y+1));
                            sb.append("\n");
                        }
                    }
                }
                else if(l1.size()==3)
                {
                    if(ch[0][1]=='1')
                    {
                        c++;
                        sb.append((1)+" "+(1+1));
                        sb.append("\n");
                    }
                     if(ch[1][0]=='1')
                    {
                        c++;
                        sb.append((2)+" "+(1));
                        sb.append("\n");
                    }
                }
                else if(l2.size()==3)
                {
                    if(ch[0][1]=='0')
                    {
                        c++;
                        sb.append((1)+" "+(1+1));
                        sb.append("\n");
                    }
                     if(ch[1][0]=='0')
                    {
                        c++;
                        sb.append((2)+" "+(1));
                        sb.append("\n");
                    }
                }
                else if(l1.size()>l2.size())
                {
                    c++;
                    pr cur=l2.get(0);
                    sb.append((cur.x+1)+" "+(cur.y+1));
                    sb.append("\n");
                    if(ch[0][1]=='1')
                    {
                        c++;
                        sb.append((1)+" "+(1+1));
                        sb.append("\n");
                    }
                    else if(ch[1][0]=='1')
                    {
                        c++;
                        sb.append((2)+" "+(1));
                        sb.append("\n");
                    }
                }
                else {
                    c++;
                    pr cur=l1.get(0);
                    sb.append((cur.x+1)+" "+(cur.y+1));
                    sb.append("\n");
                    if(ch[0][1]=='0')
                    {
                        c++;
                        sb.append((1)+" "+(1+1));
                        sb.append("\n");
                    }
                    else if(ch[1][0]=='0')
                    {
                        c++;
                        sb.append((2)+" "+(1));
                        sb.append("\n");
                    }
                }
                sb2.append(c+"\n");
                sb2.append(sb.toString());

            }
            System.out.println(sb2.toString());
            out.flush();
        }
        public static boolean union(int a, int b, int p[], int r[]){
            // add your code here
            int pa=find(a,p,r);
            int pb=find(b,p,r);
            if(pa==pb)
                return true;
            if(pa!=pb)
            {
                if(r[pa]<r[pb])
                {
                    p[pa]=pb;
                }
                else if(r[pa]>r[pb])
                {
                    p[pb]=pa;
                }
                else
                {
                    p[pa]=pb;
                    r[pb]++;
                }
            }
            return false;
        }
        public static int find(int x,int p[],int r[])
        {
            if(p[x]==x)
                return x;
            p[x]=find(p[x],p,r);
            return p[x];
        }
        public static int binary_Search_upper(Long ar[],Long x)
        {
            int res=-1;
            int l=0;int r=ar.length-1;
            while(l<=r)
            {
                int mid=(l+r)>>1;
                if(ar[mid]==x)
                {
                    res=mid;
                    l=mid+1;
                }
                else if(ar[mid]>x)
                {
                    res=mid;
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
            return res;
        }
        public static int binary_Search_lower(int ar[],int x)
        {
            int res=-1;
            int l=0;int r=ar.length-1;
            while(l<=r)
            {
                int mid=(l+r)>>1;
                if(ar[mid]==x)
                {
                    res=mid;
                    r=mid-1;
                }
                else if(ar[mid]>x)
                {
                    r=mid-1;
                }
                else
                {
                    res=mid;
                    l=mid+1;
                }
            }
            return res;
        }
        int bit[]=new int[(int)1e6];
        public void update(int n,int val,int i)
        {
            i++;
            while(i<n)
            {
                bit[i]+=val;
                i+=(i)&(-i);
            }

        }
        public long query(int n,int i)
        {
            i++;
            long sum=0;
            while(i>0)
            {
                sum+=bit[i];
                i-=(i)&(-i);
            }
            return sum;
        }


        ///////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////
        static class FastReader {

            BufferedReader br;
            StringTokenizer st;

            public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt() {
                return Integer.parseInt(next());
            }

            long nextLong() {
                return Long.parseLong(next());
            }

            double nextDouble() {
                return Double.parseDouble(next());
            }

            String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
        }


    }
