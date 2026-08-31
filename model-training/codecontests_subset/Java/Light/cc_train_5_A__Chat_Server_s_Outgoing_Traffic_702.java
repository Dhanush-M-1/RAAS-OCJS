import static java.lang.Math.*;
import java.util.*;

public class Main {
    public static void main(String zzz[]){
        Scanner sc = new Scanner(System.in);
        int num_persons = 0;
        int su = 0;
        while(sc.hasNext()){
            String s = sc.nextLine();
            if(s.charAt(0)=='+')++num_persons;
            else if(s.charAt(0)=='-')--num_persons;
            else{
                int i = 1 + s.indexOf(':');
                su += (s.length() - i) * num_persons;
            }
        }
        System.out.println(su);
    }
}
