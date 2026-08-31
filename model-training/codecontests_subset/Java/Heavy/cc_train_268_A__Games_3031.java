import java.io.*;
import java.util.HashMap;

public class CF {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> home = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> away = new HashMap<Integer, Integer>();
        
        //count when host's home = guest's away
        
        int numTeams = Integer.parseInt(br.readLine());
        String[] split;
        int count = 0;
        
        for(int i = 0 ; i < numTeams; i++) {
            split = br.readLine().split(" ");
            int h = Integer.parseInt(split[0]);
            int a = Integer.parseInt(split[1]);
            
            if(home.containsKey(a)) count += home.get(a);
            if(away.containsKey(h)) count += away.get(h);
            
            if(home.containsKey(h)) home.put(h, home.get(h) + 1);
            else home.put(h, 1);
            
            if(away.containsKey(a)) away.put(a, away.get(a) + 1);
            else away.put(a, 1);
        }
        pw.println(count);
        
        pw.close();
    }
}