						import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
										public class Solution implements Runnable
										{
											static final long MAX = 1000000007L;
											static class InputReader
											{
												private InputStream stream;
												private byte[] buf = new byte[1024];
												private int curChar;
												private int numChars;
												private SpaceCharFilter filter;
												private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
										 
												public InputReader(InputStream stream)
												{
													this.stream = stream;
												}
												
												public int read()
												{
													if (numChars==-1) 
														throw new InputMismatchException();
													
													if (curChar >= numChars)
													{
														curChar = 0;
														try 
														{
															numChars = stream.read(buf);
														}
														catch (IOException e)
														{
															throw new InputMismatchException();
														}
														
														if(numChars <= 0)				
															return -1;
													}
													return buf[curChar++];
												}
											 
												public String nextLine()
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
												public int nextInt()
												{
													int c = read();
													
													while(isSpaceChar(c)) 
														c = read();
													
													int sgn = 1;
													
													if (c == '-') 
													{
														sgn = -1;
														c = read();
													}
													
													int res = 0;
													do 
													{
														if(c<'0'||c>'9') 
															throw new InputMismatchException();
														res *= 10;
														res += c - '0';
														c = read();
													}
													while (!isSpaceChar(c)); 
													
													return res * sgn;
												}
												
												public long nextLong() 
												{
													int c = read();
													while (isSpaceChar(c))
														c = read();
													int sgn = 1;
													if (c == '-') 
													{
														sgn = -1;
														c = read();
													}
													long res = 0;
													
													do 
													{
														if (c < '0' || c > '9')
															throw new InputMismatchException();
														res *= 10;
														res += c - '0';
														c = read();
													}
													while (!isSpaceChar(c));
														return res * sgn;
												}
												
												public double nextDouble() 
												{
													int c = read();
													while (isSpaceChar(c))
														c = read();
													int sgn = 1;
													if (c == '-') 
													{
														sgn = -1;
														c = read();
													}
													double res = 0;
													while (!isSpaceChar(c) && c != '.') 
													{
														if (c == 'e' || c == 'E')
															return res * Math.pow(10, nextInt());
														if (c < '0' || c > '9')
															throw new InputMismatchException();
														res *= 10;
														res += c - '0';
														c = read();
													}
													if (c == '.') 
													{
														c = read();
														double m = 1;
														while (!isSpaceChar(c)) 
														{
															if (c == 'e' || c == 'E')
																return res * Math.pow(10, nextInt());
															if (c < '0' || c > '9')
																throw new InputMismatchException();
															m /= 10;
															res += (c - '0') * m;
															c = read();
														}
													}
													return res * sgn;
												}
												
												public String readString() 
												{
													int c = read();
													while (isSpaceChar(c))
														c = read();
													StringBuilder res = new StringBuilder();
													do 
													{
														res.appendCodePoint(c);
														c = read();
													} 
													while (!isSpaceChar(c));
													
													return res.toString();
												}
											 
												public boolean isSpaceChar(int c) 
												{
													if (filter != null)
														return filter.isSpaceChar(c);
													return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
												}
											 
												public String next() 
												{
													return readString();
												}
												
												public interface SpaceCharFilter 
												{
													public boolean isSpaceChar(int ch);
												}
											}
										 	
											public static void main(String args[]) throws Exception
											{
												new Thread(null, new Solution(),"Solution",1<<26).start();
											}
												
											ArrayList<Integer> adj[];
											int size;
											int depth[];
											int parent[];
											int jparent[];
											public void run() 
											{
												InputReader sc= new InputReader(System.in);
												PrintWriter w= new PrintWriter(System.out);
												int n = sc.nextInt();
												String s=  sc.next();
												HashMap<String,Integer> hmap = new HashMap();
												for(int i = 0;i < s.length()-1;i++){
													if(!hmap.containsKey(s.substring(i,i+2))){
														hmap.put(s.substring(i,i+2),0);
													}
													hmap.put(s.substring(i,i+2),hmap.get(s.substring(i,i+2))+1);
												}
												int ans = Integer.MIN_VALUE;
												String fans = "";
												for(String st: hmap.keySet()){
													if(ans < hmap.get(st)){
														fans = st;
														ans = hmap.get(st);
													}
												}
												w.println(fans);
												w.close();
											}
											
											static class Pair implements Comparable<Pair>{
												int a;
												long b;
												Pair(int a,long b){
													this.a  =a;
													this.b = b;
												}
												Pair(){}	
												public boolean equals(Object o)
												{
													Pair p = (Pair)o;
													return (p.a==this.a && p.b== this.b);
												}
												
												public int compareTo(Pair p){
													return Long.compare(this.a,p.a);
												}
												public int hashCode(){
												
													return new Integer(a).hashCode()*31 + new Long(b).hashCode()*17;
												}
											}
							}
