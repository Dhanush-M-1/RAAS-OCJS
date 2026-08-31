#include<bits/stdc++.h>
using namespace std;
map<string,int>mp;
int main()
{
	int n;
	cin>>n;
	for(int i=1;i<=n;i++)
	{
		string ss;
		cin>>ss;
		mp[ss]++;
	}
	cout<<"AC x "<<mp["AC"]<<endl;
	cout<<"WA x "<<mp["WA"]<<endl;
	cout<<"TLE x "<<mp["TLE"]<<endl;
	cout<<"RE x "<<mp["RE"]<<endl;
}