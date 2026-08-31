import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
         public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String ramz = input.next();
            int n = input.nextInt();
            boolean peida = false;
            ArrayList<String> r = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                r.add(input.next());
            }
            if (r.contains(ramz)) {
                peida = true;
            }
            for (int i = 0; i < n; i++) {
                String a = String.valueOf(r.get(i).charAt(1));
                for (int j = 0; j < n; j++) {
                    String b = String.valueOf(r.get(j).charAt(0));
                    String q = a + b;
                    if (q.equals(ramz)) {
                        peida = true;
                    }
                }
            }
            if (peida) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

						       	 	   		   		  		