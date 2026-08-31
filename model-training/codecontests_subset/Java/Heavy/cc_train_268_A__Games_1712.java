import java.util.*;

public class practice {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        
        int a = Integer.parseInt(in.nextLine());
        int[] home = new int[a];
        int[] guest = new int[a];
        
        for(int i = 0; i < a; i++) {
            String str = in.nextLine();
            home[i] = Integer.parseInt(str.substring(0, str.indexOf(" ")));
            guest[i] = Integer.parseInt(str.substring(str.indexOf(" ") + 1));
        }
        
        int count = 0;
        
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < a; j++) {
                if(home[i] == guest[j]) count++;
            }
        }
        
        System.out.println(count);
    }
}