#include <bits/stdc++.h>

using namespace std;

int main() {

	int n;
	cin >> n;
	map<string, int> m;
	string ss[] = {"AC", "WA", "TLE", "RE"};
	while (n--) {
		string s;
		cin >> s;
		
		m[s]++;
	}

	for (auto s: ss) {
		cout << s << " x " << m[s] << "\n";
	}

	return 0;
}