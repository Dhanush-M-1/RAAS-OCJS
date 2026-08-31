import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class ProblemC {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        String [] in = br.readLine().split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            a[i] = Integer.parseInt(in[i]);
            
        }
        in = br.readLine().split(" ");
        int  first=0, second=0, ind = -1;;
        for (int i = 0; i < in.length; i++) {
            int x = Integer.parseInt(in[i]);
            if(!map.containsKey(x))
                map.put(x, 1);
            else
                map.put(x, map.get(x)+1);
        }
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(a[i])){
                first = a[i];
                ind = i;
                break;
            }
            else{
                map.put(a[i], map.get(a[i])-1);
                if(map.get(a[i]) == 0)
                    map.remove(a[i]);
            }
        }
        in = br.readLine().split(" ");
        map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            int x = Integer.parseInt(in[i]);
            if(!map.containsKey(x))
                map.put(x, 1);
            else
                map.put(x, map.get(x)+1);
        }
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(a[i]) && i!=ind){
                second = a[i];
                ind = i;
                break;
            }
            else{
                if(i!=ind){
                    map.put(a[i], map.get(a[i])-1);
                    if(map.get(a[i]) == 0)
                        map.remove(a[i]);
                }
            }
        }
        System.out.println(first+"\n"+second);
    }

}
