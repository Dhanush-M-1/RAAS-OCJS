import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        int a = r.nextInt();
        int b = r.nextInt();
        int c = r.nextInt();
        
        
        int lo = 0, hi = c * a;
        while(lo < hi){
            int md = (lo + hi) / 2;
            
            int done = md * b;
            boolean can = true;
            for(int i = 0; i < c; i++){
                done += b;
                done -= a;
                
                if(done < 0){
                    can = false;
                }
            }
            
            if(can)hi = md;
            else lo = md + 1;
        }
        
        System.out.println(lo);
    }
}
