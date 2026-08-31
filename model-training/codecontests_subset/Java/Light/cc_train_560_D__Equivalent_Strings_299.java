import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquivalentStrings {
    public static boolean areEquivalent(String a, String b) {
        int l = a.length();
        if (a.equals(b))
            return true;
        if (l % 2 == 1)
            return a.equals(b);
        
        String a1 = a.substring(0, l / 2); String a2 = a.substring(l / 2);
        String b1 = b.substring(0, l / 2); String b2 = b.substring(l / 2);
        return case1(a1, a2 , b1 , b2) || case1(a2 , a1, b1, b2);
    }
    
    public static boolean case1(String a1 , String a2 , String b1 , String b2){
         return (areEquivalent(a1, b1) && areEquivalent(a2, b2)); 
    }
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (areEquivalent(br.readLine(), br.readLine()))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
