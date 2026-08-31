import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class Test {
	public static void redirectIn(String fileName){
		FileInputStream fileStream=null;
		try {
			fileStream=new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedInputStream input=new BufferedInputStream(fileStream);
		System.setIn(input);
	}
	public static void redirectOut(String fileName){
		FileOutputStream fileStream=null;
		try {
			fileStream=new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream output=new PrintStream(fileStream);
		System.setOut(output);
	}
	public static Scanner initCin(){
//		redirectIn("test.in");
		return new Scanner(new BufferedInputStream(System.in));
	}
	public static PrintStream initOut(){
//		redirectOut("output.txt");
		return System.out;
	}
	
	public final static PrintStream out=initOut();
	public final static Scanner cin=initCin();
	
	static HashMap<Integer, Integer> map=new HashMap<>();
	static int[] monthDays={0,31,28,31,30,31,30,31,31,30,31,30,31};
	static void parseDate(String date){
		if(date.charAt(2)!='-'||date.charAt(5)!='-') return;
		String days=date.substring(0,2),months=date.substring(3,5),years=date.substring(6,10);
		int d=0,m=0,y=0,hash=0;
		try {
			d=Integer.parseInt(days);
			m=Integer.parseInt(months);
			y=Integer.parseInt(years);
		} catch (Exception e) {
			return;
		}
		if(y<2013||y>2015) return;
		if(m<1||m>12) return;
		if(d<1||d>monthDays[m]) return;
		hash=(((d<<4)+m)<<11)+y;
		if(map.containsKey(hash)){
			map.put(hash, map.get(hash)+1);
		}else{
			map.put(hash, 1);
		}
	}
	public static void main(String[] args){
		String text=cin.next();
		for(int i=0;i<=text.length()-10;++i){
			parseDate(text.substring(i, i+10));
		}
		Entry<Integer, Integer> maxKey=null;
		for(Entry<Integer, Integer> key:map.entrySet()){
			if(maxKey==null) maxKey=key;
			else if(key.getValue()>maxKey.getValue()) maxKey=key;
		}
		int d=maxKey.getKey()>>15,m=(maxKey.getKey()>>11)&(15),y=maxKey.getKey()&2047;
		out.printf("%02d-%02d-%d", d,m,y);
		return;
	}
}
