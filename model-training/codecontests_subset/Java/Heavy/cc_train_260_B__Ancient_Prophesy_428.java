import java.util.*;

public class Main{
    
    char [] data;
    HashMap<String, Integer> map;
    int len;
    int [] day = {-1,31,28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    private void doit(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            data = s.toCharArray();
            len = data.length;
            map = new HashMap<String, Integer>();
            for(int i = 0; i <= len - 10; i++){
                boolean res = check(i);
                if(! res) continue;
                
                String ss = s.substring(i, i + 10);
                boolean res2 = check2(ss);
                if(! res2) continue;
                if(map.containsKey(ss)){
                    map.put(ss, map.get(ss) + 1);
                }
                else{
                    map.put(ss, 1);
                }
            }
            int max = 0;
            String ans = "";
            for(String key: map.keySet()){
                int now = map.get(key);
                if(max < now){
                    max = now;
                    ans = key;
                }
            }
            System.out.println(ans);
        }
    }

    private boolean check2(String ss) {
        String [] sss = ss.split("-");
        int d = Integer.parseInt(sss[0]);
        int m = Integer.parseInt(sss[1]);
        int y = Integer.parseInt(sss[2]);
        if(2013 <= y && y <= 2015){
            if(1 <= m && m <= 12){
                if(1 <= d && d <= day[m]){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int ind) {
        for(int i = 0; i < 10; i++){
            if(i == 2 || i == 5){
                if(data[ind + i] != '-'){
                    return false;
                }
            }
            else{
                if(data[ind + i] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    private void debug(Object... o) { System.out.println("debug = " + Arrays.deepToString(o)); }

    public static void main(String[] args) {
        new Main().doit();
    }
}