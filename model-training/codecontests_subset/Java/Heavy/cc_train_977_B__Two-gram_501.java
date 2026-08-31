import java.util.*;

public class CodeForce {
    static Scanner scanner = new Scanner(System.in);
    HashMap<String, Integer> hashMap = new HashMap<>();
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        CodeForce codeForce = new CodeForce();
        int lengthOfInput = scanner.nextInt();
        String string = scanner.next();
        codeForce.process(string);
    }

    void process(String string) {
        for (int i = 1; i < string.length(); i++) {
            String newString = Character.toString(string.charAt(i-1)) + Character.toString(string.charAt(i));
            if(hashMap.containsKey(newString)){
                int val = hashMap.get(newString);
                hashMap.put(newString, ++val);
            } else {
                hashMap.put(newString, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(list.get(0).getKey());
    }
}
