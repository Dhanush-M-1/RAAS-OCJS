#include <cstdio>
#include <cmath>
#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() 
{
	int n;
	cin >> n;
	for(int i=0;i<n;i++)
	{
		int x,count(0);
		cin >> x;
		
		while(x>9)
		{
			int a,b,y(1),max(0);
			for(int i=1;i<7;i++)
			{
				a = x/y;
				b = x%y;
				if(a*b > max){ max=a*b; }
				y*=10;
			}
			x=max;
			count++;
		}
		cout << count << endl;
	}
	return 0 ;
}