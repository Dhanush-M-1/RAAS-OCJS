
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    Scanner ss = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        String x =ss.next();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0 ; i < x.length();i++)
        {
            if(x.charAt(i)=='+')
                continue;
            else
                a.add(Integer.parseInt(x.charAt(i)+""));


        }
            Collections.sort(a);
        for (int i = 0; i <a.size() ; i++) {
            if(i!=a.size()-1)
            System.out.print(a.get(i)+"+");
            else
            System.out.print(a.get(i));


        }
    }
    }
