
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolutionD {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.readIntValue();

        long[] s = reader.readLongNumbers();
        int[] res = new int[n];

        FenwickTree fenwickTree = new FenwickTree(n);
        for (int i = s.length - 1; i >= 0; i--) {
            long sum = 0;
            long currS = s[i];
            int currIndex = 0;

            int a = 0;
            int b = s.length;

            while (a <= b) {
                int size = (a + b) / 2;
                sum = fenwickTree.sum(size);
                if (sum < currS) {
                    a = size + 1;
                } else if (sum > currS) {
                    b = size - 1;
                } else {
                    currIndex = size;
                    break;
                }
            }

            if (sum == currS) {

                int firstIndex = currIndex + 1;
                int lastIndex = s.length;
                int nextIndex = lastIndex;
                while (firstIndex < lastIndex) {
                    int size = (firstIndex + lastIndex) / 2;
                    sum = fenwickTree.sum(size);
                    if (sum == currS) {
                        firstIndex = size + 1;
                    } else if (sum > currS) {
                        lastIndex = size;
                        nextIndex = lastIndex;
                    }
                }
                res[i] = nextIndex;
                fenwickTree.updateValue(nextIndex, -nextIndex);
            }

        }


        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }


    }

}

class FenwickTree {

    private long[] arr;

    FenwickTree(int size) {
        this.arr = new long[size + 1];
        for (int i = 0; i < arr.length; i++) {
            updateValue(i, i);
        }
    }

    long sum(int range) {
        long result = 0;
        for (; range >= 0; range = (range & (range + 1)) - 1) {
            result += arr[range];
        }
        return result;
    }

//    int sumABInterval(int l, int r) {
//        return sum(r) - sum(l - 1);
//    }

    void updateValue(int i, int delta) {
        for (; i < arr.length; i = (i | (i + 1)))
            arr[i] += delta;
    }

}

class Reader {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public StringTokenizer getStringTokenizer() throws IOException {
        String line = bufferedReader.readLine().replaceAll("\\s+$", "");
        return new StringTokenizer(line, " ");
    }

    public int getNextInt(StringTokenizer stringTokenizer) {
        while (stringTokenizer.hasMoreTokens()) {
            return Integer.parseInt(stringTokenizer.nextToken());
        }
        throw new RuntimeException("no more tokens in string");
    }

    public long getNextLong(StringTokenizer stringTokenizer) {
        while (stringTokenizer.hasMoreTokens()) {
            return Long.parseLong(stringTokenizer.nextToken());
        }
        throw new RuntimeException("no more tokens in string");
    }

    public String getNextString(StringTokenizer stringTokenizer) {
        while (stringTokenizer.hasMoreTokens()) {
            return stringTokenizer.nextToken();
        }
        throw new RuntimeException("no more tokens in string");
    }

    public String readStringValue() throws IOException {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
    }

    public int readIntValue() throws IOException {
        String line = bufferedReader.readLine().replaceAll("\\s+$", "");
        int parsedToInt = Integer.parseInt(line);
        return parsedToInt;
    }

    public int[] readIntNumbers() throws IOException {
        String[] line = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int[] parsedToInt = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        return parsedToInt;
    }

    public long readLongValue() throws IOException {
        String line = bufferedReader.readLine().replaceAll("\\s+$", "");
        long parsedToLong = Long.parseLong(line);
        return parsedToLong;
    }

    public long[] readLongNumbers() throws IOException {
        String[] line = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        long[] parsedToLong = Arrays.stream(line).mapToLong(Long::parseLong).toArray();
        return parsedToLong;
    }

}