#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main()	
{
	string s;
	map<string,int> mp;
	int n;
	cin>>n;
	while(n--){
		cin>>s;
		mp[s]++;
	}
	for(string S:{"AC","WA","TLE","RE"}){
		cout<<S<<" x "<<mp[S]<<'\n';
	}
}