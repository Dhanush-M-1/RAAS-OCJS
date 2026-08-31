#include <bits/stdc++.h>
using namespace std;
#define ll long long
int main() {
	map<string,ll> m;
	ll n;
	cin>>n;
	for(ll i=0;i<n;i++){
		string s;
		cin>>s;
		m[s]++;
	}
	cout<<"AC x "<<m["AC"]<<"\n";
	cout<<"WA x "<<m["WA"]<<"\n";
	cout<<"TLE x "<<m["TLE"]<<"\n";
	cout<<"RE x "<<m["RE"]<<"\n";
	return 0;
}