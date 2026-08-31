
//package serilakiller;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        
        String first , secend;
        int n;
        
        first = scan.next();
        secend = scan.next();
        System.out.println(first + " " + secend);
        n = scan.nextInt();
        
        String a , b ;
        
        HashMap<String, String> v = new HashMap<>();
        
        v.put(first, secend);
        for(int i = 0 ; i < n ; i++){
            a = scan.next();
            b = scan.next();
            
            if(v.containsKey(a)){
                v.put(b, secend);
                System.out.println(b + " " + secend);
                first = b;
            }else if(v.containsValue(a)){
                v.put(first, b);
                System.out.println(first + " " + b);
                secend = b;
            }
            
        }
        
        
        
    }
    
}
