import java.util.Scanner;

import javax.xml.XMLConstants;
public class stringInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = in.nextLine();
        String y = "";
        for(int i = 0; i <= x.length(); i+= 2) {
            if(x.charAt(i) == '1') {
                y += "+";
                y += "1";
            }
        }
        for(int i = 0; i <= x.length(); i+= 2) {
            if(x.charAt(i) == '2') {
                y += "+";
                y += "2";
            }
        }
        for(int i = 0; i <= x.length(); i+= 2) {
            if(x.charAt(i) == '3') {
                y += "+";
                y += "3";
            }
        }
        y = y.substring(1, y.length());
        System.out.println(y);
    }
}