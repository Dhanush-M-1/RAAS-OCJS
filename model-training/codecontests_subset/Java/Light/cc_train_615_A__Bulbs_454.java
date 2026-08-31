import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
            
        Set<Integer> set = new HashSet<Integer>(m);
        
        for(int i = 0; i < n; i++) {
            int num = scan.nextInt();
            for(int j = 0; j < num; j++)
                set.add(scan.nextInt());
        }
        
        if(set.size() == m)
            System.out.println("YES");
        else
            System.out.println("NO");
        
    }
}
