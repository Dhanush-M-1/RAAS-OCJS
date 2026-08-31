
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Problem_02 {


    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner();
        String s = input.nextLine();
        int n = Integer.valueOf(s.substring(s.lastIndexOf('=') + 1).trim());

        int[] max = new int[101];
        int[] min = new int[101];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || i ==0) {
                k++;
                min[k] = min[k-1]+1;
                max[k] = max[k-1]+n;
            } else if (s.charAt(i) == '-') {
                k++;
                min[k] = min[k-1]-n;
                max[k] = max[k-1]-1;
            }
        }
        if (min[k] > n || max[k] < n) {
            System.out.println("Impossible");
        } else {
            StringBuffer sb = new StringBuffer();
            int l = k - 1;
            int sum = n;
            for (int i = s.length() -1; i>=0; i--) {
                if (s.charAt(i) == '?') {
                    if ((max[l+1] > max[l])) {
                        int c = 1;
                        if (max[l] + c < sum)
                            c = sum - max[l];

                        sb.append(new StringBuffer(String.valueOf(c)).reverse().toString());
                        sum-=c;
                        l--;
                    } else {
                        int c = 1;
                        if (min[l] > sum + c)
                            c = min[l] - sum;
                        sb.append(new StringBuffer(String.valueOf(c)).reverse().toString());
                        sum+=c;
                        l--;
                    }

                } else {
                    sb.append(s.charAt(i));
                }
            }
            System.out.println("Possible");
            System.out.println(sb.reverse().toString());
        }
    }

    static class Scanner {
        final BufferedReader input;
        String[] buffer;
        int pos;


        public Scanner() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }


        private String read() {
            try {
                if (buffer == null || pos >= buffer.length) {
                    buffer = input.readLine().split("\\s+");
                    pos = 0;
                }
                return buffer[pos++];
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        long nextLong() {
            return Long.parseLong(read());
        }

        int nextInt() {
            return Integer.parseInt(read());
        }

        double nextDouble() {
            return Double.parseDouble(read());
        }

        String nextLine() {
            if (buffer != null && pos < buffer.length) {
                throw new RuntimeException("Buffer is not empty");
            }
            try {
                return input.readLine();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}