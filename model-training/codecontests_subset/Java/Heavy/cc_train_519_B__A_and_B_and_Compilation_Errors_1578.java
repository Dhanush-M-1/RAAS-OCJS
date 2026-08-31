import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main519B {
    public static void main(String[] args) {
        try(BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt( rd.readLine() );

            int a,b;
            List<Integer> list1 = readArray(rd.readLine());
            List<Integer> list2 = readArray(rd.readLine());

//            System.out.println("l1: " + list1);
//            System.out.println("l2: " +list2);

            a = diff(list1,list2);
            list1 = list2;
            list2 = readArray(rd.readLine());

//            System.out.println("l1: " +list1);
//            System.out.println("l2: " +list2);

            b = diff(list1,list2);

            System.out.println(a);
            System.out.println(b);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static int diff(List<Integer> list1, List<Integer> list2) {
        for (int i = 0;  i < list2.size(); i++) {
            if( list1.get(i).intValue() != list2.get(i).intValue() ) {
                return list1.get(i);
            }
        }
        return list1.get(list1.size()-1);
    }

    private static List<Integer> readArray(String line) {
        ArrayList<Integer> rez = new ArrayList<>();
        String[] parts = line.split("\\s+");
        for(String s : parts) {
            rez.add( Integer.parseInt(s) );
        }
        Collections.sort(rez);
        return rez;
    }
}
