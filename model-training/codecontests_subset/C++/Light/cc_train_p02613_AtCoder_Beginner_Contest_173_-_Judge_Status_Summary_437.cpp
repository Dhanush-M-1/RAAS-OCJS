#include <bits/stdc++.h>
using namespace std;
int main()
{
	map<string, int> m;
	string ar[4]={"AC","WA","TLE","RE"};
	int n;
	cin>>n;
	while (n--)
	{
		string s;
		cin>>s;
		m[s]++;
	}
	for (int i=0;i<4;i++)
	{
		cout<<ar[i]<<" x "<<m[ar[i]]<<"\n";
	}
}