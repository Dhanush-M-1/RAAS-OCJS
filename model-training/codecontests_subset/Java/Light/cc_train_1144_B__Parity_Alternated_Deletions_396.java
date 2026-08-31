import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> k[] = new ArrayList[2];
        k[0] = new ArrayList<>(); k[1] = new ArrayList<>();
        Integer a[] = new Integer[n];
        for(int i = 0; i<n; i++){
            a[i] = in.nextInt();
            k[a[i]%2].add(a[i]);
        }
        Collections.sort(k[0]);
        Collections.sort(k[1]);
        int d = Math.abs(k[0].size()-k[1].size());
       long s = 0;
       int t = 0;
       if(k[0].size()>k[1].size()) t = 0;
       else t = 1;
       for(int i = 0; i<d-1; i++){
           s+=k[t].get(i);
       }
       System.out.println(s);

    }


}