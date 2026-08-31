#include<bits/stdc++.h>
using namespace std;
int main(){
	map<string,int>mp;
	mp["AC"]=0;mp["WA"]=1;mp["TLE"]=2;mp["RE"]=3;
	int cnt[4]={0,0,0,0};
	int n;cin>>n;for(int i=0;i<n;i++){
		string s;cin>>s;cnt[mp[s]]++;
	}
	printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d",cnt[0],cnt[1],cnt[2],cnt[3]);
}