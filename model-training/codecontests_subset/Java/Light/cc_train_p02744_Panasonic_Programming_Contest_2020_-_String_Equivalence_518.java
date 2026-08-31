import java.util.*;
public class Main {
    
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Deque<String> words = new ArrayDeque<>();
        words.add("a");
        
        while(true){
            if(words.getFirst().length() == N) break;
            String word = words.removeFirst();
            String[] charArr = word.split("");
            Set<String> usedChar = new HashSet<>();
            for (String string : charArr) usedChar.add(string);
            String firstUnused = "";
            for(char c='a'; c-'a'<26; c++){
                if(usedChar.contains(String.valueOf(c))){
                    continue;
                }
                firstUnused = String.valueOf(c);
                break;
            }
            for (String string : usedChar) {
                words.addLast(word+string);
            }
            words.addLast(word+firstUnused);
        }
        for (String string : words) {
            System.out.println(string);
        }
    }
}