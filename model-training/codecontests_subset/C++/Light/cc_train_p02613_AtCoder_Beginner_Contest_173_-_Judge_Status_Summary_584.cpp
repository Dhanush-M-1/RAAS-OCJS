#include<bits/stdc++.h>
using namespace std;
int main()
{
	int n;
	cin>>n;
	map<string , int> m;
	for(int i=1;i<=n;i++)
	{
		string temp;
		cin>>temp;
		m[temp]++;
	}
	cout<<"AC x "<<m["AC"]<<"\n"<<"WA x "<<m["WA"]<<"\n"<<"TLE x "<<m["TLE"]<<"\n"<<"RE x "<<m["RE"];
}