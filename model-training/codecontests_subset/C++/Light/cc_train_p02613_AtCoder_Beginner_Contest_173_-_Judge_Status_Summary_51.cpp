#include <bits/stdc++.h>
using namespace std;
int main() {
	int n; cin >> n;
	map<string, int> mp;
	for (int i = 0; i < n; i++) {
		string s; cin >> s;
		++mp[s];
	}
	for (auto s : {"AC", "WA", "TLE", "RE"})
		cout << s << " x " << mp[s] << "\n";
}