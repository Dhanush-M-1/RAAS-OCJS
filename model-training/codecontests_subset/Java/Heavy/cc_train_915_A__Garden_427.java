
import java.util.*;

 
public class Main {
    public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
                int []array=new int[a];
                for (int i = 0; i < a; i++) {
                    array[i]=in.nextInt();
                }
                Arrays.sort(array);
                for (int i = array.length-1; i >=0; i--) {
                    if(array[i]>b)continue;
                    if(array[i]==b){
                        System.out.println(1);
                        return;
                    }
                    if(b%array[i]==0){
                        System.out.println(b/array[i]);
                        return;
                    }
                }


    }
    
}
