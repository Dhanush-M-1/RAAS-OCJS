import java.util.*;
public class A219 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String s = sc.next();
        String res="";
        HashMap<Character,Integer> map = getMap(s);
        for(Integer x:map.values()){
            if(x%t!=0){
                System.out.println("-1");
                return;
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            res+=String.valueOf(entry.getKey()).repeat(entry.getValue()/t);
        }
        System.out.println(res.repeat(t));
    }
    public static HashMap<Character,Integer> getMap(String t){
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
            if(map.get(c)>max){
                max=map.get(c);
            }
        }
        return map;
    }
}