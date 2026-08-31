#include <bits/stdc++.h>
using namespace std;
string s;
int a[6];
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		cin>>s;
		if(s=="AC") ++a[0];
		else if(s=="WA") ++a[1];
		else if(s=="TLE") ++a[2];
		else if(s=="RE") ++a[3];
	}
	cout<<"AC x "<<a[0]<<"\nWA x "<<a[1]<<"\nTLE x "<<a[2]<<"\nRE x "<<a[3]<<"\n";
	return 0;
} 