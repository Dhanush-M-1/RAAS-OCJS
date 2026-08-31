import java.util.HashMap;
import java.util.Scanner;


public class kString {
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private int k;
    private HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public void inputReader() {
        k = scanner.nextInt();
        input = scanner.next();
    }
    
    public void solve() {
        if(input.length()%k != 0) {
            System.out.println("-1");
            return;
        }
        for(char c : input.toCharArray()) {
            if(map.keySet().contains(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        for(int value : map.values()) {
            if(value %k != 0){
                System.out.println("-1");
                return;
            }
        }
        char[] res = new char[input.length()/k];
        int i = 0;
        for(char c : map.keySet()) {
            int j  = 0;
            while(j < map.get(c) / k) {
                res[i] = c;
                j++;
                i++;
            }
        }
        String str = new String(res);
        String result ="";
        for(int j = 0; j < k; j++)
            result+=str;
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        kString ks = new kString();
        ks.inputReader();
        ks.solve();
    }
}
