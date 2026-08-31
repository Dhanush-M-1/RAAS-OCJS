import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int fir=n;
       Map<Integer,Integer> map = new HashMap<>();
       while (fir-->0){
           int x= scanner.nextInt();
           map.put(x,map.getOrDefault(x,0)+1);
       }
        //System.out.println(map);
       int sec =n-1;
       int err1=0,err2=0;
        Map<Integer,Integer> map2 = new HashMap<>();
       while (sec-->0){
           int x=scanner.nextInt();
           map.put(x,map.getOrDefault(x,0)-1);
           map2.put(x,map2.getOrDefault(x,0)+1);
       }
       // System.out.println(map);
        for(Integer key:map.keySet()) {
            if(map.get(key)>0){
                err1=key;
                break;
            }
        }
       // System.out.println(map2);
       int thir=n-2;
       while (thir-->0){
           int x=scanner.nextInt();
           map2.put(x,map2.getOrDefault(x,0)-1);
       }
        for(Integer key:map2.keySet()) {
            if(map2.get(key)>0){
                err2=key;
                break;
            }
        }

        System.out.println(err1);
        System.out.println(err2);

}
}
