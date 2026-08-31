#include<bits/stdc++.h>
using namespace std;
int main()
{
	int n,x=1000;
	cin>>n;
	string ip;
	map<string,int> fr;
	for(int i=1;i<=n;i++)
	{
		cin>>ip;
		fr[ip]++;
	}
	cout<<"AC x "<<fr["AC"]<<endl;
	cout<<"WA x "<<fr["WA"]<<endl;
	cout<<"TLE x "<<fr["TLE"]<<endl;
	cout<<"RE x "<<fr["RE"]<<endl;
}