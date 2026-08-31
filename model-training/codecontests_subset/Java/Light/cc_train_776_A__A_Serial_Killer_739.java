

import java.util.Scanner;

public class SerialKiller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String na = sc.next();
        String nb = sc.next();
        int n = sc.nextInt();
        while(n-->0){
        String a = sc.next();
        String b = sc.next();
       
            System.out.println(na +" "+nb);
            if(a.equals(na))
                na=b;
            if(a.equals(nb))
                nb=b;
        }
        System.out.println(na +" "+nb);
    }
    
}
