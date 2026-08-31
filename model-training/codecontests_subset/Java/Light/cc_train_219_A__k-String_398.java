import java.util.Scanner;
import java.util.Arrays;

public class kString {

    public static void main (String [] args) {
    	Scanner sc=new Scanner(System.in);
    	int k=sc.nextInt();
    	sc.nextLine();
    	String s=sc.nextLine();
    	char[] c = s.toCharArray();
        Arrays.sort(c);
        s = new String(c);
        String z=StringClean(s);
        char[]chars=z.toCharArray();;
    	int n[]=new int[z.length()];
    	Arrays.fill(n,1);
    	boolean flag=true;
    	for (int i=0; i<z.length(); i++){
    		n[i]=Occur(s,chars[i]);
    		if (n[i]%k!=0)
    			flag=false;
    	}
    	if (flag==false)
    		System.out.println(-1);
    	else
    	{
    		
    		for (int i=0; i<k; i++){
    			for (int j=0; j<z.length(); j++){
    				for (int J=0; J<(n[j]/k); J++)
    					System.out.print(chars[j]);
    			}
    		}
    	System.out.println();
    		
    	}
    	
    	
    	
    			
    	}


    
    
    public static String StringClean(String s){
    	if (s.length()<2)
    		return s;
    	else
    		if (s.charAt(0)==s.charAt(1))
    			return StringClean(s.substring(1));
    		else
    			return s.charAt(0)+StringClean(s.substring(1));
    }
    public static int Occur(String s,char c){
    	int count=0;
    	for (int i=0; i<s.length(); i++){
    		if (s.charAt(i)==c)
    			count++;
    	}
    	return count;
    }
    
    
    
    
}