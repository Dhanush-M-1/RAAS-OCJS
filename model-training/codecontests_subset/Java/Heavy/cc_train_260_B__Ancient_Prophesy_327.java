import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
public class A {
		public static class Pair {
			int no;
			String s;
			public Pair(int no,String s){
				this.no=no;
				this.s=s;
			}
		}
		
		public static void main(String[] args) throws IOException  {
			FastReader sc=new FastReader();
			String s=sc.next();
			Pair p[]=new Pair[s.length()]; 
			int c=0;
			String st="";
			int a[]=new int[13];
			int count=0;
			a[1]=31;a[2]=28;a[3]=31;a[4]=30;a[5]=31;a[6]=30;a[7]=31;a[8]=31;a[9]=30;a[10]=31;a[11]=30;a[12]=31;
			for(int i=s.length();i>=10;i--){
				if(s.substring(i-4, i).equals("2013") ||  s.substring(i-4, i).equals("2014") || s.substring(i-4, i).equals("2015")){
				//	System.out.println(s.charAt(i-5));
					if(s.charAt(i-5)=='-'){
					//	System.out.println(s.charAt(i-6));
						if(String.valueOf(s.charAt(i-6)).matches(".*[0-9].*")){
						//	System.out.println(s.charAt(i-6));
							String s1="";
							if(String.valueOf(s.charAt(i-7)).matches(".*[0-9].*")) s1+=String.valueOf(s.charAt(i-7));
							s1+=String.valueOf(s.charAt(i-6));
							if(Integer.parseInt(s1)>0 && Integer.parseInt(s1)<=12){
								if(s1.length()==2){
									if(s.charAt(i-8)=='-'){
									   if(String.valueOf(s.charAt(i-9)).matches(".*[0-9].*") && String.valueOf(s.charAt(i-10)).matches(".*[0-9].*")){
										   String s2=String.valueOf(s.charAt(i-10))+String.valueOf(s.charAt(i-9));
										   if(Integer.parseInt(s2)<=a[Integer.parseInt(s1)] && Integer.parseInt(s2)>0){
											   String finals=s2+"-"+s1+"-"+s.substring(i-4,i);
											 //  System.out.println(finals);
											   boolean isequal=false;
											   for(int j=0;j<c;j++){
												   if(p[j].no>=count){
													   count=p[j].no;
													   st=p[j].s;
												   }
												   if(p[j].s.equals(finals)){
													   p[j].no++;
													   isequal=true;
													   if(p[j].no>=count){
														   count=p[j].no;
														   st=p[j].s;
													   }
												   }
											   }
											   if(!isequal){
												   p[c++]=new Pair(1,finals);
												   if(p[c-1].no>=count){
													   count=p[c-1].no;
													   st=p[c-1].s;
												   }
											   }
										   }
									   }
									}
								}
								
							}
						}
					}
				}
				
			}
			System.out.println(st);
		}
		
       static class FastReader
		    {
		        BufferedReader br;
		        StringTokenizer st;
		 
		        public FastReader(){
		        		br = new BufferedReader(new InputStreamReader(System.in));
		        }
		 
		        String next()
		        {
		            while (st == null || !st.hasMoreElements())
		            {
		                try
		                {
		                    st = new StringTokenizer(br.readLine());
		                }
		                catch (IOException  e)
		                {
		                    e.printStackTrace();
		                }
		            }
		            return st.nextToken();
		        }
		 
		        int nextInt()
		        {
		            return Integer.parseInt(next());
		        }
		 
		        long nextLong()
		        {
		            return Long.parseLong(next());
		        }
		 
		        double nextDouble()
		        {
		            return Double.parseDouble(next());
		        }
		 
		        String nextLine()
		        {
		            String str = "";
		            try
		            {
		                str = br.readLine();
		            }
		            catch (IOException e)
		            {
		                e.printStackTrace();
		            }
		            return str;
		        }
		    }
}
