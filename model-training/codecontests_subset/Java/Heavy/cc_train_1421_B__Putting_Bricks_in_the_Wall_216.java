import java.util.*;
import java.lang.*;
import java.io.*;

public class Hello{
	public static class MyScanner{   		
		BufferedReader read;
		StringTokenizer token;	
        public MyScanner(){     
        	read=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(token==null || !token.hasMoreElements()){
                try{
                	token=new StringTokenizer(read.readLine());
                }
                catch(IOException e){
                	e.printStackTrace();
                }
            }
            return token.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }     
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble() {
        	return Double.parseDouble(next());
        }
        float nextFloat() {
        	return Float.parseFloat(next());
        }
        String nextLine(){
            String str="";
            try{
            	str=read.readLine();
            }
            catch(IOException e){
            	e.printStackTrace();
            }
            return str;
        }	
	}
		
	public static void main(String[] args)throws IOException{
		MyScanner sc=new MyScanner();
		StringBuilder sb=new StringBuilder();
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			char a[][]=new char[n][n];
			for(int i=0;i<n;i++) {
				String str=sc.next();
				for(int j=0;j<n;j++) {
					a[i][j]=str.charAt(j);
				}
			}
			int a12=a[0][1]-'0';
			int a21=a[1][0]-'0';
			int bij=a[n-2][n-1]-'0';
			int bji=a[n-1][n-2]-'0';
			
			if((a12^a21)==0 && (bij^bji)==0) {
				if(a12==bij) {
					sb.append(2+"\n");
					sb.append(1+" "+2+"\n");
					sb.append(2+" "+1+"\n");
					
				}
				else {
					sb.append(0+"\n");
				}
			}
			else if((a12^a21)!=0 && (bij^bji)!=0) {
				if(a12!=bij) {
					sb.append(2+"\n");
					sb.append(1+" "+2+"\n");
					sb.append((n-1)+" "+n+"\n");
				}
				else {
					sb.append(2+"\n");
					sb.append(1+" "+2+"\n");
					sb.append(n+" "+(n-1)+"\n");
				}
			}
			
			else {
				if((a12^a21)==0) {
					if(a12==bij) {
						sb.append(1+"\n");
						sb.append((n-1)+" "+n+"\n");
					}
					else {
						sb.append(1+"\n");
						sb.append(n+" "+(n-1)+"\n");
					}
				}
				else if((bij^bji)==0){
					if(a12==bij) {
						sb.append(1+"\n");
						sb.append(1+" "+2+"\n");
					}
					else {
						sb.append(1+"\n");
						sb.append(2+" "+1+"\n");
					}
				}
			}
			
			
		  
		}	
		System.out.println(sb);
	}
}

