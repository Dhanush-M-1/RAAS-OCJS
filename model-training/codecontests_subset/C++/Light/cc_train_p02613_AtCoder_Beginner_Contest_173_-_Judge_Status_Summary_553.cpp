#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int main() {
	int n;
	cin >> n;
	map<string, int> cnt;
	for(int i=0;i<n;i++) {
		string s;
		cin >> s;
		cnt[s]++;
	}
	for(string s: {"AC", "WA", "TLE","RE"}) {
		cout << s << " x " << cnt[s] << endl;
	}
}