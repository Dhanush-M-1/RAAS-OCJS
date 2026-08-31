/**
 * practice
 */
import java.util.Scanner;
public class practice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s1 = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1')
                s1 = s1 + "1+";
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='2')
                s1 = s1 + "2+";
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='3')
                s1 = s1 + "3+";
        }
        String s2 = "";
        for(int i=0; i<s.length(); i++){
            s2 += s1.charAt(i);
        }
        System.out.println(s2);
    }
}