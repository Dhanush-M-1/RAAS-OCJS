import java.awt.Point;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

import org.omg.PortableInterceptor.INACTIVE;


import static java.lang.Math.*;

public class Start {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    public static void main(String[] args) {
        new Start().run();
        // Sworn to fight and die
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int levtIndex, int rightIndex) {
        final int MAGIC_VALUE = 50;
        if (levtIndex < rightIndex) {
            if (rightIndex - levtIndex <= MAGIC_VALUE) {
                insertionSort(a, levtIndex, rightIndex);
            } else {
                int middleIndex = (levtIndex + rightIndex) / 2;
                mergeSort(a, levtIndex, middleIndex);
                mergeSort(a, middleIndex + 1, rightIndex);
                merge(a, levtIndex, middleIndex, rightIndex);
            }
        }
    }

    private static void merge(int[] a, int levtIndex, int middleIndex,
            int rightIndex) {
        int length1 = middleIndex - levtIndex + 1;
        int length2 = rightIndex - middleIndex;
        int[] levtArray = new int[length1];
        int[] rightArray = new int[length2];
        System.arraycopy(a, levtIndex, levtArray, 0, length1);
        System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
        for (int k = levtIndex, i = 0, j = 0; k <= rightIndex; k++) {
            if (i == length1) {
                a[k] = rightArray[j++];
            } else if (j == length2) {
                a[k] = levtArray[i++];
            } else {
                a[k] = levtArray[i] <= rightArray[j] ? levtArray[i++]
                        : rightArray[j++];
            }
        }
    }

    private static void insertionSort(int[] a, int levtIndex, int rightIndex) {
        for (int i = levtIndex + 1; i <= rightIndex; i++) {
            int current = a[i];
            int j = i - 1;
            while (j >= levtIndex && a[j] > current) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;
        }
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    class LOL implements Comparable<LOL> {
        int x;
        int y;
        int num;

        public LOL(int x, int y,int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(LOL o) {
            return x - o.x; // ---->
            // return o.x - x; // <----
            // return o.y-y;
        }

    }
    
    
    
    public void solve() throws IOException {
    
        String s = readString();
        int n = s.length(); 
        char [] c = s.toCharArray();
        

        
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
         TreeSet<String> keys = new TreeSet<String>();

        String mir = "dd-mm-yyyy";
        for (int i = 0 ;  i <= n-mir.length(); i++){
            StringBuilder nothing = new StringBuilder("");
            for (int j = i; j < i+mir.length(); j++){
                nothing.append(c[j]);
            }
            String key = nothing.toString();
            if (check(key)){
                if (!keys.contains(key)){
                    keys.add(key);
                    map.put(key,1);
                }
                else {
                    map.put(key,map.get(key)+1);
                    
                }
            }
        }
        int ans = 0;
        String ansGrey = "";
        while(!keys.isEmpty()){
            String Grey = keys.pollFirst();
            if (map.get(Grey) > ans){
                ans = map.get(Grey);
                ansGrey = Grey;
            }
        
        }
        out.print(ansGrey);
        
    }
    
   boolean check(String s){
       //                   0  1  2  3  4  5  6  7  8  9 10 11 12
       int [] dayOfMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
       int tire = 0; 
       int n = s.length();
       String mir = "dd-mm-yyyy";
       for (int i = 0; i <n; i++){
           if (s.charAt(i)=='-') tire++;
       }
       if (s.length() != mir.length()){
           return false;
       }
       if (tire == 2 && s.charAt(2)=='-' && s.charAt(5)=='-'){
           //
       }
       else return false;
       
       String [] ololo = s.split("-");
       if (ololo.length != 3) return false;
       if (ololo[2].compareTo("2013")>=0 && ololo[2].compareTo("2015")<=0)
       {
           if (ololo[1].compareTo("01")>=0 && ololo[1].compareTo("12")<=0){
               if (ololo[0].compareTo("01") >= 0 
                       && 
                   ololo[0].compareTo
                   (Integer.toString(dayOfMonth[Integer.parseInt(ololo[1])]))<=0){
                     return true;
                   }  
           }
       }
       return false;
    }
    
    
}

