
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jaber
 */
public class Main {

    public static void main(String[] args) {
        //1: Declare and initialize variables
        Scanner in = new Scanner(System.in);
        short numOfBuckets = in.nextShort(), lengthOfGarden = in.nextShort(),bucket,fitestBucket=0;


        //2: Insert the bucket values into the list
        for (int i = 0; i < numOfBuckets; i++) {
            //A: Get the bucket values
            bucket=in.nextShort();
            
            //B: Check if the length of the garden is divisble by bucket value
            if (lengthOfGarden%bucket==0 && fitestBucket<bucket) {
                    fitestBucket=bucket;
                
            }

        }
        
        
        
        //3: Print the result
        System.out.println(lengthOfGarden/fitestBucket);
        
        
        
        
        
        

    }
}