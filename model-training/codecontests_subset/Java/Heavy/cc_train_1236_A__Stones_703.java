import javax.print.DocFlavor;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.IllegalCharsetNameException;
import java.util.*;



public class Main {



    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        //solve();
        int n = Reader.nextInt();
        while (n-->0){
            int n1 = Reader.nextInt();
            int n2 = Reader.nextInt();
            int n3 = Reader.nextInt();
            int ans = 0;
            while (n2>0){
                if (n2>0 && n3>1){
                    n2--;
                    n3-=2;
                    ans+=3;
                }
                else if (n2>1 && n1>0){
                    n2-=2;
                    n1--;
                    ans+=3;
                }
                else{
                    break;
                }
            }
            System.out.println(ans);
        }

    }
    static long get(long[] a , long[] b){
        long sum = 0;
        for (int i = 0 ; i < 3 ; i++){
            sum+=(a[i]-b[i])*(a[i]-b[i]);
        }
        return sum;
    }

    static void solve() throws IOException{



    }

    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }

    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else if (entry1[col] == entry2[col]){
                    if (entry1[col+1] > entry2[col+1])
                        return 1;
                    else if (entry1[col+1] == entry2[col+1]){
                        if (entry1[col+2] > entry2[col+2])
                            return 1;
                        else return -1;
                    }
                    else{
                        return -1;
                    }
                }
                else
                    return -1;
            }
        });  // End of function call sort().
    }

















}

class Edge implements Comparable<Edge>{
    int x , y , w;

    public Edge(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method

}

class Node implements Comparable<Node>{
    int a;
    int b;
    Node (int a , int b){
        this.a = a;
        this.b = b;
    }



    public int compareTo(Node o) {
        if (this.a != o.a) {
            return this.a - o.a;
        }
        else{
            return this.b - o.b;
        }
    }
}