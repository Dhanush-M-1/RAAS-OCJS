import java.lang.*;
import java.util.*;
import javafx.util.Pair;

public class NewMain1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Pair<Integer,Integer>> pair = new ArrayList<>();
//        ArrayList<Integer> ar = new ArrayList<Integer>();
        int x = input.nextInt();
        int p = 0;
        int[] ar1=new int [x];
        int[] ar2=new int [x];
        for (int i = 0; i < ar2.length; i++) {
            ar1[i]=input.nextInt();
            ar2[i]=input.nextInt();
        }
        for (int i = 0; i < ar1.length; i++) {
          Pair<Integer,Integer>p1=new Pair<>(ar1[i],ar2[i]); 
            for (int j = 0; j < ar2.length; j++) {
                if(p1.getKey()==ar2[j])
                    p++;
            }
        }
        System.out.println(p);
        
    }
}
