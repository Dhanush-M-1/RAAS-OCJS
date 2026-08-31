import java.util.HashSet;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        int r1 = r.nextInt();
        int r2 = r.nextInt();
        
        int c1 = r.nextInt();
        int c2 = r.nextInt();
        
        int d1 = r.nextInt();
        int d2 = r.nextInt();
        
        for(int i = 1; i < Math.min(r1, 10); i++){
            int li = r1 - i;
            if(li > 9)continue;
            for(int j = 1; j < Math.min(10, r2); j++){
                int lj = r2 - j;
                if(lj > 9)continue;
                
                HashSet<Integer> S = new HashSet<Integer>();
                S.add(i);
                S.add(j);
                S.add(li);
                S.add(lj);
                if(S.size() != 4)continue;
                
                if(i + j == c1 && li + lj== c2 && i + lj == d1 && li + j == d2){
                    System.out.printf("%d %d\n%d %d\n", i, li, j, lj);
                    return;
                }
            }
        }
        
        System.out.println(-1);
    }
}
