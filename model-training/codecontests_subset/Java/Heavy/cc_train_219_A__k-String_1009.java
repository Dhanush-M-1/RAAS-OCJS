import java.util.*;
public class codetest {
    
    
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        int k = input.nextInt();
        
        String s = input.next();
        
        HashMap<Character,Integer> letters = new HashMap<>();
        char[] keys = new char[1000];
        int index = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (letters.containsKey(s.charAt(i)))
                letters.put(s.charAt(i), letters.get(s.charAt(i)) + 1); 
            else {
                letters.put(s.charAt(i), 1);
                keys[index] += s.charAt(i);
                index++;
            }
                
        }
        
        ArrayList<Integer> values = new ArrayList<>();
        values.addAll(letters.values());
        Collections.sort(values);
        
        boolean pass = true;
        for (int i = 0; i < values.size(); i++)
            if (values.get(i) % k != 0) {
                pass = false;
                break;
            }
        
        String answer = "";
        if (pass)
            for (int z = 0; z < k; z++)
                for (int i = 0; i < index; i++) 
                    for (int j = 0; j < letters.get(keys[i]) / k; j++)
                        answer += keys[i];
                    
        System.out.println(pass ? answer : -1);
    }
    
}
