import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        //        System.setIn(new FileInputStream("/Users/huangweixuan/testdata.txt"));
        Scanner sc = new Scanner(System.in);
        String str = "";
        int k = 0, sum = 0;
        String[] arr;
        while (sc.hasNext()) {
            str = sc.nextLine();
            if (str.charAt(0) == '+') {
                ++k;
            } else if (str.charAt(0) == '-') {
                --k;
            } else {
                arr = str.split(":");
                if (arr.length == 1) {
                    continue;
                }
                sum += arr[1].length() * k;
            }
        }
        bw.write(sum + "");
        bw.close();
    }
}