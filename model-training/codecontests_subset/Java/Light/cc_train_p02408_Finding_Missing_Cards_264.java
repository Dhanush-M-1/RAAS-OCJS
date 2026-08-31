import java.util.*;
import java.text.*;

class Main {
    public static void main(String[]args)throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [][] has = new boolean[4][13];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String [] ss = new String [] {"S", "H", "C", "D"};
        for(int i = 0; i < ss.length; i++) {
            map.put(ss[i], i);
        }
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            int k = sc.nextInt();
            has[map.get(s)][k-1] = true;
        }
        for(int i = 0; i < 4; i++) {
            for(int k = 0; k < 13; k++) {
                if(!has[i][k]) System.out.println(ss[i] + " " + (k+1));
            }
        }
    }
}