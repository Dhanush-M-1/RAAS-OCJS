import java.util.*;

public class Second {

  static int n;
  static String r;
  
  public static void main(String[] args) {
  
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    r = sc.next();
    Map<Character,Integer> d = new HashMap<Character,Integer>();
    for (int i=0;i<r.length();i++){
      if (d.get(r.charAt(i))==null){
        d.put(r.charAt(i),1);
      } else {
        d.put(r.charAt(i),d.get(r.charAt(i))+1);
      }
    }
    for (Map.Entry<Character,Integer> e : d.entrySet()){
      if (e.getValue() % n != 0){
        System.out.println(-1);
        return;
      }
    }
    for (int i=0;i<n;i++){
      for (Map.Entry<Character,Integer> e : d.entrySet()){
        System.out.print(new String(new char[e.getValue()/n]).replace("\0", e.getKey().toString()));
      }
    }
  }
}