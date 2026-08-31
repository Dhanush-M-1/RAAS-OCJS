import java.util.*;
public class lcm{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long store = 0;
        if(n == 1){
            store = 1;
        }else if(n == 2){
            store = 2;
        }else if(n%2 == 0){
            long check1 = (long)(n-1)*(long)(n-2)*(long)(n-3);
            long check2 = n*(n-1)*(long)((n-2)*0.5);
            if (check1 > check2){
                store = check1;
            }else{
                store = check2;
            }
            if (n%3 != 0){
                if(n*(n-1)*(n-3) > store){
                    store = n*(n-1)*(n-3);
                }
            }
        }else{
            store = n*(n-1)*(n-2);
        }
        System.out.println(store);
    }
}