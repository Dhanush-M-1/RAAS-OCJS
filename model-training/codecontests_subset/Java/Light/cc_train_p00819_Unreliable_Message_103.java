import java.io.*;
import java.util.*;


class Main{
    public static void main(String[] args){
	BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
	
	try {
	    int n = Integer.valueOf(sc.readLine());
	    for(int i=0; i<n; i++){
		char[] org = sc.readLine().toCharArray();
		char[] msg = sc.readLine().toCharArray();
		for(int j=org.length-1; j>=0; j--){
		    if(org[j] == 'M'){
			for(int k=0; k<msg.length; k++){
			    if(msg[k]>='0' && msg[k]<'9')
				msg[k]++;
			    else if(msg[k]=='9')
				msg[k]='0';
			}
		    }
		    else if(org[j] == 'P')
			for(int k=0; k<msg.length; k++){
			    if(msg[k]>'0' && msg[k]<='9')
				msg[k]--;
			    else if(msg[k]=='0')
				msg[k]='9';
			}
		    else if(org[j] == 'A'){
			String b = new String(msg);
			for(int k=0; k<msg.length; k++)
			    msg[k] = b.charAt(msg.length-1-k);
		    }
		    else if(org[j] == 'E'){
			if(msg.length%2==0)
			    for(int k=0; k<msg.length/2; k++){
				char c = msg[k];
				msg[k] = msg[k+msg.length/2];
				msg[k+msg.length/2] = c;
			    }
			else
			    for(int k=0; k<(msg.length-1)/2; k++){
				char c = msg[k];
				msg[k] = msg[k+(msg.length-1)/2+1];
				msg[k+(msg.length-1)/2+1] = c;
			    }
		    }
		    else if(org[j] == 'C'){
			char c = msg[0];
			for(int k=0; k<msg.length-1; k++)
			    msg[k] = msg[k+1];
			msg[msg.length-1] = c;
		    }
		    else if(org[j] == 'J'){
			char c = msg[msg.length-1];
			for(int k=msg.length-1; k>=1; k--)
			    msg[k] = msg[k-1];
			msg[0] = c;
		    }
		}
		String b = new String(msg);
		System.out.println(b);
	    }
	}catch(Exception e){
	    System.out.println("Error");
	}
    }
}