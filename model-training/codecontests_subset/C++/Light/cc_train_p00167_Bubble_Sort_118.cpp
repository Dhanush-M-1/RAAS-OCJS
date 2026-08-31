#include "bits/stdc++.h"
#include<unordered_map>
#include<unordered_set>
#pragma warning(disable:4996)
using namespace std;
using ld = long double;
const ld eps = 1e-9;

//// < "d:\d_download\visual studio 2015\projects\programing_contest_c++\debug\a.txt" > "d:\d_download\visual studio 2015\projects\programing_contest_c++\debug\b.txt"


int main() {
	while (1) {
		int N;
		cin >> N;
		if (!N)break;
		vector<int>as(N);
		for (int i = 0; i < N; ++i) {
			cin >> as[i];
		}
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			sum += count_if(as.begin() + i + 1, as.end(), [=](const int n) {return n < as[i]; });
		}
		cout << sum << endl;
	}
	return 0;
}