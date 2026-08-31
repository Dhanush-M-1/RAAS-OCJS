#include "bits/stdc++.h"
using namespace std;
#define rep(i,n) for(int i=0;i<n;i++)
#define REP(i,x,n) for(int i=x;i<n;i++)
#define ALL(v) (v).begin(),(v).end()
#define MP(a,b) make_pair(a,b)
typedef long long LL;
typedef pair<int, int> PI;
typedef vector<int> VI;
const LL MOD = 1000000007LL;
int r[100000];
int main() {
	int X;
	int K;
	cin >> X;
	cin >> K;
	rep(i, K) cin >> r[i];
	int Q;
	cin >> Q;
	int L = 0, R = X, C = 0;
	int j = 0;
	int prev = 0;
	rep(i, Q) {
		int t, a;
		cin >> t >> a;
		while (j < K&&r[j] <= t) {
			int T = r[j] - prev;
			if (j % 2 == 0) {
				if (T > C) L = min(L + (T - C), R);
				C = max(C - T, 0);
			}
			else {
				if (T > X - ((R - L) + C)) R = max(R - (T - (X - ((R - L) + C))), L);
				C = min(C + T, X);
			}
			prev = r[j];
			j++;
		}
		int T = t - prev;
		if (j % 2 == 0) {
			if (T > C) L = min(L + (T - C), R);
			C = max(C - T, 0);
		}
		else {
			if (T > X - ((R - L) + C)) R = max(R - (T - (X - ((R - L) + C))), L);
			C = min(C + T, X);
		}
		prev = t;
		if (a <= L) {
			cout << C << endl;
		}
		else if (R <= a) {
			cout << (R - L) + C << endl;
		}
		else {
			cout << (a - L) + C << endl;
		}
	}
}