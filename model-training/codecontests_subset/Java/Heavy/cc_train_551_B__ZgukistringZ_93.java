import java.util.Scanner;


public class CF307B {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] charsa = new int[256];
		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		
		char[] cha = a.toCharArray();
		char[] chb = b.toCharArray();
		char[] chc = c.toCharArray();
		int[] charsb = new int[256];
		int[] charsc = new int[256];
		for(int i=0; i<a.length(); ++i){
			++charsa[(int)cha[i]];
		}
		for(int i=0; i<b.length(); ++i){
			++charsb[(int)chb[i]];
		}
		for(int i=0; i<c.length(); ++i){
			++charsc[(int)chc[i]];
		}
		
		int a_char = (int)'a';
		int z_char = (int)'z';
		
		int count = Integer.MAX_VALUE;
		
		for(int i=a_char; i<=z_char; ++i){
			if(charsb[i] != 0){
				if(charsa[i]/charsb[i] < count)
					count = charsa[i]/charsb[i];
			}
		}
		int tmp; 
		
		int max = 0;
		int countmax = count, tmpmax = 0;
		for(int i=count; i>=0; --i){
			tmp = Integer.MAX_VALUE;
			
			for(int j=a_char; j<=z_char; ++j){
				if(charsc[j] != 0){
					if((charsa[j] - i* charsb[j])/charsc[j] < tmp)
						tmp = (charsa[j] - i* charsb[j])/charsc[j];
				}
			}
			
			if(max < i + tmp){
				countmax = i;
				tmpmax = tmp;
				max = i + tmp;
			}
		}
		
		
			for(int i=0; i<countmax; ++i)
				System.out.print(b);
			for(int i=0; i<tmpmax; ++i)
				System.out.print(c);
			for(int i=a_char; i<=z_char; ++i){
				char chari = (char)i;

				//System.out.println(chari + " " + (charsa[j]-count*charsb[j]-tmp*charsc[j]));
				for(int j=0; j<charsa[i]-countmax*charsb[i]-tmpmax*charsc[i];++j)
					System.out.print(chari);
				
			}
	
		
		
		
	}

}
