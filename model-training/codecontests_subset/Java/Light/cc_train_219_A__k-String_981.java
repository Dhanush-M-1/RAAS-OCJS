import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class a {
    public static void main(String args[]) {
        helper();
    }
    
    public static void helper() {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String answer = "";
        scanner.nextLine();
        char[] string = scanner.nextLine().toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>(); 
        for (char c : string) { 
            if (charCountMap.containsKey(c)) { 
                charCountMap.put(c, charCountMap.get(c) + 1); 
            } else {
                charCountMap.put(c, 1); 
            } 
        } 

        for (Map.Entry entry : charCountMap.entrySet()) {
            if ((int) entry.getValue() % k != 0) {
                System.out.println("-1");
                return;
            }
            answer = answer + String.join("", Collections.nCopies((int) entry.getValue()/k, String.valueOf(entry.getKey())));
        }
        
        while (k-- != 0) {
            System.out.print(answer);
        }
    }
}
					 	   	 	 	   		  	 	   	