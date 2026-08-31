import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Solution2 {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            int T = Integer.parseInt(in.readLine().strip());

            tC: while (T-- != 0) {
                in.readLine();

                String[] currLine = in.readLine().strip().split(" ");
                int K = Integer.parseInt(currLine[0]);
                int N = Integer.parseInt(currLine[1]);
                int M = Integer.parseInt(currLine[2]);

                int[] a = Arrays.asList(in.readLine().strip().split(" ")).stream().mapToInt(Integer::parseInt)
                        .toArray();
                int[] b = Arrays.asList(in.readLine().strip().split(" ")).stream().mapToInt(Integer::parseInt)
                        .toArray();

                int i = 0;
                int j = 0;

                StringBuilder ansList = new StringBuilder();

                while (i < N && j < M) {
                    int currA = a[i];
                    int currB = b[j];

                    if (currA == 0) {
                        K += 1;
                        ansList.append(currA + " ");
                        i++;
                        continue;
                    }

                    if (currB == 0) {
                        K += 1;
                        ansList.append(currB + " ");
                        j++;
                        continue;
                    }

                    if (currA <= K) {
                        ansList.append(currA + " ");
                        i++;
                        continue;
                    }

                    if (currB <= K) {
                        ansList.append(currB + " ");
                        j++;
                        continue;
                    }

                    out.println(-1);
                    continue tC;
                }

                while (i < N) {
                    if (a[i] == 0) {
                        K += 1;
                        ansList.append(a[i] + " ");
                        i++;
                        continue;
                    }

                    if (a[i] <= K) {
                        ansList.append(a[i] + " ");
                        i++;
                        continue;
                    }

                    out.println(-1);
                    continue tC;
                }

                while (j < M) {
                    if (b[j] == 0) {
                        K += 1;
                        ansList.append(b[j] + " ");
                        j++;
                        continue;
                    }

                    if (b[j] <= K) {
                        ansList.append(b[j] + " ");
                        j++;
                        continue;
                    }

                    out.println(-1);
                    continue tC;
                }
                out.println(ansList.toString());
            }

            in.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
