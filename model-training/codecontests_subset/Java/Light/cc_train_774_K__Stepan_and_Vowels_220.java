import java.util.*;

public class EZ{
    public static void main(String[] argc){
        Scanner cin = new Scanner(System.in);
        
        int N = cin.nextInt();
        String arr = cin.next();
        
        for (int i = 0; i < N;){
            char y = arr.charAt(i);
            
            if (y != 'a' && y != 'e' && y != 'o' && y != 'y' && y != 'i' && y != 'u'){
                System.out.print(y); i++;
                continue;
            }
            
            boolean ok = (arr.charAt(i) == 'e' || arr.charAt(i) == 'o');
            int j = i;
            
            for (j = i; j < N && arr.charAt(j) == arr.charAt(i);)
                j++;
            
            if (ok == true && j - i == 2){
                for (int k = i; k < j; k++)
                    System.out.print(arr.charAt(k));
            }
            else{
                System.out.print(arr.charAt(i));   
            }
            
            i = j;
        }
        
        
    }
}