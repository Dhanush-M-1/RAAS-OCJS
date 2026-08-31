import java.util.Scanner;

public class HelpfulMath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        StringBuilder sb = new StringBuilder();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        if (s.length() == 1){
            System.out.println(s);
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '+'){
                    if (s.charAt(i) == '1'){
                        count1++;
                    } else if (s.charAt(i) == '2'){
                        count2++;
                    } else if (s.charAt(i) == '3'){
                        count3++;
                    }
                }
            }
        }
        for (int i = 0; i < count1; i++) {
            sb.append("1+");
        }
        for (int i = 0; i < count2; i++) {
            sb.append("2+");
        }
        for (int i = 0; i < count3; i++) {
            sb.append("3+");
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < sb.length()-1; i++) {
            out.append(sb.charAt(i));
        }
        System.out.println(out);
    }
}