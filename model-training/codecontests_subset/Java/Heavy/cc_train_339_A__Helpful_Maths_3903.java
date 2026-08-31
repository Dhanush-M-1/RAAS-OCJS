
import java.util.Arrays;
import java.util.Scanner;

public class A339 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '+') {
                b += a.charAt(i);
            }
        }
        int[] c = new int[b.length()];
        for (int i = 0; i < b.length(); i++) {
            c[i] = b.charAt(i);
        }
        Arrays.sort(c);
        for(int i = 0; i < b.length();i++){
            System.out.print(c[i] - 48);
            if(i < b.length()-1){
                System.out.print("+");
            }
        }
    }

}
