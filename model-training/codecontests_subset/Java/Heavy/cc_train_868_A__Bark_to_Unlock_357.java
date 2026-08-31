import java.io.*;
		import java.math.*;
		import java.util.*;
		
	public	class asd {
		public static void main(String args[])throws IOException {
			   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			   String s=br.readLine().trim();
			   int n=Integer.parseInt(br.readLine());
			   String s1[]=new String[n];
			   for(int i=0;i<n;i++)
			   {
				s1[i]=br.readLine().trim();
				if(s.equals(s1[i]))
				{
					System.out.println("YES");
					return;
				}
			   }
			   for(int i=0;i<n;i++)
			   {
				   for(int j=0;j<n;j++)
				   {
					   String z=s1[i].substring(1);
					   z+=s1[j].substring(0, 1);
					   if(z.equals(s))
					   {
						   System.out.println("YES");
							return; 
					   }
				   }
			   }
			   System.out.println("NO");
				
		}
		
		}