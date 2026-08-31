import java.util.*;
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        int x = Integer.parseInt(scan.next());
        int y = Integer.parseInt(scan.next());
        int k1 = n*y;
        int need = 0;
        if (k1%100!=0){
            need = k1/100+1;
        }
        else {
            need = k1/100;
        }
        if (x<need){
            System.out.println(need-x);
        }
        else {
            System.out.println(0);
        }
    }

}
