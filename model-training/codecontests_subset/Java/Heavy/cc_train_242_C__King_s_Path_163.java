import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Short.parseShort;
import static java.lang.Byte.parseByte;
import java.io.*;
import java.util.*;

public class Main {

    static int nextInt() throws IOException {
        return parseInt(next());
    }

    static long nextLong() throws IOException {
        return parseLong(next());
    }

    static short nextShort() throws IOException {
        return parseShort(next());
    }

    static byte nextByte() throws IOException {
        return parseByte(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens())
            tok = new StringTokenizer(in.readLine());
        return tok.nextToken();
    }

    static String nextLine() throws IOException {
        return in.readLine();
    }

    private static BufferedReader in;
    private static StringTokenizer tok;
    private static PrintWriter out = new PrintWriter(System.out);
    private static Utilities doThis = new Utilities(out);
    private static MyMath doMath = new MyMath();
    private static NextPermutation permute = new NextPermutation();

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));

        /*--------------------SolutionStarted-------------------*/
        solve();
        /*--------------------SolutionEnded--------------------*/

        in.close();
        out.close();
    }

    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static long longMax = Long.MAX_VALUE, longMin = Long.MIN_VALUE, longSum = 0, longCount;

    static void solve() throws IOException {
        validMoves = new Pair[8];
        int x1 = nextInt(), y1= nextInt();
        Pair startPosition = new Pair(x1, y1);
        int x2 = nextInt(), y2 = nextInt();
        Pair finalPosition = new Pair(x2,y2);
        int n = nextInt(), r, from, to;

        HashSet<Pair> rows = new HashSet<>();
        for (int i = 0; i < n; i++) {
            r = nextInt();
            from = nextInt();
            to = nextInt();

            for (int k = from; k <= to; k++) {
                rows.add(new Pair(r, k));
            }
        }
        rows.add(startPosition);
        rows.add(finalPosition);

        HashSet<Pair> visited = new HashSet<>();
        Queue<Pair> moves = new LinkedList<>();

        moves.add(startPosition);
        visited.add(startPosition);

        Pair currentPosition;
        int move;

        while (!moves.isEmpty()) {

            currentPosition = moves.poll();
            move = currentPosition.getMoves();
            if (currentPosition.equals(finalPosition)) {
                out.println(move);
                return;
            }

            setValidMoves(currentPosition);

            for (int i = 0; i < idx; i++) {

                if (visited.contains(validMoves[i]) || !(rows.contains(validMoves[i])))
                    continue;

                Pair square =
                        new Pair(validMoves[i].getFirst(), validMoves[i].getSecond(), move + 1);
                visited.add(square);
                moves.add(square);
            }
        }
        out.println(-1);
    }
    static Pair [] validMoves;
    static int idx;
    static void setValidMoves(Pair point) {
        int x = point.getFirst();
        int y = point.getSecond();
        idx = 0;

        //Top side
        if (x - 1 >= 1) {
            validMoves[idx] = new Pair((x-1), y);
            idx++;
            if (y + 1 <= (1000_000_000)) {
                validMoves[idx] = new Pair((x-1), y+1);
                idx++;
            }
            if (y - 1 >= 1) {
                validMoves[idx] = new Pair((x-1), (y-1));
                idx++;
            }
        }
        //Down side
        if (x + 1 <= (1000_000_000)) {
            validMoves[idx] = new Pair((x+1), y);
            idx++;
            if (y + 1 <= (1000_000_000)) {
                validMoves[idx] = new Pair((x+1), (y+1));
                idx++;
            }
            if (y - 1 >= 1) {
                validMoves[idx] = new Pair((x+1), (y-1));
                idx++;
            }
        }
        //Right side
        if (y + 1 <= (1000_000_000)) {
            validMoves[idx] = new Pair((x), (y+1));
            idx++;
        }
        //Left side
        if (y - 1 >= 1) {
            validMoves[idx] = new Pair((x), (y-1));
            idx++;
        }
    }
}
class Pair{
    int first;
    int second;
    int moves;
    private final int HASH;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
        HASH = first*13+second;
    }
    Pair(int first, int second, int m){
        this.first = first;
        this.second = second;
        moves = m;
        HASH = first*13+second;
    }

    int getFirst(){
        return first;
    }

    int getSecond(){
        return second;
    }
    int getMoves(){
        return moves;
    }
    @Override
    public boolean equals(Object o){
        Pair other = (Pair) o;
        if (first == other.first && second == other.second)
            return true;
        return false;
    }

    @Override
    public String toString(){
        return first +" "+ second;
    }
    @Override
    public int hashCode(){
        return HASH;
    }
}
class XPair implements Comparable<XPair>{
    int s, e;
    XPair(int start,int end){
        this.s = start;
        this.e =   end;
    }
    XPair( int i){
        s=i;
    }

    @Override
    public int compareTo(XPair o) {
        return e -o.e;
    }
}
class CharPair{
    char ch;
    int value;
    CharPair(char c, int v){
        ch =c; value=v;
    }
    char get(){
        return ch;
    }
}
class IntPair implements Comparable<IntPair> {
    int key, value;

    IntPair(int key, int value) {
        this.key =  key;
        this.value = value;
    }

    @Override
    public int compareTo(IntPair o) {
        if (value == o.value)
            return key - o.key;
        return value - o.value;
    }

    public String toString() {
        return key + " " + value;
    }
}
class BooleanPair {
    boolean key, value;

    BooleanPair() {
    }

    BooleanPair(boolean key, boolean value) {
        this.key = key;
        this.value = value;
    }
}
class Utilities {
    PrintWriter out;
    Utilities(PrintWriter out){
        this.out = out;
    }
    //int arrays start
    int lowerBound(int[] arr, int low, int high, int element) {
        int middle;
        while (low < high) {
            middle = low + (high - low) / 2;
            if (element > arr[middle])
                low = middle + 1;
            else
                high = middle;
        }
        if (arr[low] < element)
            return -1;
        return low;
    }

