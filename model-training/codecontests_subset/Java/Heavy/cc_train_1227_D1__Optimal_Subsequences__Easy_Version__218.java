import java.io.*;
import java.util.*;
public class Ishu
{
    static class Node
    {
    int data;
    int in;
    Node() {}
    Node(int d, int i)
        {
        this.data = d;
        this.in = i;
        }
    }

    static Scanner scan = new Scanner(System.in);
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out)); 

    static void update(int[] a, int[] tree, int beg, int end, int st, int pos)
    {
    if(beg == end && beg == st)
        {
        a[st]++;
        tree[pos]++;
        return;
        }
    int mid = (beg + end) / 2;
    if(st <= mid)
        update(a, tree, beg, mid, st, 2 * pos);
    else
        update(a, tree, mid + 1, end, st, 2 * pos + 1);
      
    tree[pos] = tree[2 * pos] + tree[2 * pos + 1];
    }
    static int query(int[] tree, int beg, int end, int l, int r, int pos)
    {
    if(r < beg || l > end)
        return 0;
    if(l <= beg && end <= r)
        return tree[pos];
    int mid = (beg + end) / 2;
    int left = query(tree, beg, mid, l, r, 2 * pos);
    int right = query(tree, mid + 1, end, l, r, 2 * pos + 1);
    int sum = left + right;
    return sum;
    }
    static void tc() throws Exception
    {
    int n = scan.nextInt();
    List<Node> a = new ArrayList<Node>();
    int[] ac = new int[n];
    int i;
    for(i=0;i<n;++i)
        {
        int data = scan.nextInt();
        ac[i] = data;
        int in = i + 1;
        a.add(new Node(data, in));
        }
   
    Collections.sort(a, new Comparator<Node>(){
        public int compare(final Node x, final Node y)
            {
            if(x.data != y.data)
                return x.data - y.data;
            else
                return y.in - x.in;
            }
    });

    int[] tree = new int[4 * n];
    int[] arr = new int[n + 1];
    
    int m = scan.nextInt();
    int[][] query = new int[m][4];
    for(i=0;i<m;++i)
        {
        query[i][0] = scan.nextInt();
        query[i][1] = scan.nextInt();
        query[i][2] = i + 1;
        }
        
    Arrays.sort(query, Comparator.comparingInt(o -> o[0]));
    int tr = 0;

    for(i=n-1;i>=0;--i)    
        {
        Node cur = a.get(i);
        int in = cur.in;

        update(arr, tree, 1, n, in, 1);
        int cnt = n - i;
        if(tr == m)
            break;
        int k = query[tr][0];
        if(cnt < k)
            continue;
            
        while(tr < m && query[tr][0] == k)
            {
            int beg = 1;
            int end = n;
            int mid = (beg + end) / 2;
            int data = query[tr][1];
            while(beg <= end)   
                {
                mid = (beg + end) / 2;
                int res = query(tree, 1, n, 1, mid, 1);
                if(res < data)
                    beg = mid + 1;
                else if(res > data)
                    end = mid - 1;
                else
                    {
                    query[tr][3] = ac[mid - 1];
                    end = mid - 1;
                    }
                }
            ++tr;
            }
        }
    Arrays.sort(query, Comparator.comparingInt(o -> o[2]));
    for(i=0;i<m;++i)
        output.write(query[i][3] + "\n"); 
    output.flush();
    }
    public static void main(String[] args) throws Exception
    {
    int t = 1;
    //t = scan.nextInt();
    while(t-- > 0)
        tc();
    }
}
