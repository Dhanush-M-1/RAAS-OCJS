import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    IIO io;

    Main(IIO io) {
        this.io = io;
    }

    public static void main(String[] args) throws IOException {
//
        Main m = new Main(new ConsoleIO());
        m.solve();

//        Tester test = new Tester();
//        test.run();
    }

    public void solve() {
        int[] a = io.readIntArray();
        int n = a[0];
        int m = a[1];
        int[] ws = io.readIntArray();
        int[] order = io.readIntArray();

        boolean[] vis = new boolean[n];
        int[] stack = new int[m];
        int tail = m-1;
        for(int i = 0;i<order.length;i++){
            int k = order[i]-1;
            if(vis[k])
                continue;
            vis[k] = true;
            stack[tail--] = k;
        }
        int head = m - 1;
        int res = 0;
        int[] second = new int[m];
        int secondHead = 0;
        for(int i = 0;i<order.length;i++) {
            int k = order[i] - 1;
            for (; ; ) {
                int t = stack[head--];
                if (t == k)
                    break;
                res+=ws[t];
                second[secondHead++] = t;
            }
            for (; secondHead > 0; ) {
                int t = second[--secondHead];
                stack[++head] = t;
            }
            stack[++head] = k;
        }

        io.writeLine(Integer.toString(res));
    }


}

class ConsoleIO extends BaseIO {
    BufferedReader br;

    public ConsoleIO(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void writeLine(String s) {
        System.out.println(s);
    }

    public String readLine() {
        try {
            return br.readLine();
        }
        catch (Exception ex){
            return "";
        }
    }
}
abstract class BaseIO implements IIO {
    @Override
    public int readInt() {
        return Integer.parseInt(this.readLine());
    }

    @Override
    public int[] readIntArray() {
        String line = this.readLine();
        String[] nums = line.split(" ");
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Integer.parseInt(nums[i]);
        }
        return res;
    }
}
interface IIO {
    void writeLine(String s);
    String readLine();
    int readInt();
    int[] readIntArray();
}

