
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author anurag.y
 * @since 13/02/19.
 */
public class Main {

    private static InputReader inputReader = new InputReader();

    public static void main(String[] args) throws IOException {
        List<Integer> inputVariables = inputReader.readIntegersFromLine();
        int n, m;
        n = inputVariables.get(0);
        m = inputVariables.get(1);

        List<Integer> inputArr = inputReader.readIntegersFromLine();
        Set<Integer>[] adjacencyList = new HashSet[n + 1];
        Set<Integer>[] reverseAdjacencyList = new HashSet[n + 1];

        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new HashSet<>();
            reverseAdjacencyList[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            List<Integer> temp = inputReader.readIntegersFromLine();
            adjacencyList[temp.get(0)].add(temp.get(1));
            reverseAdjacencyList[temp.get(1)].add(temp.get(0));
        }

        int count = 0;
        List<Integer> remainingElement = new ArrayList<>();
        remainingElement.add(inputArr.get(n - 1));
        for (int i = n - 2;i >= 0; i--) {
            int value = inputArr.get(i);
            if (adjacencyList[value].containsAll(remainingElement)) {
                count++;
            } else {
                remainingElement.add(value);
            }
        }
        System.out.println(count);

    }

    private static class InputReader {

        private static BufferedReader bufferedReader;

        public InputReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readStringFromLine() throws IOException {
            return bufferedReader.readLine().trim();
        }

        public int readSingleIntFromLine() throws IOException {
            return Integer.parseInt(bufferedReader.readLine().trim());
        }

        public List<Integer> readIntegersFromLine() throws IOException {
            final List<Integer> integerList = new ArrayList<>();
            for (String integer : bufferedReader.readLine().trim().split(" ")) {
                integerList.add(Integer.parseInt(integer));
            }

            return integerList;
        }

        public List<Long> readLongsFromLine() throws IOException {
            final List<Long> integerList = new ArrayList<>();
            for (String integer : bufferedReader.readLine().trim().split(" ")) {
                integerList.add(Long.parseLong(integer));
            }

            return integerList;
        }
    }
}
