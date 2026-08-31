//import java.io.*;
import java.util.*;
//import java.math.*;
public class Main {
 
    public static void main(String[] args) throws java.io.IOException{
        Scanner scan = new Scanner(System.in);
        int n=0;
        while((n=scan.nextInt())!=0){
        	int [] data =new int[n];
        	for(int i=0;i<n;i++)
        		data[i]=scan.nextInt();
        	
        	int tch=0;
        	
        	while(true){
        		int ch=0;
        	for(int i=0;i<n-1;i++){
        		if(data[i]>data[i+1]){
        			data[i]^=data[i+1];
        			data[i+1]^=data[i];
        			data[i]^=data[i+1];
        			ch++;
        			
        		}
        	}
        	tch+=ch;
        	if(ch==0)break;}
        
        System.out.println(tch);
        }
    }
}