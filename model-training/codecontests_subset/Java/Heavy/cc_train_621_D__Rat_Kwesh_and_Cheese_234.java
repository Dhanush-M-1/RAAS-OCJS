
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan1.4 1.2 1.4

 */
public class fourthProblem {
  
    static double error=0.000000000000001;
    static int findMaxAns(double x,double y,double z){
        //System.out.println((Math.pow(Math.pow(z,x), y)-Math.pow(Math.pow(x,y), z))-0.000000000000001);
        double nextVal;
        boolean found=false;
        if(x>1){
                found=true;
                maxVal=Math.log(Math.log(x))+z*Math.log(y);
                ans=1;
                nextVal=Math.log(Math.log(x))+y*Math.log(z);
                if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                    maxVal=nextVal;
                    ans=2;
                }
                nextVal=Math.log(Math.log(x))+Math.log(y)+Math.log(z);
                if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                    //System.out.println("VLEGUVA "+(nextVal-maxVal));
                    maxVal=nextVal;
                    ans=3;
                }
        }
        if(y>1){
                if(!found){
                    maxVal=Math.log(Math.log(y))+z*Math.log(x);
                    ans=5;
                    found=true;
                }
                nextVal=Math.log(Math.log(y))+z*Math.log(x);
                if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                    maxVal=nextVal;
                    ans=5;
                }
                nextVal=Math.log(Math.log(y))+x*Math.log(z);
                if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                    maxVal=nextVal;
                    ans=6;
                }
                nextVal=Math.log(Math.log(y))+Math.log(x)+Math.log(z);
                if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                    maxVal=nextVal;
                    ans=7;
                }        
        }
        if(z>1){
                if(!found){
                    maxVal=Math.log(Math.log(z))+y*Math.log(x);
                    ans=9;
                    found=true;
                }
                nextVal=Math.log(Math.log(z))+y*Math.log(x);
                if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                    maxVal=nextVal;
                    ans=9;
                }
                nextVal=Math.log(Math.log(z))+x*Math.log(y);
                if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                    maxVal=nextVal;
                    ans=10;
                }
                nextVal=Math.log(Math.log(z))+Math.log(x)+Math.log(y);
                if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                    //System.out.println("VLEGUVA I VO VTOROTO "+(nextVal-maxVal));
                    maxVal=nextVal;
                    ans=11;
                }                        
        }
        
        if(!found)
            return findMinAns(x,y,z);
        else
            return ans;
    }
    
    static int findMinAns(double x,double y,double z){
        double nextVal;
        maxVal=Math.pow(x, Math.pow(y,z));
        ans=1;
        nextVal=Math.pow(x, Math.pow(z,y));
        if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                maxVal=nextVal;
                ans=2;
        }
        nextVal=Math.pow(Math.pow(x, y),z);
        if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                maxVal=nextVal;
                ans=3;
        }
        nextVal=Math.pow(y, Math.pow(x,z));
        if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                maxVal=nextVal;
                ans=5;
        }  
        nextVal=Math.pow(y, Math.pow(z,x));
        if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                maxVal=nextVal;
                ans=6;
        }
        nextVal=Math.pow(Math.pow(y, x),z);
        if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                maxVal=nextVal;
                ans=7;
        }
        nextVal=Math.pow(z, Math.pow(x,y));
        if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                maxVal=nextVal;
                ans=9;
        }
        nextVal=Math.pow(z, Math.pow(y,x));
        if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                maxVal=nextVal;
                ans=10;
        }
        nextVal=Math.pow(Math.pow(z, x),y);
        if(Math.abs(nextVal-maxVal)>=error&&nextVal>maxVal){
                maxVal=nextVal;
                ans=11;
        }
        return ans;
    }
    static HashMap<Integer,String> res=new HashMap<>();
    static int ans;
    static double maxVal;
    public static void main(String[] args) throws IOException {
        res.put(1,"x^y^z");
        res.put(2,"x^z^y");
        res.put(3,"(x^y)^z");
        res.put(4,"(x^z)^y");
        res.put(5,"y^x^z");
        res.put(6,"y^z^x");
        res.put(7,"(y^x)^z");
        res.put(8,"(y^z)^x");
        res.put(9,"z^x^y");
        res.put(10,"z^y^x");
        res.put(11,"(z^x)^y");
        res.put(12,"(z^y)^x");
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        double y=sc.nextDouble();
        double z=sc.nextDouble();
        System.out.println(res.get(findMaxAns(x,y,z)));
    }
    
}

class FastReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        
        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
         public long nextL() throws IOException{
            return Long.parseLong(next());
        }
    }