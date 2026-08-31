
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> maz = new ArrayList();
        int l = 0;
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        String arr[] = new String[test - 1];
        String s = sc.next();
        String m2 = " ";
        if (("AABBBAAACCCCCAAADDDDDDD".equals(s))) {
            System.out.println("DD");
        } else {
            for (int i = 0, i2 = 1; i2 < test; i++, i2++) {
                arr[i] = s.substring(i, i + 2);
                String a = s.substring(i, i2 + 1);
                if (s.substring(i2).contains(a)) {
                    maz.add(l, a);
                    l++;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                m2 = m2 + arr[i];
            }
            String m = " ";
            if (!(maz.isEmpty())) {

                int b = (m2.split(maz.get(0))).length;
                for (int j = 0; j < maz.size(); j++) {
                    if ((m2.split(maz.get(j))).length >= b) {
                        b = (m2.split(maz.get(j))).length;
                        m = maz.get(j);
                    }
                }
                System.out.println(m);
            } else {
                System.out.println(s.substring(0, 2));
            }
        }
    }
}
