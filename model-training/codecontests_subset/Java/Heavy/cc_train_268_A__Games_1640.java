import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
 
public class Games {
    public static Scanner in;
    public static void main(String[] args) throws FileNotFoundException {
        //PrintStream o = new PrintStream(new File("A.txt"));System.setOut(o);
        in = new Scanner(System.in);
        solve();
    }
    
    private static void solve() {
        int n = ni();
        ArrayList<Integer> home = new ArrayList<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int total=0;
        for(int i=0;i<n;i++){
            int h = ni();
            int a = ni();
            home.add(h);
            if(hm.containsKey(a))
                hm.put(a,hm.get(a)+1);
            else
                hm.put(a,1);
        }
        // System.out.println(home);
        // System.out.println(hm);
        Iterator<Integer> homeIterator = home.iterator();
        while(homeIterator.hasNext()){
            int temp =homeIterator.next();
            if(hm.containsKey(temp))
                total+=hm.get(temp);
        }
        
        System.out.println(total);
    }
    
    private static int ni() {
        return in.nextInt();
    }
    
    private static int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }
    
    private static long[] nal(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nl();
        return a;
    }
    
    private static long nl() {
        return in.nextLong();
    }
    
    private float nf() {
        return in.nextFloat();
    }
    
    private static double nd() {
        return in.nextDouble();
    }
}