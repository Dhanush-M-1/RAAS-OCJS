import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


public class Main {
    public static StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int read() throws IOException {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }


    public static void main(String[] args) throws IOException {
        int n=read();
        int k=read();
        int[] arr=new int[n];
        for (int i=0; i<n; i++){
            arr[i]=read();
        }
        int cnt=n;
        int[] counts=new int[1000000];
        for (int i=0; i<n; i++) counts[arr[i]-1]++;
        ArrayList<Integer> sizes=new ArrayList<Integer>();
        for (int i=0; i<1000000; i++){
            if (counts[i]!=0) sizes.add(i);
        }
        for (int i=0; i<sizes.size()-1; i++){
            if (sizes.get(i+1)<=sizes.get(i)+k) cnt-=counts[sizes.get(i)];
        }
        System.out.println(cnt);
    }

}

