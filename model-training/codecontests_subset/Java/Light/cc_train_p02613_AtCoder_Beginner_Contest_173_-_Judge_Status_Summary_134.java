import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("AC",0);
        hm.put("WA",0);
        hm.put("TLE",0);
        hm.put("RE",0);
        while(N-->0) {
            String s=sc.next();
            hm.put(s,hm.get(s)+1);
        }
        System.out.println("AC x "+hm.get("AC"));
        System.out.println("WA x "+hm.get("WA"));
        System.out.println("TLE x "+hm.get("TLE"));
        System.out.println("RE x "+hm.get("RE"));
    }
}