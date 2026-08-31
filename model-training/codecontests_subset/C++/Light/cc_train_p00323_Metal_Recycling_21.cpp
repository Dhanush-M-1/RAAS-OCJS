#include <bits/stdc++.h>

using namespace std;

int N;
int Count[2000017];

void solve() {
	for (int i = 0; i < 2000017; ++i) {
		if (Count[i] == 0) {
			continue;
		}
		cout << i << " 0" << endl;
	}
}

int main() {
	int a, b, c;
	
	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> a >> b;
		c = a + b;
		while (Count[c] != 0) {
			Count[c] = 0;
			++c;
		}
		Count[c] = 1;
	}
	solve();
	
	return 0;
}
