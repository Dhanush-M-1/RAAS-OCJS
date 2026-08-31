import java.util.*;

public class Problem339A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        List<String> list = new ArrayList<>(Arrays.asList(a.split("\\+")));
        Collections.sort(list);
        String result = String.join("+", list);
        System.out.println(result);
    }
}
