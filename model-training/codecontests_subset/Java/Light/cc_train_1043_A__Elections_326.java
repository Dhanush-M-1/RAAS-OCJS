import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner newSc = new Scanner(System.in);
        int n = newSc.nextInt();
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i += 1){
            list.add(newSc.nextInt());
            sum += list.get(i);
        }
        int k = Collections.max(list);

        while(true){
            if(k * n - sum <= sum)
                k += 1;
            else
                break;
        }
        System.out.println(k);
    }
    }