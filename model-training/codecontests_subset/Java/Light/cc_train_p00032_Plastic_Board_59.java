


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String line;
            int recC=0,lozC=0;
            while((line=br.readLine())!=null){  if(line.equals(""))break;
                String[] splited = line.split(",");
                int n1 = Integer.parseInt(splited[0]);
                int n2 = Integer.parseInt(splited[1]);
                int n3 = Integer.parseInt(splited[2]);
                if(n1*n1+n2*n2==n3*n3)recC++;
                if(n1==n2)lozC++;
               
            }         
            System.out.println(recC);
            System.out.println(lozC);
        }catch(Exception e){e.printStackTrace();}
        
    }
    
}