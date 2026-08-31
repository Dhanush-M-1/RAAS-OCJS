import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Compiler {
    static void merge(int arr[], int l, int m, int r)
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
    static void sort(int arr[], int l, int r)
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
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        int n = Reader.nextInt();
        int[] arr = new int[n];
        int[] copy1 = new int[n-1];
        int[] copy2 = new int[n-2];
        for(int i=0; i<n; i++){
            arr[i] = Reader.nextInt();
        }
        for(int i=0; i<n-1; i++){
            copy1[i] = Reader.nextInt();
        }
        for(int i=0; i<n-2; i++){
            copy2[i] = Reader.nextInt();
        }
        sort(arr,0,n-1);
        sort(copy1,0,n-2);
        sort(copy2, 0, n-3);


        int sg = 0;
        int ag = 0;
        for(int i=0; i<n-1; i++) {
            if(arr[i]!=copy1[i]){
                if(sg==0) {
                    System.out.println(arr[i]);
                }
                sg = 1;
            }
        }
        if(sg==0){
            System.out.println(arr[n-1]);
        }
        for(int i=0; i<n-2; i++){
            if(copy1[i]!=copy2[i]){
                if(ag==0) {
                    System.out.println(copy1[i]);
                }
                ag = 1;
            }
        }
        if(ag==0){
            System.out.println(copy1[n-2]);
        }
    }
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}