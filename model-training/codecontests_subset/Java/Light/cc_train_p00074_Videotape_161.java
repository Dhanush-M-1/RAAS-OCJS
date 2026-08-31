import java.io.*;
import java.util.*;
import java.math.*;
class Main{
    public static void main(String[] args){
    BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
    try {
	while(true){
	String st = sc.readLine();
	if(st.equals("-1 -1 -1"))
		break;
	String[] sp = st.split(" ");
	int hours = Integer.valueOf(sp[0]);
	int minutes = Integer.valueOf(sp[1]);
	int seconds = Integer.valueOf(sp[2]);
	int total = hours*60*60+minutes*60+seconds;
	int remains = 120*60-total;
	int remains3 = 120*60*3-total*3;
	System.out.printf("%02d:%02d:%02d",remains/3600,(remains-(remains/3600)*3600)/60,remains%60);
	System.out.println();
	System.out.printf("%02d:%02d:%02d",remains3/3600,(remains3-(remains3/3600)*3600)/60,remains3%60);
	System.out.println();
	}
    }catch(Exception e){
        System.out.println("Error");
    }
    }
}