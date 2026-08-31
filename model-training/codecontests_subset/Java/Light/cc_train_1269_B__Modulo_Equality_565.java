

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class problem2_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] a = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(a);
        int[] b = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(b);
        int[] array = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(a[i] <= b[0] ? b[0] - a[i] : m - (a[i] - b[0]));
        }
        list.sort(Comparator.naturalOrder());
        for(int x : list){
            for (int i = 0; i < n; i++) {
                array[i] = (a[i] + x) % m;
            }
            Arrays.sort(array);
            if(Arrays.equals(array, b)){
                System.out.println(x);
                return;
            }
        }


    }
}
