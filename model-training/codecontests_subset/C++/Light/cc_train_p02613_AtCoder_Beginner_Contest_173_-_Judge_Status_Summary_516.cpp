#include<bits/stdc++.h>
using namespace std;
map<string,int>mp;
int n;
string s;
int main()
{
	cin>>n;
	for(int i=0;i<n;++i)
	{
		cin>>s;
		mp[s]++;
	}
	printf("AC x %d\n",mp["AC"]);
	printf("WA x %d\n",mp["WA"]);
	printf("TLE x %d\n",mp["TLE"]);
	printf("RE x %d\n",mp["RE"]);
	return 0;
}