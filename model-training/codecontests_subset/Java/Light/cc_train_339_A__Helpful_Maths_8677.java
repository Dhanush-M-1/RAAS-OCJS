
import java.util.Scanner;

public class MatemSpeshit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char tmp=0;
        str=str.replace("+","");
        char [] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length - 1-i; j++) {
                if (ch[j] > ch[j + 1]) {
                    tmp = ch[j];
                    ch[j] = ch[j + 1];
                    ch[j + 1] = tmp;

                }
            }
        }
        for (int i = 0; i < ch.length; i++) {

            if(i!=ch.length-1) System.out.print(ch[i]+"+");
            else   System.out.print(ch[i]);

        }

    }
}
