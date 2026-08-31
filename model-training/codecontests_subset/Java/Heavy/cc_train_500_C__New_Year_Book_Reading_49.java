import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class C {
    
    static int n;
    static int m;
    static int[] bookWeights;
    static int[] readingOrder;
    static List<Integer> uniqueReadingOrder;
    static boolean[] visited;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] inputSplit;
        
        input = br.readLine();
        inputSplit = input.split("\\s");
        
        n = Integer.parseInt(inputSplit[0]);
        m = Integer.parseInt(inputSplit[1]);
        
        bookWeights = new int[n];
        readingOrder = new int[m];
        
        input = br.readLine();
        inputSplit = input.split("\\s");
        for(int i = 0; i < n; i++) {
            bookWeights[i] = Integer.parseInt(inputSplit[i]);
        }
        
        input = br.readLine();
        inputSplit = input.split("\\s");
        visited = new boolean[n];
        uniqueReadingOrder = new LinkedList<Integer>();
        for(int i = 0; i < m; i++) {
            readingOrder[i] = Integer.parseInt(inputSplit[i]);
            if(!visited[readingOrder[i] - 1]) {
                uniqueReadingOrder.add(readingOrder[i]);
                visited[readingOrder[i] - 1] = true;
            }
        }
        
        int liftWeight = 0;
        for(int i = 0; i < m; i++) {
            int j = 0;
            while(uniqueReadingOrder.get(j) != readingOrder[i]) {
                liftWeight += bookWeights[uniqueReadingOrder.get(j) - 1];
                j++;
            }
            
            if(j != 0) {
                uniqueReadingOrder.remove(j);
                ((LinkedList<Integer>) uniqueReadingOrder).addFirst(readingOrder[i]);
            }
        }
        
        System.out.println(liftWeight);
    }
}
