import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    FastScanner scanner = new FastScanner();

    private void calc() {
        String[] names = new String[2];
        names[0] = scanner.next();
        names[1] = scanner.next();
        sout(names[0] + " " + names[1]);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String killed = scanner.next();
            String stayed = scanner.next();
            if (names[0].equals(killed)) {
                names[0] = stayed;
            } else {
                names[1] = stayed;
            }
            sout(names[0] + " " + names[1]);
        }
    }

    /*
     * Main Method
     */
    public static void main(String[] args) throws Exception {
        // long s = System.currentTimeMillis();
        new Main().calc();
        // long e = System.currentTimeMillis();
        // System.out.println("Total: " + (e - s) + "ms");
    }

    /*
     * Read input
     */
    int[] rarr(int count) {
        int[] value = new int[count];
        for (int i = 0; i < count; i++) {
            value[i] = scanner.nextInt();
        }
        return value;
    }

    private static final Charset ANSII = Charset.forName("ASCII");

    int[] rstr() {
        String str = scanner.next().trim();
        ByteBuffer buf = ANSII.encode(str);
        byte[] barr = buf.array();
        int[] result = new int[barr.length];
        for (int i = 0; i < barr.length; i++) {
            result[i] = barr[i];
        }
        return result;
    }

    /*
     * Print Methods
     */
    void sout(int n) {
        sout(Integer.valueOf(n));
    }

    void sout(Collection<?> col) {
        for (Object object : col) {
            sout(object);
        }
    }

    void sout(int[] arr) {
        sout(Arrays.stream(arr).mapToObj(i -> "" + i).collect(Collectors.joining(" ")));
    }

    void sout(Object obj) {
        System.out.println(Objects.toString(obj, ""));
    }

    String toString(int[] arr) {
        byte[] buf = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            buf[i] = (byte) arr[i];
        }
        CharBuffer charBuffer = ANSII.decode(ByteBuffer.wrap(buf));
        return new String(charBuffer.array());
    }

    void soutAsString(int[] arr) {
        sout(toString(arr));
    }

    /*
     * Algorithms
     */
    void sort(int[] data) {
        Arrays.sort(data);
    }

    int max(int[] data) {
        return Arrays.stream(data).max().orElse(Integer.MIN_VALUE);
    }

    int min(int[] data) {
        return Arrays.stream(data).min().orElse(Integer.MIN_VALUE);
    }

    int maxIndex(int[] data) {
        int index = 0;
        int m = data[0];
        for (int i = 1; i < data.length; i++) {
            if (m < data[i]) {
                m = data[i];
                index = i;
            }
        }
        return index;
    }

    int[] toArray(List<Integer> lst) {
        int[] ans = new int[lst.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = lst.get(i);
        }
        return ans;
    }

}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
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
}