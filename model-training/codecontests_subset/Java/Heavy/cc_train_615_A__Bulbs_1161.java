import java.util.Scanner;
import java.lang.Math;
public class ProblemSolving  { 
   public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        int n,m;
        n= input.nextInt(); // no. of buttons.
        m= input.nextInt(); // no. of bulbs.
        
        boolean [] array = new boolean[m]; // store my bulbs {0,0,0,0,....}
        
        for(int i = 0; i<n; i++){
            int nb = input.nextInt(); // number of bulbs will turn on by this button
            for(int j =0; j<nb; j++){
                int wb = input.nextInt()-1; // which bulb in my array !
                array[wb]=true;
            }
        }
        
        //check if all the bulbs turned on or not.
        int count = 0;
        for(int w=0; w<array.length; w++){ 
            if(array[w]==true){
                count++;
            } 
        }

        String output = (count==m)?"YES":"NO"; //If the number of bulbs turns on = the number of all bulbs  
        System.out.println(output); 
        input.close();
    }
}