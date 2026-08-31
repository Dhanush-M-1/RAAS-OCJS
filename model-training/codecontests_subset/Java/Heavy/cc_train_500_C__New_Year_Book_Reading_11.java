
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NewYearBookReading {

    void run() throws Exception {
        BufferedReader bfd = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bfd.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(bfd.readLine());
        int[] w = new int[n];
        for (int i = 0; i < n; ++i) w[i] = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(bfd.readLine());
        int[] arr = new int[m];
        List<Integer> li = new ArrayList<Integer>();
        for (int i = 0; i < m; ++i) {
            arr[i] = Integer.parseInt(tk.nextToken()) - 1;
            if (!li.contains(arr[i]))
                li.add(arr[i]);
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < li.size(); ++j)
                if (li.get(j) == arr[i]) {
                    li.remove(j);
                    li.add(0, arr[i]);
                    break;
                } else {
                    res += w[li.get(j)];
                }
        }
        System.out.println(res);
    }
    
    public static void main(String[] args) throws Exception {
        new NewYearBookReading().run();
    }

}
