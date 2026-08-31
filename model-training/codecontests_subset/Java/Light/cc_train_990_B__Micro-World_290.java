import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class micro{


    static int n, k;
    static Scanner scanner = new Scanner(System.in);
    static List<Integer> list = new ArrayList<Integer>(200000);
    static HashMap<Integer, Integer> map = new HashMap<>(200000);
    

    
    public static void main(String[] args) {

        n = scanner.nextInt();
        k = scanner.nextInt();

        int current;
        for(int i = 0; i < n; ++i){

            current = scanner.nextInt();

            if(map.containsKey(current)){
                map.put(current, map.get(current) + 1);
                continue;
            }

            list.add(current);
            map.put(current, 1);
        }


        Collections.sort(list);

        int n_copy = n, a, b;
        for(int i = 0; i < list.size() - 1; ++i){

            a = list.get(i);
            b = list.get(i + 1);

            n_copy = b > a && b <= a + k ? n_copy - map.get(a) : n_copy;


        }

        System.out.println(n_copy);
        
    }




}