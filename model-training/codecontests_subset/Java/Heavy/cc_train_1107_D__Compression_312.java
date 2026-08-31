import java.util.*;
import java.io.*;
/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
Integer.parseInt(st.nextToken());
Long.parseLong(st.nextToken());
Scanner sc = new Scanner(System.in);


*/



public class Waw{
    
    public static int pgcd(int n,int m){
        if(m==0) return n;
        return pgcd(m,n%m);
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] s = new String[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            s[i] = st.nextToken();
        }
        
        int gcd = n;
        int nb = 1;
        for(int i=1;i<n;i++){
            if(!s[i].equals(s[i-1])){
                gcd = pgcd(Math.max(gcd,nb),Math.min(gcd,nb));
                nb = 0;
            }
            nb++;
            
        }
        
        gcd = pgcd(Math.max(gcd,nb),Math.min(gcd,nb));
        
        if(gcd==1) System.out.println("1");
        else{
            String[] h = new String[16];
            for(int i=0;i<16;i+=2){
                h[i] = "0";
                h[i+1] = "1";
            }
            for(int i=0;i<16;i+=4){
                for(int j=i;j<i+2;j++){
                    h[j] = "0" + h[j];
                }
                for(int j=i+2;j<i+4;j++){
                    h[j] = "1" + h[j];
                }
            }
            for(int i=0;i<16;i+=8){
                for(int j=i;j<i+4;j++){
                    h[j] = "0" + h[j];
                }
                for(int j=i+4;j<i+8;j++){
                    h[j] = "1" + h[j];
                }
            }
            for(int i=0;i<16;i+=16){
                for(int j=i;j<i+8;j++){
                    h[j] = "0" + h[j];
                }
                for(int j=i+8;j<i+16;j++){
                    h[j] = "1" + h[j];
                }
            }
            
            HashMap<Character,String> m = new HashMap<Character,String>();
            m.put('0',h[0]);
            m.put('1',h[1]);
            m.put('2',h[2]);
            m.put('3',h[3]);
            m.put('4',h[4]);
            m.put('5',h[5]);
            m.put('6',h[6]);
            m.put('7',h[7]);
            m.put('8',h[8]);
            m.put('9',h[9]);
            m.put('A',h[10]);
            m.put('B',h[11]);
            m.put('C',h[12]);
            m.put('D',h[13]);
            m.put('E',h[14]);
            m.put('F',h[15]);
            int g = gcd;
            String a = new String();
            boolean ok = true;
            char[] c = new char[4];
            for(int k=0;k<n;k+=gcd){
                nb = 0;
                ok = true;
                for(int j=0;j<n/4;j++){
                    a = m.get(s[k].charAt(j));
                    for(int i=0;i<4;i++) c[i] = a.charAt(i);
                    for(int i=0;i<4;i++){
                        if(nb==0){
                        
                            if(c[i]=='0') ok = false;
                            else ok = true;
                        }
                        else{
                            
                            if(ok){
                                if(c[i]!='1'){
                                    g = pgcd(Math.max(g,nb),Math.min(g,nb));
                                    nb = 0;
                                    ok = false;
                                }
                            }else{
                                if(c[i]=='1'){
                                    g = pgcd(Math.max(g,nb),Math.min(g,nb));
                                    nb = 0;
                                    ok = true;
                                }
                            }
                            
                            
                            
                            
                            
                        }
                        nb++;
                    }
                    
                }
            }
            
            System.out.println(g);
            
            
            
        }
        
    	
    }
}