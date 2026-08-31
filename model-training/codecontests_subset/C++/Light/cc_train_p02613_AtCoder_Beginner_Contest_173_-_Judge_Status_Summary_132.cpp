#include <bits/stdc++.h>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	int N; cin >> N;

	unordered_map<string, int> freq;
	for (string line; getline(cin, line);) {
		freq[line]++;
	}

	for (string status: {"AC", "WA", "TLE", "RE"})
		cout << status << " x " << freq[status] << '\n';
}
