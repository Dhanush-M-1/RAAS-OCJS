import java.util.Scanner;
public class d {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String s = in.next().toLowerCase();
        String r = "";
        int n = in.nextInt();


        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c < n + 97) {
                r+= s.substring(i,i+1).toUpperCase();
            } else {
                r+= s.substring(i,i+1).toLowerCase();
            }
        }
        
        System.out.println(r);
    }
}