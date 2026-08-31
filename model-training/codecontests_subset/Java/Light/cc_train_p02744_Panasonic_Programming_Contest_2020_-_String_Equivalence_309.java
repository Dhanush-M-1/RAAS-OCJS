import java.util.*;

public class Main {
    private static final long MODVAL = 1000000007L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> ls = new ArrayList<>();
        ls.add("a");
        for(int i=1; i<N; i++) {
            List<String> tmp = new ArrayList<>();
            for(String before : ls) {
                Set<String> ss = new HashSet<>();
                for(int k=0; k<before.length(); k++) {
                    ss.add(before.substring(k, k+1));
                }
                for(String s : ss) {
                    String ts = before + s;
                    tmp.add(ts);
                }
                int idx = ss.size();
                String plus = before + "abcdefghijkl".substring(idx, idx+1);
                tmp.add(plus);
            }
            ls = tmp;
        }
        for(String tmp : ls) {
            System.out.println(tmp);
        }
    }
}
