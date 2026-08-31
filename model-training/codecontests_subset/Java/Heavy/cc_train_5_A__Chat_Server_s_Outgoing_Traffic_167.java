import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Set<String> set = new HashSet<>();
        int traffic = 0;
        while(scanner.hasNext()) {
            String cmd = scanner.nextLine();
            
            if(cmd.charAt(0) == '+') {
                set.add(cmd.substring(1));
            } else if(cmd.charAt(0) == '-') {
                set.remove(cmd.substring(1));
            } else {
                int i = 0;
                while(cmd.charAt(i) != ':')
                    i++;
                    
                traffic += set.size() * (cmd.length() - i - 1);
            }
        }
        
        System.out.print(traffic);
    }
}