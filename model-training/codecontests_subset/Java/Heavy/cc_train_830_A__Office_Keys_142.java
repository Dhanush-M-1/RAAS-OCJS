
import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()),
            k = Integer.parseInt(st.nextToken()),
            p = Integer.parseInt(st.nextToken());
        int[] people = new int[n];
        int[] keys = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) people[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<k ; i++) keys[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(people);
        Arrays.sort(keys);
        long shortest = Long.MAX_VALUE;
        for (int i=0 ; i+n<=k ; i++) {
            long distance = 0;
            for (int j=0 ; j<n ; j++) {
                distance = Math.max(distance, Math.abs(people[j]-keys[i+j]) + Math.abs(keys[i+j]-p));
            }
            //    System.out.println("distance:" + distance);
            shortest = Math.min(distance, shortest);
        }
        System.out.println(shortest);
    }
}


