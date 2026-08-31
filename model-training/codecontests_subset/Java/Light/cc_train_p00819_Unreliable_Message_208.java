
import java.util.*;

import static java.lang.System.*;

class Main {
    public static Scanner sc = new Scanner(in);
    public static Random rand=new Random();

    public void run() {
    	int n=sc.nextInt();
    	TCase:while(n--!=0){
    		char[] key=sc.next().toCharArray();
    		char[] str=sc.next().toCharArray();
    		for(int i=key.length-1;i>=0;i--){
    			switch(key[i]){
	    			case 'C':{
	    				char tmp=str[0];
	    				for(int s=0;s+1<str.length;s++){
	    					str[s]=str[s+1];
	    				}
	    				str[str.length-1]=tmp;
	    				break;
	    			}case 'J':{
	    				char tmp=str[str.length-1];
	    				for(int s=str.length-1;s>=1;s--){
	    					str[s]=str[s-1];
	    				}
	    				str[0]=tmp;
	    				break;
	    			}case 'E':{
	    				char[] tmp=Arrays.copyOf(str,str.length);
	    				for(int s=0;s<str.length/2;s++){
	    					str[s]=tmp[s+(1+str.length)/2];
	    				}
	    				for(int s=0;s<str.length/2;s++){
	    					str[s+(1+str.length)/2]=tmp[s];
	    				}
	    				break;
	    			}case 'A':{
	    				char[] tmp=Arrays.copyOf(str,str.length);
	    				for(int s=0;s<str.length;s++){
	    					str[s]=tmp[str.length-1-s];
	    				}
	    				break;
	    			}case 'M':{
	    				for(int s=0;s<str.length;s++){
	    					if(Character.isDigit(str[s]))
	    						str[s]=(char) (((str[s]-'0')+1)%10+'0');
	    				}
	    				break;
	    			}case 'P':{
	    				for(int s=0;s<str.length;s++){
	    					if(Character.isDigit(str[s]))
	    						str[s]=(char) (((str[s]-'0')-1+10)%10+'0');
	    				}
	    				break;
	    			}
    			}
    		}
    		ln(new String(str));
    	}
    }
    public static void main(String[] args) {
        new Main().run();
    }

    public int[] nextIntArray(int n){
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=sc.nextInt();
        }
        return res;
    }
    public static void pr(Object o) {
        out.print(o);
    }
    public static void ln(Object o) {
        out.println(o);
    }
    public static void ln() {
        out.println();
    }
}