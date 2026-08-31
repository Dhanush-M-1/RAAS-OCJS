import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class prob1 {
    public static void main(String[] args) {
        int m;
        int n;
        int num = 0;
        
        Scanner in = new Scanner(System.in);
        
        n = in.nextInt();
        m = in.nextInt();
        
        Set<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        for(int k = 1; k <= m; k++)
            al.add(k);
        
        for(int i = 0; i < n; i++){
            num = in.nextInt();
            for(int j = 0; j < num; j++)
                set.add(in.nextInt());
        }
        
        if(set.containsAll(al)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        
    }
}
