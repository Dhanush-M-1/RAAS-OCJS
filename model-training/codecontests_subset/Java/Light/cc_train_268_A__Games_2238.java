import java.util.*;

public class JavaApplication10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(),count=0;
        int arr_x[] = new int[102];
        int arr_y[] = new int[102];
        while(n > 0){
            int x = scan.nextInt(),y = scan.nextInt();
            if(arr_x[y] > 0)
                count+=arr_x[y];
            
            if(arr_y[x] > 0)
                count+=arr_y[x];
            
            arr_x[x]++;
            arr_y[y]++;
            n--;
        }
        System.out.println(count);
                
    }

}
