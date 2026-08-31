import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.rmi.MarshalException;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
//        int n = fs.nextInt();
        String a = fs.next();
        int []array = new int [(a.length()/2)+1];
        int index = 0;
        for(char c:a.toCharArray()){
            if(c!='+'){
                array[index] = Character.getNumericValue(c);
                index++;
            }
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length-1; i++) {
            System.out.print(array[i]+"+");
        }
        System.out.println(array[array.length-1]);
    }

    static void ruffle_sort(int arr[]){
        Random r = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int oi = r.nextInt(n);
            int temp = arr[i];
            arr[i] = arr[oi];
            arr[oi] = temp;
        }
        Arrays.sort(arr);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        public String next() {
            while (!st.hasMoreElements())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}
