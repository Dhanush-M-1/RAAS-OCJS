import java.io.*;
import java.util.*;

public class Main { 
    static int needed, speed, len, total;
    public static void main(String[] args) throws IOException { 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            needed = Integer.parseInt(st.nextToken());
            speed = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());
            total = len*needed;
            System.out.println(binarySearch());
        }
    }
    public static long binarySearch() { 
        long lo = 0, hi = 1000000009, med;
        while (lo<hi) {
            med = (hi+lo)/2;
            if (ok(med))
                hi = med;
            else
                lo = med+1;
        }
        return lo;
    }
    public static boolean ok(long med) { 
        return med*speed + len*speed >= total;
    }
}

            

