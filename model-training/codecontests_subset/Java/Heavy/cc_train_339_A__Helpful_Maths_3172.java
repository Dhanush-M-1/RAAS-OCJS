import java.util.Arrays;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class HelpfulMaths {
	public static ArrayList<Integer> arr(String x) {
		ArrayList<Integer> arrayList =new ArrayList<Integer>();
		for(int i=0;i<x.length();i++)
			if(x.charAt(i)!='+')
				arrayList.add(Integer.parseInt("" +x.charAt(i)));
		Collections.sort(arrayList);
		return arrayList;
	}
	public static void main(String[] args) throws IOException {
		PrintWriter pw=new PrintWriter(System.out);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		String x=st.nextToken();
		ArrayList<Integer> arrayList =new ArrayList<Integer>();
		arrayList=arr(x);
		for(int i=0;i<x.length();i++) {
			if(i%2==0)
				pw.print(arrayList.remove(0));
			else
				pw.print("+");
		}
		
		pw.flush();
		pw.close();
	}

}
