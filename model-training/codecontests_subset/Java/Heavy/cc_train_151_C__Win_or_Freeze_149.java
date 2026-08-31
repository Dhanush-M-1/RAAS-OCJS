
import java.util.*;
import java.lang.*;
import java.io.*;

public class feb20 {

//	            ***                          ++                      
//             +=-==+                      +++=-                     
//            +-:---==+                   *+=----=                   
//           +-:------==+               ++=------==                  
//           =-----------=++=========================                
//          +--:::::---:-----============-=======+++====             
//          +---:..:----::-===============-======+++++++++           
//          =---:...---:-===================---===++++++++++         
//          +----:...:-=======================--==+++++++++++        
//          +-:------====================++===---==++++===+++++      
//         +=-----======================+++++==---==+==-::=++**+     
//        +=-----================---=======++=========::.:-+*****    
//       +==::-====================--:  --:-====++=+===:..-=+*****   
//       +=---=====================-...  :=..:-=+++++++++===++*****  
//       +=---=====+=++++++++++++++++=-:::::-====+++++++++++++*****+ 
//      +=======++++++++++++=+++++++============++++++=======+****** 
//      +=====+++++++++++++++++++++++++==++++==++++++=:...  . .+**** 
//     ++====++++++++++++++++++++++++++++++++++++++++-.     ..-+**** 
//     +======++++++++++++++++++++++++++++++++===+====:.    ..:=++++ 
//     +===--=====+++++++++++++++++++++++++++=========-::....::-=++* 
//     ====--==========+++++++==+++===++++===========--:::....:=++*  
//     ====---===++++=====++++++==+++=======-::--===-:.  ....:-+++   
//     ==--=--====++++++++==+++++++++++======--::::...::::::-=+++    
//     ===----===++++++++++++++++++++============--=-==----==+++     
//     =--------====++++++++++++++++=====================+++++++     
//     =---------=======++++++++====+++=================++++++++     
//     -----------========+++++++++++++++=================+++++++    
//     =----------==========++++++++++=====================++++++++  
//     =====------==============+++++++===================+++==+++++ 
//     =======------==========================================++++++

	// created by : Nitesh Gupta

	public static void main(String[] args) throws Exception {
		first();
//			sec();
	}

	private static void first() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] scn = (br.readLine()).trim().split(" ");
		long n = Long.parseLong(scn[0]);
		ArrayList<Long> list = new ArrayList<>();

		for (long i = 2; i <= Math.sqrt(n); i++) {
			while (n % i == 0) {
				list.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			list.add(n);
		}
		if (list.size() == 2) {
			System.out.println("2");
		} else {
			sb.append("1\n");
			if (list.size() <= 1) {
				sb.append("0");
			} else {
				long ans = list.get(0) * list.get(1);
				sb.append(ans);
			}
		}
		System.out.println(sb);
		return;

	}

	private static void sec() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String[] scn = (br.readLine()).trim().split(" ");
			int n = Integer.parseInt(scn[0]);
			long[] arr = new long[n];
			scn = (br.readLine()).trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(scn[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		return;

	}

	public static void sort(long[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) Math.random() * n;
			long temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}
		Arrays.sort(arr);
	}

	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) Math.random() * n;
			int temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}
		Arrays.sort(arr);
	}

	public static void print(long[][] dp) {
		for (long[] a : dp) {
			for (long ele : a) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	public static void print(int[][] dp) {
		for (int[] a : dp) {
			for (int ele : a) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	public static void print(int[] dp) {
		for (int ele : dp) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}

	public static void print(long[] dp) {
		for (long ele : dp) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}

}