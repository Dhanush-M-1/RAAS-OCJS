import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class strings {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        int k = Integer.parseInt(line);
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        line = in.readLine();
        char c;
        for (int i = 0; i<line.length();i++){
            c = line.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        String res = "";
        for (char x : map.keySet()){
            if (map.get(x) % k != 0){
                System.out.print(-1);
                System.exit(0);
            }
            for (int i = 1; i <= (map.get(x) / k); i++)
                res+=x;
        }
        String dev = res;
        for(int i = 1; i<k; i++)
            res+=dev;
        System.out.print(res);
    }

}
