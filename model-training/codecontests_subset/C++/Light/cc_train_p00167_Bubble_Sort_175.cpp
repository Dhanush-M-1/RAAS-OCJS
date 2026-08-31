#define _USE_MATH_DEFINES
#include<iostream>
#include<cstdio>
#include<vector>
#include<algorithm>
#include<string>
#include<cmath>
#include<list>
#include<stack>
#include<queue>
#include<cctype>
#include<iomanip>
#include<functional>
#include<numeric>
#include<map>
#include<set>
#include<complex>
#define EPS 1e-10
using namespace std;
typedef long long llong;
int main() {
	int n;
	while (cin >> n, n) {
		vector<int>v(n);
		for (int i = 0; i < n; i++)cin >> v[i];
		int cnt = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; i < j; j--) {
				if (v[j - 1] > v[j]) {
					swap(v[j - 1], v[j]);
					cnt++;
				}
			}
		}
		cout << cnt << endl;
	}
	return 0;
}