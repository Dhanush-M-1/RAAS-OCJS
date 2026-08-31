import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=1;
        while(T-->0)
        {
            int n=input.nextInt();
            ArrayList<Integer> list=new ArrayList<>();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
               a[i]=input.nextInt();
               list.add(a[i]);
            }
            Collections.sort(list,Collections.reverseOrder());
            int m=input.nextInt();
            for(int i=0;i<m;i++)
            {
                int k,pos;
                k=input.nextInt();
                pos=input.nextInt();
                HashMap<Integer,Integer> map=new HashMap<>();
                for(int j=0;j<k;j++)
                {
                    if(map.containsKey(list.get(j)))
                    {
                        map.put(list.get(j),map.get(list.get(j))+1);
                    }
                    else
                    {
                        map.put(list.get(j),1);
                    }
                }
                ArrayList<Integer> ans=new ArrayList<>();
                for(int j=0;j<n;j++)
                {
                    if(map.containsKey(a[j]))
                    {
                        ans.add(a[j]);
                        if(map.get(a[j])==1)
                        {
                            map.remove(a[j]);
                        }
                        else
                        {
                            map.put(a[j],map.get(a[j])-1);
                        }
                    }
                }
                out.println(ans.get(pos-1));
            }
        }
        out.close();
    }
    public static int greaterNo(ArrayList<Integer> a,int k)
    {
        int i=0,j=a.size();
        while(i<j)
        {
            int mid=(i+j)/2;
            if(a.get(mid)>k)
            {
                j=mid;
            }
            else
            {
                i=mid+1;
            }
        }
        return i-1;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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