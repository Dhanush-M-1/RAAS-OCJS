import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        long []ins = GetInput.getLongArrayInput();
        int n = (int) ins[0];  long k = ins[1];
        PriorityQueue<Long> both = new PriorityQueue<>();
        PriorityQueue<Long> alice = new PriorityQueue<>();
        PriorityQueue<Long> bob = new PriorityQueue<>();
        while(n-->0){
            long []array = GetInput.getLongArrayInput();
            if (array[1] == 1 && array[2] == 1){
                both.add(array[0]);
                continue;
            }
            if (array[1] == 1){
                alice.add(array[0]);
                continue;
            }
            if (array[2] == 1){
                bob.add(array[0]);
                continue;
            }
        }
        long time = 0;
        long books = k;
        boolean flag = false;
        if (both.size() + alice.size() <k || both.size() + bob.size()<k){
            System.out.println(-1);
            return;
        }

        while (books>0){
            if (both.peek() != null) {
                if (alice.peek()!=null && bob.peek()!=null) {
                    if (both.peek() < alice.peek() + bob.peek()) {
                        books--;
                        time += both.poll();
                        continue;
                    } else {
                        time += alice.poll() + bob.poll();
                        books--;
                        continue;
                    }
                }
                else {

                    time += both.poll();
                    books--;
                    continue;
                }
            }else {
                try {
                    time+=bob.poll()+alice.poll();
                    books--;
                }catch (NullPointerException e){
                    System.out.println(-1);
                }
            }
        }
        System.out.println(time);
    }

    static long fff(long key, long freq, long k){
        return key+1 + (freq-1)*(k);
    }

    static int rec(int sum, int n){
        if (n == 0){
            return sum;
        }
        return rec(n%10+sum, n/10);
    }
    static int foo(int n, int r) {
        if (n > 0) return (n % r + foo(n / r, r));
        else return 0;
    }

    private static long mod(long b) {
        if (b < 0) {
            return -b;
        }
        return b;
    }

    private static int findEnd(int i, int n, int b) {
        if ((i / b) + b > n - 1) {
            return n - 1;
        }
        return (i / b) + b - 1;
    }

    static int KnapSack(int val[], int wt[],
                        int n, int W) {
        // matrix to store final result
        int dp[][] = new int[2][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w)
                    dp[i % 2][w] = Math.max(dp[(i - 1) % 2][w], val[i - 1] + dp[(i - 1) % 2][w - wt[i - 1]]);
                else
                    dp[i % 2][w] = dp[(i - 1) % 2][w];
            }
        }

        return dp[n % 2][W];
    }

    //        String []arr = {"USA", "United States", "Washington", "California", "New York", "Los Angeles", "Florida", "Texas",
//                "Chicago", "Boston", "San Francisco", "Seattle", "Brooklyn", "San Diego" , "Michigan", "Colorado", "Austin", "Pennsylvania", "Philadelphia", "Ohio", "New Jersey", "Carolina"};
//        String []arr = {"Australia", "Sydney", "Melbourne", "Canberra"};
//        String []arr = {"Canada", "Ontario", "Ottawa", "Richmond", "Vancouver", "Alberta", "Toronto", "Victoria"};
//        String []arr = {"Australia", "Sydney", "Melbourne", "Canberra"};
//        String []arr = {"England", "London", "UK", "Britain", "Manchester"};
//        String []arr = {"India", "Delhi", "Bangalore", "Mumbai", "Chennai", "Pune", "Noida", "Gurgaon", "Kolkata"};
//        String []arr = {"New Zealand", "Auckland"};
////        String []arr = {"France", "Paris"};
//        File file = new File("/Users/jacksonjose/Downloads/HTTPclient-server-master/PractiseCompetitive/src/2018.csv");
//        processor(arr, file);
//        file = new File("/Users/jacksonjose/Downloads/HTTPclient-server-master/PractiseCompetitive/src/2019.csv");
//        processor(arr, file);
//    }
//
//    private static void processor(String []arr, File file) throws IOException {
//        Count c = grouper(arr, new Count(0,0,0), file);
//        System.out.println(arr[0]);
//        System.out.println("Total Count, " + (c.pos+c.neg));
//        System.out.println("-1, " + c.neg);
//        System.out.println("1, " + c.pos);

    private static int numerOftwos(int n) {
        int ans = 0;
        while (n % 2 == 0) {
            n /= 2;
            ans++;
        }
        return ans;
    }

    public static int oddPrimeFactors(int n) {
        while (n % 2 == 0) {
            n /= 2;
        }
        int ans = 0;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                n /= i;
                ans++;
            }
        }

        if (n > 2)
            ans++;
        return ans;
    }

    private static boolean onlyPowerOf2(int n) {
        if (n == 2) {
            return false;
        }
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }

