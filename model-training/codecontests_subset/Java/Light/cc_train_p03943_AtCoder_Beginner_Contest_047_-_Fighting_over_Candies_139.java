import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(sc.hasNext()){
          list.add(sc.nextInt());
        }
      
        Collections.sort(list);

        String ans = "No";
        if (list.get(2) == list.get(0) + list.get(1)) ans = "Yes";
        
        System.out.println(ans);
    }
}
