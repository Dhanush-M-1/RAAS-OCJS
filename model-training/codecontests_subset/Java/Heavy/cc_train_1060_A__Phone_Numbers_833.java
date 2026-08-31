import com.sun.jndi.cosnaming.CNCtx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

/**
 *
 * @author Ahmad
 */
public class JavaApplication1 {
    
   public static void main(String[] args) throws FileNotFoundException, IOException {
    FastReader console = new FastReader() ;
    int n = console.nextInt() ; 
    String x = console.next() ; 
    int count = 0 ;
    for (int i=0 ; i<n/11 ; i++){
        x=x.replaceFirst("8", "+") ;
    }
    for (int i=0 ; i<x.length() ; i++){
        if (x.charAt(i)=='+'){
            count++ ; 
        }
    }
    x=x.replace("+", "") ;
    int countt = 0 ; 
    int e = 0 ; 
    for (int i=0 ; i<x.length() ; i++){
        countt ++ ; 
        if (countt==10&&count!=0){
            e++ ;
            countt=0 ;
            count-- ;
        }
    }
       System.out.println(e);
   }
}
class Sorting {

    public static int[] bucketSort(int[] array, int bucketCount) {

        if (bucketCount <= 0) {
            throw new IllegalArgumentException("Invalid bucket count");
        }

        if (array.length <= 1) {
            return array; //trivially sorted
        }

        int high = array[0];

        int low = array[0];

        for (int i = 1; i < array.length; i++) { //find the range of input elements

            if (array[i] > high) {
                high = array[i];
            }

            if (array[i] < low) {
                low = array[i];
            }

        }

        double interval = ((double) (high - low + 1)) / bucketCount; //range of one bucket

        ArrayList<Integer> buckets[] = new ArrayList[bucketCount];

        for (int i = 0; i < bucketCount; i++) { //initialize buckets

            buckets[i] = new ArrayList();

        }

        for (int i = 0; i < array.length; i++) { //partition the input array

            buckets[(int) ((array[i] - low) / interval)].add(array[i]);

        }

        int pointer = 0;

        for (int i = 0; i < buckets.length; i++) {

            Collections.sort(buckets[i]); //mergeSort

            for (int j = 0; j < buckets[i].size(); j++) { //merge the buckets

                array[pointer] = buckets[i].get(j);

                pointer++;

            }

        }

        return array;

    }

    static void bucketSort(long[] x, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    FastReader(InputStream in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
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

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}