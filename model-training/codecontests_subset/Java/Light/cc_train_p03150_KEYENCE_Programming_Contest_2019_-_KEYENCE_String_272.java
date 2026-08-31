import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        List<String> mylist = new ArrayList<>();

        // 標準入力からの値を変数strinputに代入
        String strinput = reader.readLine();

        while (strinput != null) {

            mylist.add(strinput);
            strinput = reader.readLine();

        }

        String s = mylist.get(0);
        Boolean chkflg = false;

        if (s.substring(0, 7).equals("keyence")) {
            chkflg = true;
        } else if (s.substring(0, 1).equals("k") && s.substring(s.length() - 6).equals("eyence")) {
            chkflg = true;
        } else if (s.substring(0, 2).equals("ke") && s.substring(s.length() - 5).equals("yence")) {
            chkflg = true;
        } else if (s.substring(0, 3).equals("key") && s.substring(s.length() - 4).equals("ence")) {
            chkflg = true;
        } else if (s.substring(0, 4).equals("keye") && s.substring(s.length() - 3).equals("nce")) {
            chkflg = true;
        } else if (s.substring(0, 5).equals("keyen") && s.substring(s.length() - 2).equals("ce")) {
            chkflg = true;
        } else if (s.substring(0, 6).equals("keyenc") && s.substring(s.length() - 1).equals("e")) {
            chkflg = true;
        } else if (s.substring(s.length() - 7).equals("keyence")) {
            chkflg = true;
        }
        System.out.println(chkflg ? "YES" : "NO");
    }

}
