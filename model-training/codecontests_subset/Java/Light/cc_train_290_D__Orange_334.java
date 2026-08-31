import java.util.Scanner;


public class Puzzle {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String S = scan.next();
        int num = scan.nextInt();
        S = S.toLowerCase();
        char c;
        String out = "";
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if(c < num + 97)
                out = out + (char)((char) c - 32);
            else
                out = out + c;
        }
        System.out.println(out);
        
        scan.close();
        

    }

}
