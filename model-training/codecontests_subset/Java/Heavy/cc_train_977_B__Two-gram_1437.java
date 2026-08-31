import java.util.*;

public class Main {
    public static void main(String ar[]) {
        Scanner s = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.nextInt();
        String chaine = s.next();
        char[] chars = chaine.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            String s1 = chars[i] + "" + chars[i + 1];
            map.put(s1, map.get(s1) == null ? 1 : map.get(s1) + 1);
        }
        int max=0;
        String out=new String();


        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {

            if (stringIntegerEntry.getValue()>max) {
                max=stringIntegerEntry.getValue();
                out=stringIntegerEntry.getKey();

            }

        }
        System.out.println(out);

    }

}