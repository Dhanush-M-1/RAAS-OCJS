
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(br);
        int books = sc.nextInt();
        int elements = sc.nextInt();
        int weight[] = new int[books + 1];
        for (int i = 1; i <= books; i++) {
            weight[i] = sc.nextInt();
        }
        int input[] = new int[elements];
        for (int i = 0; i < elements; i++) {
            input[i] = sc.nextInt();
        }
        List<Integer> myList = new ArrayList<Integer>(elements);
        for (int i : input) {
            if (!myList.contains(i)) {
                myList.add(i);
            }
        }
        for (int i = 1; i <= books; i++) {
            if (!myList.contains(i)) {
                myList.add(i);
            }
        }
        List<Integer> linkedList = new LinkedList<Integer>();
        for (int i = myList.size() - 1; i >= 0; i--) {
            linkedList.add(myList.get(i));
        }
        int answer = 0;
        int k = 0;
        boolean found;
        for (int i = 0; i < input.length; i++) {
            // System.out.println(i);
            Iterator<Integer> it = linkedList.iterator();
            found = false;
            while (it.hasNext()) {
                k = it.next();
                if (k == input[i]) {
                    found = true;
                    it.remove();
                    continue;
                }
                if (found) {
                    // System.out.print("k=" + k + " " + arr[k].weight + " ");
                    answer = answer + weight[k];
                }
            }
            linkedList.add(input[i]);
            // System.out.println();
        }
        System.out.println(answer);
    }
}