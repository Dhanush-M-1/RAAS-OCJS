
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ZgukistringZ {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		int[] freqA = new int[26];
		for(int i=0;i<a.length();i++)
			freqA[a.charAt(i)-'a']++;
		int[] freqB = new int[26];
		for(int i=0;i<b.length();i++)
			freqB[b.charAt(i)-'a']++;
		int[] freqC = new int[26];
		for(int i=0;i<c.length();i++)
			freqC[c.charAt(i)-'a']++;


		//		System.out.println(Arrays.toString(freqA));
		//		System.out.println(Arrays.toString(freqB));
		//		System.out.println(Arrays.toString(freqC));

		int ansB = 0;
		int ansC = 0;

		for(int i=0;i<=a.length();i++)		//take i from b
		{
			boolean ok = true;
			for(int j=0;j<26;j++)
				if(1l * freqB[j] * i > freqA[j])
					ok = false;
			if(ok)
			{
				int cc = (int)1e9;
				for(int j=0;j<26;j++)
					if(freqC[j] != 0)
						cc =(int) Math.min(cc, (freqA[j] - 1l * i * freqB[j]) / freqC[j]);

				if(cc + i > ansB + ansC)
				{
					ansB = i;
					ansC = cc;
				}
			}
		}

		//		
		//		for(int i=0;i<26;i++)
		//		{
		//			
		//			if(freqB[i] != 0)
		//			{
		//				int takeB = freqA[i]/freqB[i];
		//				int	takeC = (int)1e7;
		//				boolean ok = true;
		//				for(int j=0;j<26;j++)
		//				{
		//					
		//					long cc = freqA[j] - 1l*takeB*freqB[j];
		//					if(cc < 0)
		//					{
		//						ok= false;
		//						break;
		//					}
		//					else
		//						if(freqC[j] != 0)
		//							takeC =(int) Math.min(takeC, cc/freqC[j]);
		//				}
		//				if(ok)
		//				{
		//					if(takeB + takeC > ansB + ansC)
		//					{
		//						ansB = takeB;
		//						ansC = takeC;
		//					}
		//				}
		//			}
		//			
		//			if(freqC[i] != 0)
		//			{
		//				int takeC = freqA[i]/freqC[i];
		//				int	takeB = (int)1e7;
		//				boolean ok = true;
		//				for(int j=0;j<26;j++)
		//				{
		//					
		//					long cc = freqA[j] - 1l*takeC*freqC[j];
		//					if(cc < 0)
		//					{
		//						ok= false;
		//						break;
		//					}
		//					else
		//						if(freqB[j] != 0)
		//							takeB =(int) Math.min(takeB, cc/freqB[j]);
		//				}
		//				if(ok)
		//				{
		//					if(takeB + takeC >= ansB + ansC)
		//					{
		//						ansB = takeB;
		//						ansC = takeC;
		//					}
		//				}
		//			}
		//			
		//		}

		//		System.out.println(ansB + " " + ansC);

		for(int i=0;i<26;i++)
		{
			freqA[i] -= (1l*freqB[i]*ansB);
			freqA[i] -= (1l*freqC[i]*ansC);
		}

		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<ansB;i++)
			sb.append(b);
		for(int i=0;i<ansC;i++)
			sb.append(c);
		for(int i=0;i<26;i++)
			for(int j=0;j<freqA[i] ;j++)
				sb.append((char)('a'+i));
		pw.println(sb);
		pw.flush();
	}

}
