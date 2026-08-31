import java.util.*;

public class phone {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = Integer.parseInt(str);
        str = sc.next();
        ArrayList<Integer> arr = new ArrayList<>(n);
        int numEt = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(str.substring(i, i+1));
            arr.add(temp);
            if (temp == 8) {
                numEt++;
            }
        }
        if (n/11 >= numEt) {
            System.out.println(numEt);
        } else {
            System.out.println(n/11);
        }

    }
}