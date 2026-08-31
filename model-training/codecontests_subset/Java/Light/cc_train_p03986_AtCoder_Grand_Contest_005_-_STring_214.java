import java.util.*;

public class Main {

    public static void main(String args[]) {

        // 入力
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        sc.close();

        // 主処理
        int result = 0;
        while (x.contains("ST")) {
            String[] array = x.replace("TS", "T,S").split(",");
            List<String> list = new ArrayList<>();
            for (String st : array) {
                int countS = st.replaceAll("[^S]", "").length();
                int countT = st.replaceAll("[^T]", "").length();
                if (countS == 0 || countT == 0) {
                    result += Math.max(countS, countT);
                } else if (countS < countT) {
                    list.add("T".repeat(countT - countS));
                } else if (countT < countS) {
                    list.add("S".repeat(countS - countT));
                }
            }
            x = String.join("", list);
        }
        result += x.length();

        // 出力
        System.out.println(result);
    }
}
