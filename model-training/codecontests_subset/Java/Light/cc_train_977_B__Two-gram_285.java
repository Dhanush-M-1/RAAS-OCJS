import java.util.HashMap;
import java.util.Scanner;

public class Nafis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        String res = "";
        for(int i=0; i<n-1; i++){
            String sub = str.substring(i,i+2);
            int k = map.getOrDefault(sub, 0) + 1;
            if ( k > max ){
                max = k;
                res = sub;
            }
            map.put(sub, k);
        }
        System.out.println(res);

    }
}