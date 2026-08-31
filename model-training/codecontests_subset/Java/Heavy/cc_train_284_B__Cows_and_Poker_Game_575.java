import java.util.*;
import java.math.*;
import java.io.*;

public class input2 {
    public static int id[] = new int[60005];

    public static void init() {
        for (int i = 0; i < 60005; i++) {
            id[i] = i;
        }
    }

    public static int root(int x) {
        while (id[x] != x) {
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }

    public static void union(int x, int y) {
        int p = root(x);
        int q = root(y);
        id[p] = id[q];
    }

    public static long kruskal(ArrayList<ArrayList<Integer>> A) {
        long min = 0;
        Collections.sort(A, new sort());
        int x, y;
        int cost = 0;
        for (int i = 0; i < A.size(); i++) {
            x = A.get(i).get(0);
            y = A.get(i).get(1);
            cost = A.get(i).get(2);
            System.out.println("I am cost : " + cost);
            System.out.println("I am root x : " + x + " " + root(x));
            System.out.println("I am root y : " + root(y));
            if (root(x) != root(y)) {
                min += cost;
                union(x, y);
            }
        }
        return min;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s= br.readLine();
        int A = 0;
        int I = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'A')A++;
            else if(s.charAt(i) == 'I')I++;
        }
        if(I == 0){
            System.out.println(A);
        }
        else {
            if(I == 1){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }

    static class sort implements Comparator<ArrayList<Integer>> {

        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            int c = o1.get(2).compareTo(o2.get(2));
            return c;
        }

    }
}