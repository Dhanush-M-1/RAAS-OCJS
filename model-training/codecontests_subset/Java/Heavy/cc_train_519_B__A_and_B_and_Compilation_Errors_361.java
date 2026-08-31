import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CompilationErrors519B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[2];
        
        List<Integer> initialList = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            initialList.add(sc.nextInt());
        }
        
        List<Integer> secondList = new ArrayList<Integer>();
        for (int i=0; i<n-1; i++) {
            secondList.add(sc.nextInt());
        }
        
        Collections.sort(initialList);
        Collections.sort(secondList);
        
        int i=0;
        while (i < secondList.size()) {
            int val1 = initialList.get(i);
            int val2 = secondList.get(i);
            if (val1 != val2) {
                break;
            }
            i++;
        }
        res[0] = initialList.get(i);
        
        initialList = secondList;
        secondList = new ArrayList<Integer>();
        for (int j=0; j<n-2; j++) {
            secondList.add(sc.nextInt());
        }
        
        Collections.sort(secondList);
        
        i= 0;
        while (i<secondList.size()) {
            int val1 = initialList.get(i);
            int val2 = secondList.get(i);
            if (val1 != val2) {
                break;
            }
            i++;
        }
        res[1] = initialList.get(i);
        
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}