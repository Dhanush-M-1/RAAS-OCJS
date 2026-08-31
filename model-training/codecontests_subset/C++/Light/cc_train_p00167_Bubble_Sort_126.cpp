#include <bits/stdc++.h>
using namespace std;

#define FOR(i,a,b) for(int i=(a);i<(b);i++)
#define REP(i,n) FOR(i,0,n)

int main() {
	int n;
	while (cin >> n, n) {
		vector<int> a(n);
		REP(i, n) scanf("%d", &a[i]);
		
		int ans = 0;
		REP(i, n) FOR(j, 1, n - i) {
			if (a[j] < a[j - 1]) {
				swap(a[j], a[j - 1]);
				ans++;
			}
		}
		cout << ans << endl;
	}
	return 0;
}