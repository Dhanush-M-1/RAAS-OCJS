import java.util.*;
import java.io.*;

class Main{
	public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
for(;;){
	int time =0;
	int time2 =0;
	int t =sc.nextInt();
	int m =sc.nextInt();
	int s =sc.nextInt();
	if(t==-1) break;
	
	time += t*3600; time += m*60; time += s;
	time = 7200-time; 
	time2 =time*3;
	
	t = time/3600;
	m = time%3600/60;
	s = time%3600%60;
	System.out.printf("%02d",t );
	System.out.printf(":%02d",m );
	System.out.printf(":%02d\n",s );
	t = time2/3600;
	m = time2%3600/60;
	s = time2%3600%60;
	System.out.printf("%02d",t );
	System.out.printf(":%02d",m );
	System.out.printf(":%02d\n",s );
}
	}
	}