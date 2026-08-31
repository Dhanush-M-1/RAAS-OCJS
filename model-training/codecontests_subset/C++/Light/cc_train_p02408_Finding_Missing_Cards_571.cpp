#include "bits/stdc++.h"
using namespace std;

int main() {
	int N, X;
	char C, D[4] = { 'S', 'H', 'C', 'D' };
	bool A[52] = {};
	map<char, int> mp;
	mp['S'] = 0, mp['H'] = 1, mp['C'] = 2, mp['D'] = 3;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> C >> X;
		A[mp[C] * 13 + X - 1] = true;
	}
	for (int i = 0; i < 52; i++) {
		if (!A[i]) {
			cout << D[i / 13] << " " << i % 13 + 1 << endl;
		}
	}
}
