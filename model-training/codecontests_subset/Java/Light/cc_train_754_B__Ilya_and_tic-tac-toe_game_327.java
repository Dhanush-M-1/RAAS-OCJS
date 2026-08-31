import java.util.*;
public class Main {
	static boolean f=true;
	static void dfs(char a[][]){
		for(int i=2;i<6;i++){
			for(int j=2;j<6;j++){
				if(a[i][j]=='x'&&a[i][j+1]=='x'&&a[i][j+2]=='x'){
					f=false;
					return;
				}
				if(a[i][j]=='x'&&a[i+1][j]=='x'&&a[i+2][j]=='x'){
					f=false;
					return;
				}
				if(a[i][j]=='x'&&a[i+1][j+1]=='x'&&a[i+2][j+2]=='x'){
					f=false;
					return;
				}
				if(a[i][j]=='x'&&a[i-1][j-1]=='x'&&a[i-2][j-2]=='x'){
					f=false;
					return;
				}
				if(a[i][j]=='x'&&a[i-1][j+1]=='x'&&a[i-2][j+2]=='x'){
					f=false;
					return;
				}
				if(a[i][j]=='x'&&a[i+1][j-1]=='x'&&a[i+2][j-2]=='x'){  
	                f=false;  
	                return;  
	              }  
			}
		}
	}
public static void main(String[]args){
	Scanner scan=new Scanner(System.in);
	String a[]=new String[4];
	for(int i=0;i<4;i++){
		a[i]=scan.next();
	}
	char b[][]=new char[8][8];
	for(int i=0;i<8;i++ ){
		for(int j=0;j<8;j++){
			b[i][j]='/';
		}
	}
	for(int i=2;i<6;i++ ){
		for(int j=2;j<6;j++){
			b[i][j]=a[i-2].charAt(j-2);
		}
	}
	for(int i=2;i<6;i++){
		for(int j=2;j<6;j++){
			
			if(f==false){
				System.out.println("YES");
				System.exit(0);
			}
			if(b[i][j]=='.'){
				b[i][j]='x';
				dfs(b);
				if(f==true){
					b[i][j]='.';
				}
			}
			
		}
	}
	
	if(f){
		System.out.println("NO");
	}
	
}
}

		  	     					 								      	