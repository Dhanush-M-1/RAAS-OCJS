import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Boolean> map = new HashMap<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        //        System.setIn(new FileInputStream("/Users/huangweixuan/testdata.txt"));
        Scanner sc = new Scanner(System.in);
        String str = "";
        int cnt = 0, res = 0;
        String[] arr;
        while (sc.hasNext()) {
            str = sc.nextLine();
            if (str.charAt(0) == '+') {
                map.put(str.substring(1), true);
                continue;
            }
            if (str.charAt(0) == '-') {
                map.put(str.substring(1), false);
                continue;
            }
            for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                if (entry.getValue()) {
                    ++cnt;
                }
            }
            arr = str.split(":");
            if (arr.length > 1) {
                res += arr[1].length() * cnt;
            }
            cnt = 0;
        }
        bw.write(res + "");
        bw.close();
    }
}