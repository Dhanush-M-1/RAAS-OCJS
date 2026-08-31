import java.io.*;
import java.util.*;
public class cp1 {
	public static void main(String args[]) {
		
			int n=II();
			int k=II();
			int t[]=new int[n];
			int a[]=new int[n];
			int b[]=new int[n];

			ArrayList<Integer> arr=new ArrayList<>();
			ArrayList<Integer> brr=new ArrayList<>();
			ArrayList<Integer> crr=new ArrayList<>();

			for(int i=0;i<n;i++){
				t[i]=II();
				a[i]=II();
				b[i]=II();

				if(a[i]==1 && b[i]==1)
					arr.add(t[i]);
				else if(a[i]==1 && b[i]==0)
					brr.add(t[i]);
				else if(a[i]==0 && b[i]==1)
					crr.add(t[i]);
			}
			Collections.sort(brr);
			Collections.sort(crr);
			int len1=brr.size();
			int len2 = crr.size();
			for(int i=0;i<len1 && i<len2; i++){
				arr.add(brr.get(i)+crr.get(i));
			}

			int len=arr.size();
			if(len<k)
				System.out.println(-1);
			else{
				Collections.sort(arr);
				int ans=0;
				for(int i=0;i<k;i++){
					ans=ans+arr.get(i);
				}
				System.out.println(ans);
			}
		
	}
	
	////////////////////////////////////
	static scan in=new scan(System.in);
	static int II() {
		return in.nextInt();
	}
	static long IL() {
		return in.nextLong();
	}
	static int[] IIA(int n) {
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=II();
		}
		return a;
	}
	static String IS() {
		return in.next();
	}
	static char IC(){
		return in.next().charAt(0);
	}
	static String[] ISA(int n) {
		String a[]=new String[n];
		for(int i=0;i<n;i++) {
			a[i]=IS();
		}
		return a;
	}
	static char[] ICA(int n) {
		char a[]=new char[n];
		for(int i=0;i<n;i++) {
			a[i]=IC();
		}
		return a;
	}
}
class scan
{
    public static BufferedReader reader;
    public static StringTokenizer token;

    scan(InputStream str)
    {
        reader=new BufferedReader(new InputStreamReader(str));
        token=null;
    }

    static int nextInt()
    {
        while(token==null||!token.hasMoreTokens())
        {
            try { token=new StringTokenizer(reader.readLine());   }
            catch(IOException e){  throw new RuntimeException(e); }
        }
        return Integer.parseInt(token.nextToken());
    }

    static long nextLong()
    {
        while(token==null||!token.hasMoreTokens())
        {
            try { token=new StringTokenizer(reader.readLine());   }
            catch(IOException e){  throw new RuntimeException(e); }
        }
        return Long.parseLong(token.nextToken());
    }

    static String next()
    {
        while(token==null||!token.hasMoreTokens())
        {
            try { token=new StringTokenizer(reader.readLine());   }
            catch(IOException e){  throw new RuntimeException(e); }
        }
        return token.nextToken();
    }

}



// data = {['name':'Protien', 'id':'1234', 'brand':'muscleblaze', 'about':'fopr building muscle'....],[],[]}