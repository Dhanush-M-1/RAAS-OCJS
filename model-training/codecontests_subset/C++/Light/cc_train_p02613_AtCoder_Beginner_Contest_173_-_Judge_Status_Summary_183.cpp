#include <bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin >> n;
	string s;
	map<string, int> mp;
	for (int i = 0; i < n; i++) {
		cin >> s;
		mp[s]++;
	}
	string str[4] = {"AC", "WA", "TLE", "RE"};
	for (int i = 0; i < 4; i++) {
		cout << str[i] << " x " << mp[str[i]] << endl;
	}
}