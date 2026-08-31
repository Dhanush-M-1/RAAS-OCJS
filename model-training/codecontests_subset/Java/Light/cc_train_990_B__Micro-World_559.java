import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n =scan.nextInt();
        int k = scan.nextInt();
        ArrayList<Integer> array=new ArrayList<>();
        int freq[]=new int[1000010];
        int total=n;
        for(int i=0;i<n;i++){
            int h = scan.nextInt();
            if(freq[h]==0) {
                array.add(h);
            }
            freq[h]++;
        }
        Collections.sort(array);
        for(int i=0;i<array.size();){
            if(i>=0 && (i+1)<array.size() && array.get(i+1)>array.get(i) && array.get(i+1)<=(array.get(i)+k)){
                total-=freq[array.get(i)];
//                array.remove(i);

            }
            i++;
        }
        System.out.println(total);
    }
}
