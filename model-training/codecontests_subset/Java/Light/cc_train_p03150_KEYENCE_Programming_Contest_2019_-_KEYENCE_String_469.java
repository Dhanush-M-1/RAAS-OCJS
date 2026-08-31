import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        boolean ans = false;
        String k = "keyence";
        int diff = s.length() -7;
        for(int i = 0; i <= s.length() -diff; i++){
            if(i == 0){
                if(k.equals(s.substring(diff))) ans = true;
            }else if(i == s.length() -diff){
                if(k.equals(s.substring(0, s.length() -diff))) ans = true;
            }else{
                if(k.equals(s.substring(0, i) + s.substring(i+diff, s.length()))) ans = true;
            }
        }
        if(ans) System.out.println("YES");
        else System.out.println("NO");

    }

}
