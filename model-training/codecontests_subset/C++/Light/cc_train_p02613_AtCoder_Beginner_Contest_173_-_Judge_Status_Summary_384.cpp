#include<bits/stdc++.h>
using namespace std;
int main()
{
	int n;
	cin>>n;
	map<string, int>hash;
	for(int i=0;i<n;i++)
	{
		string s;
		cin>>s;
		hash[s] += 1;
	}
	cout<<"AC"<<" x "<<hash["AC"]<<"\n";
	cout<<"WA"<<" x "<<hash["WA"]<<"\n";
	cout<<"TLE"<<" x "<<hash["TLE"]<<"\n";
	cout<<"RE"<<" x "<<hash["RE"]<<"\n";
}