import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<pair> ref = new ArrayList<>();
        ref.add(new pair(0, 1));
        ref.add(new pair(0, 2));
        ref.add(new pair(1, 0));
        ref.add(new pair(1, 1));
        ref.add(new pair(2, 0));
        int tst = Integer.parseInt(br.readLine());
        while(tst-->0){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int i = 0; i<n; i++){
                arr[i] = br.readLine();
            }
            ArrayList<pair> conf1 = new ArrayList<>();
            ArrayList<pair> conf2 = new ArrayList<>();
            //conf1
            for(pair p: ref){
                if((p.x == 0 && p.y == 1) || (p.x == 1 && p.y == 0)){
                    if(arr[p.x].charAt(p.y)!='1') conf1.add(p);
                }
                else{
                    if(arr[p.x].charAt(p.y)!='0') conf1.add(p);
                }
            }
            //conf2
            for(pair p: ref){
                if((p.x == 0 && p.y == 1) || (p.x == 1 && p.y == 0)){
                    if(arr[p.x].charAt(p.y)!='0') conf2.add(p);
                }
                else{
                    if(arr[p.x].charAt(p.y)!='1') conf2.add(p);
                }
            }
            if(conf1.size()<=conf2.size()){
                sb.append(conf1.size()).append('\n');
                for(pair p: conf1) sb.append(p.x+1).append(" ").append(p.y+1).append('\n');
            }
            else{
                sb.append(conf2.size()).append('\n');
                for(pair p: conf2) sb.append(p.x+1).append(" ").append(p.y+1).append('\n');
            }
        }
        System.out.println(sb);
    }
    static class pair{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
    }
}