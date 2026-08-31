import java.io.BufferedReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;

public class cf1374E1{
    public static void main(String[] args) throws Exception{
        StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = readInt(cin);
        int k = readInt(cin);
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        List<Integer> ab = new ArrayList<Integer>();
        for (int i = 1;i <= n;i++){
            int t = readInt(cin);
            int aa = readInt(cin);
            int bb = readInt(cin);
            if (aa == 1 && bb == 1) ab.add(t);
            else if (aa == 1) a.add(t);
            else if (bb == 1) b.add(t);
        }
        ab.sort(null);
        a.sort(null);
        b.sort(null);
        int sum_ab = 0,sum_a = 0,sum_b = 0;
        int index_a = a.size(), index_b = b.size();
        for (int i = 0;i < a.size();i++)
            sum_a += a.get(i);
        for (int i = 0;i < b.size();i++)
            sum_b += b.get(i);
        while (index_a > k){
            index_a--;
            sum_a -= a.get(index_a);
        }
        while (index_b > k){
            index_b--;
            sum_b -= b.get(index_b);
        }
        int ans = sum_a+sum_b;
        boolean flag = (index_a == k) && (index_b == k);
        for (int i = 0;i < ab.size();i++){
            sum_ab += ab.get(i);
            if (index_a > 0 && index_a + i + 1 > k) {
                index_a--;
                sum_a -= a.get(index_a);
            }
            if (index_b > 0 && index_b + i + 1 > k) {
                index_b--;
                sum_b -= b.get(index_b);
            }
            if (index_a+i+1 == k && index_b+i+1 == k){
                if (flag) ans = Math.min(ans,sum_a+sum_b+sum_ab);
                else {
                    ans = sum_a+sum_b+sum_ab;
                    flag = true;
                }
            }
        }
        if (!flag) ans = -1;
        System.out.println(ans);
    }
    private static int readInt(StreamTokenizer cin)throws Exception{
        cin.nextToken();
        return (int)cin.nval;
    }
}