import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class xxxxxx {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        HashMap<Integer, Integer> host = new HashMap<>();
        HashMap<Integer, Integer> guest = new HashMap<>();

        int count =0;
        int n=s.nextInt();

        for (int i=0; i<n;i++){
            int h= s.nextInt();
            int g=s.nextInt();

            if(host.containsKey(g)) count += host.get(g);
            if(guest.containsKey(h)) count += guest.get(h);

            if(host.containsKey(h)) host.put(h,host.get(h)+1);
            else  host.put(h,1);

            if(guest.containsKey(g)) guest.put(g,guest.get(g)+1);
            else  guest.put(g,1);
        }


        System.out.println(count);

    }
}
