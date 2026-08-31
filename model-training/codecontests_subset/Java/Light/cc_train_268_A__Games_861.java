
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> home = new HashMap<>();
        HashMap<String, Integer> guest = new HashMap<>();
        for(int i = 0; i < n;i++){
            String h = sc.next();
            if(!home.containsKey(h)){
                home.put(h, 1);
            }else{
                home.put(h, home.get(h) + 1);
            }
            String g = sc.next();
            if(!guest.containsKey(g)){
                guest.put(g, 1);
            }else{
                guest.put(g, guest.get(g) + 1);
            }
        }
        int match = 0;
        for (Map.Entry<String, Integer> hom : home.entrySet()) {
            String h = hom.getKey();
            Integer c = hom.getValue();
            if(guest.containsKey(h)){
                match += c * guest.get(h);
            }
        }
        System.out.println(match);
    }
}
