import java.util.Scanner;


public class C {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			String s=sc.nextLine();
			int pos=-1;
			int t1=0,t2=0;
			for (int i=0;i<s.length();i++)
			{if (s.charAt(i)=='(') t1++; else t1--;
			 if (s.charAt(i)=='#') pos=i;
			}

			if (t1<0) {System.out.println(-1); return;}
			t1++;
			for (int i=0;i<s.length();i++)
			{if (i==pos) t2-=t1;
			  else if (s.charAt(i)=='(') t2++; else t2--;
			 if (t2<0) {System.out.println(-1); return;}
			}


			for (int i=0;i<s.length();i++)
			 if (s.charAt(i)=='#')
			   if (i==pos) System.out.println(t1); else System.out.println(1);
			return;
			}
}
