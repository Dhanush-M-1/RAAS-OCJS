import java.util.HashMap;
import java.util.Scanner;


public class q_4 {
    static Scanner sc;

    public static void main(String[] args){
        sc = new Scanner(System.in);
        // CHANGED
        int l = sc.nextInt();
        sc.nextLine();
        String s = nextLine();
        HashMap<String , Integer> map = new HashMap<>();
        for(int i=0 ; i<s.length()-1 ; i++ ){
            String ss = s.substring(i,i+2);
            if(map.containsKey(ss)){
                map.replace(ss,map.get(ss)+1);
            }
            else {
                map.put(ss,1);
            }
        }
        int max= 0;
        String sss = "";
        for(String s2:map.keySet()){
            if(map.get(s2)>max){
                max=  map.get(s2);
                sss = s2;
            }
        }
        System.out.println(sss);


    }





    public static int getInt(){
        return sc.nextInt();
    }

    public static String getString(){
        return sc.next();
    }

    public static String nextLine(){
        return sc.nextLine();
    }

    public static long nextLong(){
        return sc.nextLong();
    }

}