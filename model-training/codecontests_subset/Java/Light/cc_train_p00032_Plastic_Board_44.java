import java.io.*;

import java.util.*;

import java.math.*;
import java.util.regex.Pattern;

import java.util.regex.Matcher;



class Main{

	public static int calc_plastic(int l1,int l2,int d){
		int l1a,l2a,da;
		l1a = (int)Math.pow(l1,2);
		l2a = (int)Math.pow(l2,2);
		da = (int)Math.pow(d,2);

		if(l1 == l2) return 2;
		else if(l1a+l2a == da) return 1;
		return 0;
	}

	


	public static void plastic(ArrayList<Integer> list){
		int oblong=0,diamond=0;
		int len1,len2,diag,res;

		for(int i=0;i<list.size()/3;i++){
			len1 = list.get(i*3);
			len2 = list.get(i*3+1);
			diag = list.get(i*3+2);
			res = calc_plastic(len1,len2,diag);
			if(res == 1) oblong++;
			else if(res == 2)diamond++;
		}
		System.out.println(oblong);
		System.out.println(diamond);
	}

		

	public static void main(String args[]) throws IOException{

		String str;

		ArrayList <Integer> inp = new ArrayList<Integer>();



		Scanner scan = new Scanner(System.in);



		while(scan.hasNext()){
			str = scan.next();

			String [] strAry = new String[str.length()];

			strAry = str.split(",");

			for(int j=0;j<strAry.length;j++){

				Pattern p = Pattern.compile("[0-9]*");

				Matcher m = p.matcher(strAry[j]);

				if(m.find()){

					int x = Integer.valueOf(m.group(0)).intValue();

					inp.add(x);

				}

			}

		}

		plastic(inp);

	}

}