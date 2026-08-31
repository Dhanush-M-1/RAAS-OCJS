import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Pattern p1 = Pattern.compile("^.+keyence$");
        Pattern p2 = Pattern.compile("^k.+eyence$");
        Pattern p3 = Pattern.compile("^ke.+yence$");
        Pattern p4 = Pattern.compile("^key.+ence$");
        Pattern p5 = Pattern.compile("^keye.+nce$");
        Pattern p6 = Pattern.compile("^keyen.+ce$");
        Pattern p7 = Pattern.compile("^keyenc.+e$");
        Pattern p8 = Pattern.compile("^keyence.+$");
        Pattern p9 = Pattern.compile("^keyence$");

        boolean isMatch = p1.matcher(s).matches();
        if(!isMatch) isMatch = p2.matcher(s).matches();
        if(!isMatch) isMatch = p3.matcher(s).matches();
        if(!isMatch) isMatch = p4.matcher(s).matches();
        if(!isMatch) isMatch = p5.matcher(s).matches();
        if(!isMatch) isMatch = p6.matcher(s).matches();
        if(!isMatch) isMatch = p7.matcher(s).matches();
        if(!isMatch) isMatch = p8.matcher(s).matches();
        if(!isMatch) isMatch = p9.matcher(s).matches();

        String ans = isMatch ? "YES" : "NO";
        System.out.println(ans);
    }
}
