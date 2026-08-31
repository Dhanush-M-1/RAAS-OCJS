//package come;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class comE {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n - 1];
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(tk.nextToken());
            if (map1.containsKey(arr1[i])) {
                Integer numElt = map1.get(arr1[i]);
                map1.put(arr1[i], (numElt + 1));
            } else {
                map1.put(arr1[i], 1);
            }
        }
        tk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n - 1; i++) {
            arr2[i] = Integer.parseInt(tk.nextToken());
            if (map2.containsKey(arr2[i])) {
                Integer numElt = map2.get(arr2[i]);
                map2.put(arr2[i], (numElt + 1));
            } else {
                map2.put(arr2[i], 1);
            }
        }
        tk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n - 2; i++) {
            int element = Integer.parseInt(tk.nextToken());
            if (map3.containsKey(element)) {
                Integer numElt = map3.get(element);
                map3.put(element, (numElt + 1));
            } else {
                map3.put(element, 1);
            }
        }
        int[] solve = new int[2];
        for (int i = 0; i < n; i++) {
            if(map2.containsKey(arr1[i])){
            if (map1.get(arr1[i]) > map2.get(arr1[i])) {
                solve[0] = arr1[i];
                break;}
            }
            else if(map2.containsKey(arr1[i])==false)solve[0]=arr1[i];
        }
        for (int i = 0; i < n - 1; i++) {
            if(map3.containsKey(arr2[i])){
            if (map2.get(arr2[i]) > map3.get(arr2[i])) {
                solve[1] = arr2[i];
                break;}
            }
            else if(map3.containsKey(arr2[i])==false)solve[1]=arr2[i];
        }
        out.write(solve[0] + "\n" + solve[1]);
        out.flush();
    }
}