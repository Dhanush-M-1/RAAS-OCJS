import java.util.*;
public class Main {
    private void doit() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String str = sc.next();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int len = str.length();
            for(int i = 0; i < len; i++){
                char temp = str.charAt(i);
                if(map.containsKey(temp)){
                    int value = map.get(temp);
                    map.put(temp, value + 1);
                }
                else{
                    map.put(temp, 1);
                }
            }

            boolean isOK = true;
            for(char key: map.keySet()){
                int temp = map.get(key);
                if(temp % n != 0){
                    isOK = false;
                }
            }
            if(! isOK){
                System.out.println(-1);
            }
            
            else{
                StringBuilder sb = new StringBuilder();
                for(int ni = 0; ni < n; ni++){
                    for(char key: map.keySet()){
                        int times = map.get(key) / n;
                        for(int i = 0; i < times; i++){
                            sb.append(key);
                        }
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.doit();
    }
}