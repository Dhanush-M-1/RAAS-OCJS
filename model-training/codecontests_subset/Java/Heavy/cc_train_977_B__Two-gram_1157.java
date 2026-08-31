
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner Input = new Scanner(System.in);
        int N = Input.nextInt();
        String S = Input.next();
        HashMap<String, Integer> HM = new HashMap();

        for (int I = 0; I < S.length() - 1; I++) {
            String X = S.charAt(I) + "" + S.charAt(I + 1);
            if (!HM.containsKey(X)) {
                HM.put(X, 1);
            } else {
                HM.put(X, HM.get(X) + 1);
            }
        }
        int Min = 0;
        String Max = "";

        for (Map.Entry<String, Integer> Entry : HM.entrySet()) {
            String Key = Entry.getKey();
            Integer Value = Entry.getValue();

            if (Value > Min) {
            Min = Value;
            Max = Key;
            }

        }
        
        System.out.println(Max);

    }
}
