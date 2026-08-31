#include "bits/stdc++.h"
#include<unordered_map>
#include<unordered_set>
#pragma warning(disable:4996)
using namespace std;
using ld = long double;
const ld eps = 1e-9;

//// < "d:\d_download\visual studio 2015\projects\programing_contest_c++\debug\a.txt" > "d:\d_download\visual studio 2015\projects\programing_contest_c++\debug\b.txt"


int main() {
	int N; cin >> N;
	vector<int>v(3e5);
	for (int i = 0; i < N; ++i) {
		int a, b; cin >> a >> b;
		v[a + b]++;
	}
	for (int i = 0; i < 2e5 + 10000; ++i) {
		v[i + 1] += v[i] / 2;
		v[i] %= 2;
	}
	for (int i = 0; i < 2e5 + 10000; ++i) {
		if (v[i]) {
			cout << i << " " << 0 << endl;
		}
	}
	return 0;
}