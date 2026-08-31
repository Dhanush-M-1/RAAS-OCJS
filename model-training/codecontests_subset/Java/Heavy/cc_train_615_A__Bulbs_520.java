import java.util.*;
import java.lang.*;
import java.awt.*;
import java.math.*;

public class Bulbs{
	
	public static boolean on(boolean[] list){
		for(int i=0;i<list.length;i++){
			if(list[i]==false)
				return false;
		}
		return true;
	}

	public static void main(String[] args){
		//long t= System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		int m= in.nextInt();
		boolean[] on= new boolean[m];
		
		for(int i=0;i<n;i++){
			int k=in.nextInt();
			for(int j=0;j<k;j++){
				on[in.nextInt()-1]=true;
			}
		}

		if(on(on))
			System.out.println("YES");
		else
			System.out.println("NO");



	
		//wetShark(list);


		//System.out.println(Arrays.toString(list));
	}
}