
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alexis
 */
public class CodeChallenge2019 {
    
    public static void transaltion(){
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        String palabraA = scan.nextLine();
        String palabraB = scan.nextLine();
        int len = palabraA.length() - 1;
        boolean trans = true;
        if(palabraA.length() == palabraB.length()){            
            for (int i = 0; i < palabraA.length(); i++) {
                if(palabraA.charAt(i) != palabraB.charAt(len)){
                    trans = false;
                }
                len--;
            }
        }else{
            trans = false;
        }
        if(trans){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    
    public static void helpfullMaths(){
        
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        String operacion = scan.nextLine();
        
        String[] chars = operacion.split("\\+");
        //System.out.println(chars);
        int[] nums = new int[chars.length]; 
        for(int i = 0; i < chars.length; i++){
            nums[i] = Integer.parseInt(chars[i]);
        }
        
        Arrays.sort(nums); 
        String suma = "";
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length-1){
                suma += String.valueOf(nums[i]);
            }else{
                suma += String.valueOf(nums[i]) + "+";
            }
        }
        System.out.println(suma);
    }
    
    public static void main(String[] args) {
        //transaltion();
        helpfullMaths();
    }
    
}
