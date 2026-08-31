
import java.util.Scanner;

public class Z_Function {

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        
        int r1 = s.nextInt();
        int r2 = s.nextInt();
        int c1 = s.nextInt();
        int c2 = s.nextInt();
        int d1 = s.nextInt();
        int d2 = s.nextInt();
        
        boolean ok = false;
        
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <=9; j++) {
                for (int j2 = 1; j2 <=9; j2++) {
                    for (int k = 1; k <=9; k++) {
                        if(r1==i+j && r2==j2+k && c1==i+j2 && c2==j+k && d1==i+k && d2==j+j2){
                            if(i==j || i==j2 || i==k || j==j2 || j==k || j2==k)
                                continue;
                            ok=true;
                            System.out.println(i+" "+j);
                            System.out.println(j2+" "+k);
                        }
                        
                    }
                }
            }
        }
        
        if(!ok)
            System.out.println("-1");
        
    }

}
