/*
 * cf.java
 * 
 * Copyright 2018 Phani Datta <phani@phani>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.util.*;

public class cf {
	
	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int temp=0;
		int [] a = new int[n+1];
		List al = new ArrayList<Integer>();
		for(int i=1;i<n+1;i++)
		{
			a[i] = s.nextInt();
			if(k%a[i]==0)
			{temp = k/a[i];
				al.add(temp);}
		}
		
		Collections.sort(al);
		System.out.println(al.get(0));
		
	}
}

