
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] teams = new int [n][2];
        
        int out = 0;
        //getting inputs
        for (int i = 0; i < n; i++) {
            teams[i][0]=in.nextInt();
            teams[i][1]=in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int counter = 0;
            for (int j = 0; j <n ; j++) {
                if(teams[i][1]==teams[j][0] && i!=j)
                    counter++;
            }
            out +=counter; 
            //System.out.println("out is : "+out);
        }
        System.out.println(out);
        
        
                       
        
        

    }
}
