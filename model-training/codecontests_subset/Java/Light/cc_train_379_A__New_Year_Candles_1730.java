import java.util.*;
//import java.util.Arrays;
import java.lang.Math; 
public class Main15{

    
    public static void main(String[] args) {
        
        
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int sum=a;
        for(int i=10;i>0;i++){
            if(a>=b){
                a=a-b+1;
                sum++;
            }
            else{
                System.out.println(sum);
                break;
            }
        }
        }
    }