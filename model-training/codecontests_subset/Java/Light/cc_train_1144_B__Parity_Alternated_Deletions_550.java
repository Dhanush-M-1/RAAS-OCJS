import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
       ArrayList<Integer> even = new ArrayList<>();
       ArrayList<Integer> odd = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int k = s.nextInt();
            if(k % 2 == 0){
                even.add(k);
            }
            else{
                odd.add(k);
            }
        }
        Collections.sort(even,Collections.reverseOrder());
        Collections.sort(odd,Collections.reverseOrder());
        if(even.size() == odd.size()){
            System.out.println(0);
        }
        else if(even.size() > odd.size()){
            long sum = 0;
            for(int i = odd.size() + 1; i < even.size(); i++){
                sum += even.get(i);
            }
            System.out.println(sum);
        }
        else{
            long sum = 0;
            for(int i = even.size() + 1; i < odd.size(); i++){
                sum += odd.get(i);
            }
            System.out.println(sum);
        }
        


    }
}