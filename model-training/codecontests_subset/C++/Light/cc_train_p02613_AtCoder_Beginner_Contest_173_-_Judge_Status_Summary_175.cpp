#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
	ll cnt[4]={};
	ll n;
	cin>>n;
	string a[4]={"AC","WA","TLE","RE"};
	for(int i=0;i<n;i++){
		string s;
		cin>>s;
		for(int i=0;i<4;i++)if(s==a[i])cnt[i]++;
	}
	for(int i=0;i<4;i++){
		cout<<a[i]<<" x "<<cnt[i]<<endl;
	}
	return 0;
}