#include <bits/stdc++.h>
using namespace std;

map<string,int> m;

int main()
{
	int n;
	cin>>n;
	
	string s;
	for(int i=1;i<=n;i++)
	{
		cin>>s;
		m[s]++;
	}
	
	cout<<"AC x "<<m["AC"]<<endl;
	cout<<"WA x "<<m["WA"]<<endl;
	cout<<"TLE x "<<m["TLE"]<<endl;
	cout<<"RE x "<<m["RE"]<<endl;
	return 0;
}