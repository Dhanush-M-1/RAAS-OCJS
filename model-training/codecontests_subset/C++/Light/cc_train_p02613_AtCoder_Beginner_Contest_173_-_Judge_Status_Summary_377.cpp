#include<bits/stdc++.h>
using namespace std;
int main() {
	map<string,int> mp;
	int n; cin >> n;
	for (int i = 0;i < n; i++) {
		string s; cin >> s;mp[s]++;
	}
	cout << "AC x " << mp["AC"] <<'\n';
	cout << "WA x " << mp["WA"] <<'\n';
	cout << "TLE x " << mp["TLE"] <<'\n';
	cout << "RE x " << mp["RE"] <<'\n';

}