//    private static Count grouper(String []key, Count c, File file) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(file));
//
//        String st;
//        st = br.readLine();
//        int i = 0;
//        while (st!=null){
//            String []strings = st.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//            if (isKeyContained(strings[0], key)){
//                st = br.readLine();
//                strings = st.split(",");
//                if (isNumeric(strings[0])){
//                    int num = Integer.parseInt(strings[0]);
//                    if (num == -1){
//                        c.neg += Integer.parseInt(strings[1]);
//                    }
//                    else {
//                        c.pos += Integer.parseInt(strings[1]);
//                    }
//                }
//                else {
//                    continue;
//                }
//                st = br.readLine();
//                strings = st.split(",");
//                if (isNumeric(strings[0])){
//                    int num = Integer.parseInt(strings[0]);
//                    if (num == -1){
//                        c.neg += Integer.parseInt(strings[1]);
//                    }
//                    else {
//                        c.pos += Integer.parseInt(strings[1]);
//                    }
//                }
//            }
//            st = br.readLine();
//        }
//        return c;
//    }

//    private static boolean isKeyContained(String string, String[] key) {
//        for (String str : key){
//            if (string.contains(str)){
//                return true;
//            }
//        }
//        return false;
//    }

//    private static boolean isNumeric(String str) {
//        return str.matches("-?\\d+(\\.\\d+)?");
//    }


    private static boolean isMultiple(double i, double x) {
        if (x % i == 0) {
            return false;
        }
        return true;
    }

    private static int ff(long num) {
        return (int) (num % (1000000007));
    }

    private static boolean notOverlap(long[] t1, long[] t2) {
        return t1[0] >= t2[1];
    }


    private static long max(long in, long in1) {
        if (in > in1) {
            return in;
        }
        return in1;
    }

    private static long min(long in, long in1) {
        if (in > in1) {
            return in1;
        }
        return in;
    }

}


class GetInput {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static char[] getCharArray() {
        char[] charArray;
        try {
            StringBuilder string = getInputString();
            charArray = new char[string.length()];
            for (int i = 0; i < string.length(); i++) {
                charArray[i] = string.charAt(i);
            }
            return charArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        charArray = new char[0];
        return charArray;
    }

    static int[] getArrayInt() {
        String[] string;
        int[] array;
        try {
            string = bufferedReader.readLine().split("\\s+");
            array = new int[string.length];
            for (int i = 0; i < string.length; i++) {
                array[i] = Integer.parseInt(string[i]);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arra = new int[2];
        return arra;
    }

    static int getInt() {
        try {
            String string = bufferedReader.readLine();
            return Integer.parseInt(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    static StringBuilder getInputString() {
        try {
            StringBuilder string = new StringBuilder();
            string.append(bufferedReader.readLine());
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new StringBuilder();
    }

    static long getLongInput() {
        try {
            String string = bufferedReader.readLine();
            return Long.parseLong(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    static long[] getLongArrayInput() {
        String[] string;
        long[] array;
        try {
            string = bufferedReader.readLine().split("\\s+");
            array = new long[string.length];
            for (int i = 0; i < string.length; i++) {
                array[i] = Long.parseLong(string[i]);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }

        long[] arra = new long[2];
        return arra;
    }


    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}

class HeapSort {
    void sort(long[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            long temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(long[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            long swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
