
#include <cstdio>
#include <cstdlib>
#include <cmath>
#include <climits>
#include <cfloat>
#include <cstring>
#include <map>
#include <utility>
#include <set>
#include <iostream>
#include <memory>
#include <string>
#include <vector>
#include <list>
#include <algorithm>
#include <functional>
#include <sstream>
#include <complex>
#include <stack>
#include <queue>
#include <unordered_set>
#include <unordered_map>
#include <array>
#include <cassert>
#include <bitset>
using namespace std;
using LL = long long;

int N;
vector<int>A;

int main(void)
{
	cin >> N;
	for (int i = 0; i < N; ++i) {
		int a;
		cin >> a;
		A.push_back(a);
	}
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < i; ++j) {
			int dif = abs(A[i] - A[j]);
			if (dif % (N - 1) == 0) {
				cout << A[i] << " " << A[j] << endl;
				return 0;
			}
		}
	}
	return 0;
}

