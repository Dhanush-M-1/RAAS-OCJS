import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Comparator;
import javafx.util.Pair;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException ,FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
			String str = sc.nextLine();
			int ans=0,mx=-1;
			String res="";
			int dm[] = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
			Map<String,Integer> hmap = new HashMap<>();
			for(int y = 2013;y<=2015;y++)
			{
				for(int m=1;m<=12;m++)
				{
					for(int d=1;d<=dm[m];d++)
					{
						String date = String.format("%02d-%02d-%04d",d,m,y);
						int f = (str.length()-str.replace(date,"").length())/10;
						hmap.put(date,f);
						if(hmap.get(date)>mx)
						{
							mx= hmap.get(date);
							res = date;
						}
					}
				}
			}
			out.println(res);
		out.flush();
	}
}