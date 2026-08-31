import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long d = sc.nextLong();
            if(a < b){
                System.out.println("No");
                continue;
            }
            if(b > d){
                System.out.println("No");
                continue;
            }
            if(c >= b){
                System.out.println("Yes");
                continue;
            }

            long tmp;
            long tb = b;
            long td = d;
            while((tmp=tb % td) != 0){
                tb = td;
                td = tmp;
            }

            tmp = (a-c) % td;

            if(tmp == 0) tmp = td;
            if(tmp < b-c){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}