

import java.util.*;


public class Main {


    public static int calc(int key_pos, int man_pos, int last_pos){
        return  Math.abs(man_pos - key_pos) + Math.abs(key_pos - last_pos);
    }



    public static void main(String[] args) {

        int n,k,p;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        p = sc.nextInt();

        List<Integer> places = new ArrayList<>();
        List<Integer> keys = new ArrayList<>();

        for(int i=0;i<n;i++){
            int curr = sc.nextInt();
            places.add(curr);
        }
        for(int i=0;i<k;i++){
            int curr = sc.nextInt();
            keys.add(curr);
        }

        Collections.sort(places);
        Collections.sort(keys);

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<=k - n;i++){
            int idx = 0;
            int curr = -1;
            for(int j=i;j<i+n;j++){
                curr = Math.max(curr,calc(keys.get(j),places.get(idx),p));
                idx++;
            }
            //System.out.println(curr);
            ans  = Math.min(ans,curr);
        }


        System.out.println(ans);


    }
}
