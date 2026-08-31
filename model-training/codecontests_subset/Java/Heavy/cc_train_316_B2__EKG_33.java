import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class CF {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);


        int n = in.nextInt();
        int x = in.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        
        int[] first = new int[n + 1];
        int xqueue = -1;
        
        Arrays.fill(first, -1);
        for (int i = 1; i < first.length; i++) {
            int tempIndex = i;
            boolean xhere = false;

            if (tempIndex == x) xhere = true;
            while(arr[tempIndex] != 0) {
                
                if (first[tempIndex] != -1) {
                    tempIndex = first[tempIndex];
                    break;
                }
                
                first[tempIndex] = arr[tempIndex];
                tempIndex = arr[tempIndex];
                if (tempIndex == x) xhere = true;
            }
            
            int target = tempIndex;
            tempIndex = i;
            while(arr[tempIndex] != 0) {
                if (tempIndex == target) break;
                
                first[tempIndex] = target;
                tempIndex = arr[tempIndex];
            }
            first[tempIndex] = target;
            if (xhere) xqueue = target;
        }

//        for (int i = 1; i < first.length; i++) {
//            out.print(first[i] + " ");
//        }
//        out.println();
//        out.println(xqueue);
//        
        int[] sizes = new int[n + 1];
        for (int i = 1; i < first.length; i++) {
            sizes[first[i]]++;
        }
        
        int beforeX = 0;
        int xTemp = x;
        while(arr[xTemp] != 0) {
            beforeX++;
            xTemp = arr[xTemp];
        }
        int afterX = sizes[xqueue] - beforeX - 1;
        
        List<Integer> sizesList = new ArrayList<Integer>();
        for (int i = 1; i < sizes.length; i++) {
            if (sizes[i] == 0) continue;
            if (i != xqueue) sizesList.add(sizes[i]);
        }
        
//        out.println("before x " + beforeX);
//        out.println("after x " + afterX);
//        

        int[] sums = new int[n + 1];
        sums[beforeX + 1] = 1;
        int currIndicator = 1;
        
        for (int i = 0; i < sizesList.size(); i++) {
            for (int j = 1; j < sums.length; j++) {
                if (sums[j] >= 1 && sums[j] <= currIndicator && j + sizesList.get(i) <= n && sums[j + sizesList.get(i)] == 0) {
                    sums[j + sizesList.get(i)] = currIndicator + 1;
                }
            }
            currIndicator++;
        }
        
        for (int i = 1; i < sums.length; i++) {
            if (sums[i] > 0) out.println(i);
        }
        out.close();
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}