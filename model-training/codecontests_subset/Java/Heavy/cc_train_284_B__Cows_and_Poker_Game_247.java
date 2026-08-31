/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package cowpoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int size=Integer.parseInt(br.readLine()),ICount=0,ACount=0;
        String input=br.readLine();
        for(int i=0;i<input.length();i++){
        if(input.charAt(i)=='A'){
        ACount++;
        }
        else if(input.charAt(i)=='I'){
        ICount++;
        }

        }
                        if(ICount==0){
                            System.out.println(ACount);
                        }
                 else if(ICount==1){
                            System.out.println(1);
                 }
                 else{
                            System.out.println(0);
                 }
    }

}
