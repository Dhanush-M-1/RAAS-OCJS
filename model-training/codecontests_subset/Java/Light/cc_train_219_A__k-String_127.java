import java.util.*;

public class NewClass1 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int k=in.nextInt();
        String s=in.next();
        int a[]=new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[(int)s.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(a[i]%k!=0){
                System.out.println("-1");
                return;
            }
        }
        String t="";
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < a[i]/k; j++) {
                t+=""+(char)(i+(int)'a');
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(t);
        }
    }
}