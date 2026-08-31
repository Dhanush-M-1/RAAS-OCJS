import java.io.*;
import java.util.*;

public class G {
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

    static FastReader s = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    private static int[] rai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    private static int[][] rai(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        return arr;
    }

    private static long[] ral(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        return arr;
    }

    private static long[][] ral(int n, int m) {
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.nextLong();
            }
        }
        return arr;
    }

    private static int ri() {
        return s.nextInt();
    }

    private static long rl() {
        return s.nextLong();
    }

    private static String rs() {
        return s.next();
    }

    static void bfs(List<Integer> list,HashMap<Integer,Integer> map,HashMap<Integer,Integer> count,int start)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        count.put(start,map.get(start));
        while(!queue.isEmpty())
        {
//            System.out.println(queue);
            int val=queue.remove();
            int curr=count.get(val);
            for(int mul=2;val*mul<=list.get(list.size()-1);mul++)
            {
                int nextVal=val*mul;
                if(map.containsKey(nextVal))
                {
                    int c=map.get(nextVal);
                    if(!count.containsKey(nextVal) || c+curr>count.get(nextVal))
                    {

                        count.put(nextVal,curr+c);
                        queue.add(nextVal);
                    }
                }
            }
        }
    }
    static HashSet<Integer> getDivisors(int val)
    {
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=Math.sqrt(val);i++)
        {
            if(val%i==0)
            {
                set.add(i);
                set.add(val/i);
            }
        }
        return set;
    }
    static int bsearch(List<Node> list,long q)
    {
        int l=0,r=list.size()-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(q<=list.get(mid).sum)
            {
                if(mid==0 || list.get(mid-1).sum<q)
                {
                    return mid;
                }
                else {
                    r=mid-1;
                }
            }
            else {
                l=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        int t = ri();
//        int t=1;
        while (t-- > 0)
        {
            int n=ri();
            int m=ri();
            long[] arr=ral(n);
            long[] query=ral(m);

            List<Long> prefSum=new ArrayList<>();
            long sum=0;
            long max=Long.MIN_VALUE;
            List<Node> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                sum+=arr[i];
                prefSum.add(sum);
                list.add(new Node(sum,i));
                max=Math.max(sum,max);
            }

            long last=prefSum.get(n-1);
            list.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Long.compare(o1.sum,o2.sum);
                }
            });

            int[] indices=new int[n];
            for(int i=0;i<n;i++)
            {
                indices[i]=list.get(i).ind;
            }
            SparseMatrix sp=new SparseMatrix(indices);


            for(int i=0;i<n;i++)
            {
                sum+=arr[i];
                prefSum.add(sum);
            }

            for(long q:query)
            {
                if(prefSum.get(n-1)<=0)
                {
                    int ind=bsearch(list,q);
                    if(ind==-1)
                    {
                        ans.append("-1 ");
                    }
                    else {
                        int index=sp.getMin(ind,n-1);
                        ans.append(index).append(" ");
                    }
                }
                else
                {
                    long count=Math.max(0,((q-max)+last-1)/last);
                    long res=count*n;
                    int ind=bsearch(list,q-last*count);
                    int index=sp.getMin(ind,n-1);
                    ans.append(res+index).append(" ");

                }

            }
            ans.append("\n");


        }
        out.print(ans.toString());
        out.flush();

    }
    static class Node
    {
        Long sum;
        int ind;

        public Node(Long sum, int ind) {
            this.sum = sum;
            this.ind = ind;
        }
    }
    static class SparseMatrix {
        private int[] arr;
        private int m;
        private int[][] minSparse;
        private int[][] minIndex;
        private int[][] maxSparse;
        private int[][] maxIndex;
        private int n;
        public SparseMatrix(int[] arr) {
            this.arr = arr;
            this.m=arr.length;
            this.n=Integer.toBinaryString(m).length();
            minSparse=new int[n][m];
            minIndex=new int[n][m];

            maxSparse=new int[n][m];
            maxIndex=new int[n][m];
//        for(int i=0;i<n;i++)
//        {
//            Arrays.fill(minSparse[i],-1);
//        }
//        for(int i=0;i<n;i++)
//        {
//            Arrays.fill(minIndex[i],-1);
//        }

            createMinSparse();
            createMaxSparse();
        }
        private void createMaxSparse()
        {
            for(int j=0;j<m;j++)
            {
                maxSparse[0][j]=arr[j];
                maxIndex[0][j]=j;
            }
            for(int i=1;i<n;i++)
            {
                for(int j=0;j+(1<<(i-1))<m;j++)
                {
                    int left=maxSparse[i-1][j];
                    int right=maxSparse[i-1][j+(1<<(i-1))];
                    maxSparse[i][j]=Math.max(left,right);

                    if(left>=right)
                    {
                        maxIndex[i][j]=maxIndex[i-1][j];
                    }
                    else
                    {
                        maxIndex[i][j]=maxIndex[i-1][j+(1<<(i-1))];
                    }
                }
            }
        }
        private void createMinSparse()
        {
            //filling the first row of sparse matrix with the values of the input array
            for(int j=0;j<m;j++)
            {
                minSparse[0][j]=arr[j];
                minIndex[0][j]=j;
            }
            //filling other rows of the sparse matrix
            for(int i=1;i<n;i++)
            {
                for(int j=0;j+(1<<(i-1))<m;j++)
                {

                    int left=minSparse[i-1][j];
                    int right=minSparse[i-1][j+(1<<(i-1))];

                    //change to min-> max to create MaxSparseMatrix
                    minSparse[i][j]=Math.min(left,right);

                    //filling index
                    if(left<=right)
                    {
                        minIndex[i][j]=minIndex[i-1][j];
                    }
                    else {
                        minIndex[i][j]=minIndex[i-1][j+(1<<(i-1))];
                    }

                }
            }
        }

        //get minimum value in range l->r inclusive
    /*
        for any range [l, r] we can find the two values and
        find their minimum. These values are defined below:

        len: length of the required range, i.e., r-l+1

        p: maximum power of 2 that can fit in len. E.g, [1,11] , len=11, thus p=3

        k: 2^p

        find the minimum between sparse[p][l] and sparse[p][r-k+1]
    */
        public int getMin(int l,int r)
        {
            int len=r-l+1;
            int p=Integer.toBinaryString(len).length()-1;
            int k=1<<p;

            int left=minSparse[p][l];
            int right=minSparse[p][r-k+1];
            return Math.min(right,left);
        }

        public int getMinIndex(int l,int r)
        {
            int len=r-l+1;
            int p=Integer.toBinaryString(len).length()-1;
            int k=1<<p;

            int left=minSparse[p][l];
            int right=minSparse[p][r-k+1];
            if (left <= right) {
                return minIndex[p][l];
            } else {
                return minIndex[p][r - k + 1];
            }
        }


        public int getMax(int l,int r)
        {
            int len=r-l+1;
            int p=Integer.toBinaryString(len).length()-1;
            int k=1<<p;

            int left=maxSparse[p][l];
            int right=maxSparse[p][r-k+1];
            return Math.max(right,left);
        }

        public int getMaxIndex(int l,int r)
        {
            int len=r-l+1;
            int p=Integer.toBinaryString(len).length()-1;
            int k=1<<p;
            int left=maxSparse[p][l];
            int right=maxSparse[p][r-k+1];
            if(left>=right)
            {
                return maxIndex[p][l];

            }
            return maxIndex[p][r-k+1];
        }
        void print()
        {
            for(int i=0;i<minSparse.length;i++)
            {
                for(int j=0;j<minSparse[i].length;j++)
                {
                    System.out.print(minSparse[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    System.out.print(minIndex[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
