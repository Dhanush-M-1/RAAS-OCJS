import java.io.*;
import java.util.TreeMap;

public class OldFloppyDrive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < t; testcase++) {
            String[] input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            input = br.readLine().trim().split(" ");
            long max = 0;
            long totalSum = 0;
            TreeMap<Long, Long> map = new TreeMap<>();
            map.put(0L, 0L);
            for (int i = 0; i < n; i++) {
                totalSum += Integer.parseInt(input[i]);
                if (totalSum > max) {
                    max = totalSum;
                    map.put(max, (long)i);
                }
            }

            int[] queries = new int[m];
            input = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                queries[i] = Integer.parseInt(input[i]);
            }

            for (int q : queries) {
                if (totalSum <= 0) {
                    if (q > max) {
                        bw.write("-1 ");
                    } else {
                        bw.write(map.ceilingEntry((long)q).getValue() + " ");
                    }
                } else {
                    long seconds = Math.max(0, (long) Math.ceil(((double) q - max) / totalSum)); // currently just number of cycles before final
                    long current = totalSum * seconds;
                    seconds *= n;
                    seconds += map.ceilingEntry(q - current).getValue();
                    bw.write(seconds + " ");
                }
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }


}
