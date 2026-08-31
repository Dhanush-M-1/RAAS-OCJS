import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class q {
public static void main(String[] args) throws IOException {
BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
String a=br.readLine();
//String b=br.readLine();
if(a.charAt(0)==')'||a.charAt(0)=='#'){
	System.out.println(-1);
	System.exit(0);
	}
int bc=0;
int n=0;
int nl=0;
ArrayList<Integer>s=new ArrayList<Integer>();
int nlo=0;
for(int i=0;i<a.length();i++) {
	if(a.charAt(i)=='#') 
		if(bc<=0) {
			System.out.println(-1);
			System.exit(0);
			}else {
				nl=i;
				n++;
			}
	if(a.charAt(i)=='(') {
		bc++;
		nlo=i;
		s.add(i);
	}
	if(a.charAt(i)==')') {
		bc--;
		if(!s.isEmpty())
		s.remove(s.size()-1);
		if(!s.isEmpty())
		nlo=s.get(s.size()-1);
		}
	
		}
if(nlo>nl||n>bc) {
	System.out.println(-1);
	System.exit(0);
}
for(int i=0; i<n-1;i++) 
	System.out.println(1);
System.out.println(bc-(n-1));
}
}