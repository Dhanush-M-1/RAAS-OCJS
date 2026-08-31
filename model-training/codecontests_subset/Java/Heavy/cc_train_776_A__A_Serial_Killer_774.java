
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        String str;
        String[][] names = new String[1001][2];
        names[0][0] = in.next();
        names[0][1] = in.next();
        
        int n = in.nextInt();
        
        for(int i = 1; i <= n; i++){
            names[i][0] = in.next();
            names[i][1] = in.next();
        }
        
        System.out.println(names[0][0] + " " + names[0][1]);
        
        for(int i = 1; i <= n; i++){
            if(names[i-1][0].equals(names[i][0])){
                names[i][0] = names[i-1][1];
            }else{
                names[i][0] = names[i-1][0];
            }
            System.out.println(names[i][0] + " " + names[i][1]);
        }
       
    }
}
