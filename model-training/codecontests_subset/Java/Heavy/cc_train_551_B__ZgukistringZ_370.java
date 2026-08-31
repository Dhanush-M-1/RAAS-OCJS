import java.util.*;
import java.io.*;
public class Programa {

	 
	 
	 public static void main(String [] args){	
	    	Scanner scan = new Scanner (System.in);
	    	String a = scan.next();
	    	String b = scan.next();
	    	String c = scan.next();
	    	int [] alpha = new int[26];
	    	for(int i = 0; i < a.length();i++)
	    		alpha[a.charAt(i)-'a']++;
	    	String ans;
	    	int [] balpha = new int[26];
	    	for(int i = 0; i < b.length();i++)
	    		balpha[b.charAt(i)-'a']++;
	    	int [] calpha = new int[26];
	    	for(int i = 0; i < c.length();i++)
	    		calpha[c.charAt(i)-'a']++;
	    	int max = 0;
	    	int bcount = -1;
	    	int maxb = 0, maxc = 0;
	    	while(true){
	    		boolean check = false;
	    		int [] tem = new int[26];
	    		for(int i = 0; i < 26;i++)
	    			tem[i] = alpha[i];
	    		bcount++;
	    		for(int i = 0; i < 26; i++)
	    			if(bcount*balpha[i] > tem[i]){
	    				check = true;
	    				break;
	    			}
	    		if(check) break;
	    		for(int i = 0; i < 26; i++)
	    			tem[i] -= bcount * balpha[i];
	    		int ccount = (int)2e9;
	    		for(int i = 0; i < 26; i++){
	    			if(calpha[i] != 0)
	    				ccount = Math.min(ccount, tem[i]/calpha[i]);
	    		}
	    		if(max < bcount + ccount){
	    			max = bcount + ccount;
	    			maxb = bcount;
	    			maxc = ccount;
	    		}
	    	}
	    	for(int i = 0;i < 26; i++)
	    		alpha[i] -= maxb*balpha[i];
	    	for(int i = 0;i < 26; i++)
	    		alpha[i] -= maxc*calpha[i];
	    	for(int i = 0; i < maxb; i++)
	    		System.out.print(b);
	    	for(int i = 0; i < maxc; i++)
	    		System.out.print(c);
	    	for(int i = 0; i < 26; i++)
	    		for(int j = 0; j < alpha[i]; j++)
	    			System.out.print((char)(i+'a'));
	    }

    /*
     
    		
    	
     */
}
