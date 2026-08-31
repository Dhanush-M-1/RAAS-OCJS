import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        ArrayList<Integer> second = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<length; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<length; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
            second.add(arr2[i]);
        }
        Collections.sort(second);
        int min = 1000000001;
        for(int i = 0; i<length; i++){
            int add = (arr2[0]+m-arr1[i])%m;
            int[] temp = Arrays.copyOf(arr1,length);
            ArrayList<Integer> tempSet = new ArrayList<>();
            for(int j = 0; j<length; j++){
                tempSet.add((temp[j]+add)%m);
            }
            Collections.sort(tempSet);
            if(second.equals(tempSet)){
                min = Math.min(min,add);
            }

        }
        System.out.println(min);

    }
}
