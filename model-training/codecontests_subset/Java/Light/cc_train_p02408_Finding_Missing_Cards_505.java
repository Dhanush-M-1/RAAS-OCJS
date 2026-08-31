
import java.util.*;

class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int n;
String a;
int b = 0;
int[][]kard = new int[4][13];
String []mark = {"S","H","C","D"};
n = sc.nextInt();
for(int i=0; i<n; i++){ 
a = sc.next();
b = sc.nextInt();
for(int d=0; d<4; d++){
if(mark[d].equals(a))
kard[d][b-1]++;
}
}
for(int c=0; c<4; c++){
	for(int d=0; d<13; d++){
		if( kard[c][d]==0) System.out.println(mark[c]+" "+(d+1)); 
	}
}
}
}