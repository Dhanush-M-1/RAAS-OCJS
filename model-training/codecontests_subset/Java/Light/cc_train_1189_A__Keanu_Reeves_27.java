import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KeanuReeves {

    static int n = 0;
    static String str = "";
    static int counter = 0;
    static int c=1;
    static List<Character> list = new ArrayList();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        str = in.next();
        StringBuffer sb = new StringBuffer();
        if (n == 2 && count('1',str) == count('0',str)){
        System.out.println(2);
        sb.append(str.charAt(0));
        sb.append(' ');
        sb.append(str.charAt(1));
        System.out.print(sb);
        }
        else if (count('1',str) != count('0',str)){
        System.out.println(1);
        System.out.print(str);
        } else {
        char c = str.charAt(str.length()-1);
        sb.append(str);
        sb.deleteCharAt(str.length()-1);
        sb.append(' ');
        sb.append(c);
        System.out.println(2);
        System.out.print(sb);
        }     
    
    
    }

    public static int count(char ch, String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
//System.out.println("c "+c);
                c += 1;
            }
        }
        return c;

    }
}
