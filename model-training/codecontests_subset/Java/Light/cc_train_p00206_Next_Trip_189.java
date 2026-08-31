import java.util.*;
 
class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while(true) {
        int l = s.nextInt();
        if(l==0) break;
        int a = 0;
        boolean f = true;
        for(int i=1 ; i<13 ; i++) {
        int m = s.nextInt();
        int n = s.nextInt();
        a += m;
        a -= n;
        if(a>=l && f) {
            System.out.println(i);
            f = false;
        }
        }
        if(f) System.out.println("NA");
    }
    }
}