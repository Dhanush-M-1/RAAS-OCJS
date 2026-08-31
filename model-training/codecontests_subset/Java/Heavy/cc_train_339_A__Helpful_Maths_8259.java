
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pc
 */
public class Anothersolution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input, output;
        char c;
        int[] occurences = new int[3];
        
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        output = new String();
        
        for(int i = 0; i < input.length(); i++)
        {
           c = input.charAt(i);
           if(c == '+'){}
           else if(c == '1'){occurences[0]++;}
           else if(c == '2'){occurences[1]++;}
           else
               occurences[2]++;
        }
        
        for(int i = 0; i < occurences.length; i++){
            for(int j = 0; j < occurences[i]; j++){
                if(output.length()+1 >= input.length()-1)
                    output += (i+1);
                else
                    output += (i+1)+"+";
            }
        }
        
        System.out.println(output);
    }
    
}
