import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<String>();
        int ans = 0;

        while(sc.hasNext()){
            String s = sc.nextLine();
            if(s.charAt(0) == '+'){
                set.add(s.substring(1));
            }
            else if(s.charAt(0) == '-'){
                set.remove(s.substring(1));
            }
            else{
                String tmp[] = s.split(":");
                if(tmp.length == 2){
                    ans += tmp[1].length() * set.size();
                }
            }
        }
        System.out.println(ans);
    }
}