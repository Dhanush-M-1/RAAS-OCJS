import java.util.ArrayList;
import java.util.Scanner;

public class Twogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        ArrayList<String> gram = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 1; i < n; i++)
        {
            String test = s.substring(i-1,i+1);
            if (gram.contains(test))
            {
                count.set(gram.indexOf(test),count.get(gram.indexOf(test))+1);
            }
            else
            {
                gram.add(test);
                count.add(1);
            }
        }
        int max = 0;
        String best = "";
        for (int i = 0; i < count.size(); i++)
        {
            if (count.get(i)>max)
            {
                max = count.get(i);
                best = gram.get(i);
            }
        }
        System.out.println(best);
    }
}