    int upperBound(int[] arr, int low, int high, int element) {
        int middle;
        while (low < high) {
            middle = low + (high - low) / 2;
            if (arr[middle] > element)
                high = middle;
            else
                low = middle + 1;
        }
        if (arr[low] <= element)
            return -1;
        return low;
    }
    //int arrays end
    //long arrays start
    int lowerBound(long[] arr, int low, int high, long element) {
        int middle;
        while (low < high) {
            middle = low + (high - low) / 2;
            if (element > arr[middle])
                low = middle + 1;
            else
                high = middle;
        }
        if (arr[low] < element)
            return -1;
        return low;
    }

    int upperBound(long[] arr, int low, int high, long element) {
        int middle;
        while (low < high) {
            middle = low + (high - low) / 2;
            if (arr[middle] > element)
                high = middle;
            else
                low = middle + 1;
        }
        if (arr[low] <= element)
            return -1;
        return low;
    }
    //long arrays end
    //double arrays start
    int lowerBound(double[] arr, int low, int high, double element) {
        int middle;
        while (low < high) {
            middle = low + (high - low) / 2;
            if (element > arr[middle])
                low = middle + 1;
            else
                high = middle;
        }
        if (arr[low] < element)
            return -1;
        return low;
    }

    int upperBound(double[] arr, int low, int high, double element) {
        int middle;
        while (low < high) {
            middle = low + (high - low) / 2;
            if (arr[middle] > element)
                high = middle;
            else
                low = middle + 1;
        }
        if (arr[low] <= element)
            return -1;
        return low;
    }
    //double arrays end
    int arrUp(int [][]arr,int i, int j){
        if(i<=0)
            return Integer.MIN_VALUE;
        return arr[i-1][j];
    }
    int arrDown(int [][]arr,int i, int j){
        if(i>=arr.length-1)
            return Integer.MIN_VALUE;
        return arr[i+1][j];
    }
    int arrLeft(int [][]arr,int i, int j){
        if(j<=0)
            return Integer.MIN_VALUE;
        return arr[i][j-1];
    }
    int arrRight(int [][]arr,int i, int j){
        if(j>=arr[i].length-1)
            return Integer.MIN_VALUE;
        return arr[i][j+1];
    }
    //////////////////

    char arrUp(char [][]arr,int i, int j){
        if(i<=0)
            return '\0';
        return arr[i-1][j];
    }
    char arrDown(char [][]arr,int i, int j){
        if(i>=arr.length-1)
            return '\0';
        return arr[i+1][j];
    }
    char arrLeft(char [][]arr,int i, int j){
        if(j<=0)
            return '\0';
        return arr[i][j-1];
    }
    char arrRight(char [][]arr,int i, int j){
        if(j>=arr[i].length-1)
            return '\0';
        return arr[i][j+1];
    }
    int count(char[] s, char c){
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i]==c)
                count++;
        }
        return count;
    }
    void swap(char[] s, int a,int b){
        char temp =s[b];
        s[b]= s[a];
        s[a] = temp;
    }
    boolean odd(int a){
        return (a&1)==1;
    }
    boolean even(int a){
        return (a&1)==0;
    }
    void yes(){
        out.println("YES");
    }
    void no() {
        out.println("NO");
    }
    void bad(){
        out.println(-1);
    }
    void printBinary(int num){
        out.println(Integer.toBinaryString(num));
    }

    void printArray(int arr[], int start, int end){
        for (int i = start; i <end ; i++) {
            out.print(arr[i]+" ");
        }
    }
}
class MyMath {
    boolean isCoPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    int gcd(int a, int b) {
        if (a == 0)
            return b;
        while (b != 0)
            if (a > b)
                a = a - b;
            else
                b = b - a;
        return a;
    }

    long gcd(long a, long b) {
        if (a == 0)
            return b;
        while (b != 0)
            if (a > b)
                a = a - b;
            else
                b = b - a;
        return a;
    }

    int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
    boolean[] sieveOfEratosthenes(int n) {
        // Create a boolean array "primes[0..n]" and initialize
        // all entries it as true. A value in primes[i] will
        // finally be false if i is Not a primes, else true.
        boolean primes[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            primes[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If primes[p] is not changed, then it is a primes
            if(primes[p])
            {
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p)
                    primes[i] = false;
            }
        }
        return primes;
    }
}
class NextPermutation {

    // Function to swap the data
    // present in the left and right indices
    private int[] swap(int data[], int left, int right) {

        // Swap the data
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;

        // Return the updated array
        return data;
    }

    // Function to reverse the sub-array
    // starting from left to the right
    // both inclusive
    private int[] reverse(int data[], int left, int right) {

        // Reverse the sub-array
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }

        // Return the updated array
        return data;
    }

    // Function to find the next permutation
    // of the given integer array
    boolean findNextPermutation(int data[]) {

        // If the given data-set is empty
        // or contains only one element
        // next_permutation is not possible
        if (data.length <= 1)
            return false;

        int last = data.length - 2;

        // find the longest non-increasing suffix
        // and find the pivot
        while (last >= 0) {
            if (data[last] < data[last + 1]) {
                break;
            }
            last--;
        }

        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0)
            return false;

        int nextGreater = data.length - 1;

        // Find the rightmost successor to the pivot
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }

        // Swap the successor and the pivot
        data = swap(data, nextGreater, last);

        // Reverse the suffix
        data = reverse(data, last + 1, data.length - 1);

        // Return true as the next_permutation is done
        return true;
    }
}