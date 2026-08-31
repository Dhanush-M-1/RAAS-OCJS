
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;


/**
 *
 * @author jmbangue
 */
public class MinimumInteger {

    public static void main(String[] args){
        BufferedInputStream bf = new BufferedInputStream(System.in);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(bf, StandardCharsets.UTF_8));
        OutputStream out = new BufferedOutputStream ( System.out );
        try {
            int t = Integer.parseInt(in.readLine());
            while(t-->0){
                String[] lrd = in.readLine().split(" ");
                int l = Integer.parseInt(lrd[0]);
                int r = Integer.parseInt(lrd[1]);
                int d = Integer.parseInt(lrd[2]);
                System.out.println( d < l ? d : (r/d + 1)*d);
            }   
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
         
    }
}
