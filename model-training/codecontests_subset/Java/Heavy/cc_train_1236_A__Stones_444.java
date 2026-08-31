

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] cmd=br.readLine().split(" ");
		int cases=Integer.valueOf(cmd[0]);
		while(cases!=0)
		{
			cases--;
			cmd=br.readLine().split(" ");
			int a=Integer.valueOf(cmd[0]);
			int b=Integer.valueOf(cmd[1]);
			int c=Integer.valueOf(cmd[2]);
			int s=a+b+c;
			while(b>=1 && c>=2)
			{
				b--;
				c=c-2;
			}
			while(a>=1 && b>=2)
			{
				a--;
				b=b-2;
			}
			int d=a+b+c;
			System.out.println(s-d);
		}
	}
}
