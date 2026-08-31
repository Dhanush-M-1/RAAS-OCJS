import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();
        List<Character> nums = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
            } else nums.add(chars[i]);
        }
        Collections.sort(nums);
        String result = "";
        Iterator<Character> iter = nums.iterator();
        while (iter.hasNext()) {

            result = result + iter.next() + "+";
        }
        char[] res = result.toCharArray();
        for (int i = 0; i < res.length-1; i++){
            System.out.print(res[i]);
        }

    }
}



