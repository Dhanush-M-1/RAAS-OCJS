//
#include<bits/stdc++.h>

#define mod 1000000007
#define sp ' '
#define intmax 2147483647
#define llmax 9223372036854775807
#define nyan "(=^･ω･^=)"
#define mkp make_pair
#define lP pair<ll, ll>
#define iP pair<int,int>

using namespace std;
typedef long long ll;

int X, K, A[100002], Q, t, a, p, q, l, r, L, R;

int main() {
	cin >> X >> K;
	for (int i = 1; i != K + 1; ++i)
		cin >> A[i];
	A[K + 1] = intmax;
	cin >> Q;
	r = X;
	R = X;
	while (Q--) {
		cin >> t >> a;
		for (; p != K + 1; ++p) {
			if (A[p + 1] >= t) {
				int res;
				if (p & 1) {
					if (a < l) {
						res = L + t - A[p];
					}
					else if (a <= r)
						res = a + q + t - A[p];
					else
						res = R + t - A[p];
					res = min(res, X);
				}
				else {
					if (a < l) {
						res = L - t + A[p];
					}
					else if (a <= r)
						res = a + q - t + A[p];
					else
						res = R - t + A[p];
					res = max(res, 0);
				}
				cout << res << endl;
				break;
			}
			if (p & 1) {
				L += A[p + 1] - A[p];
				q += A[p + 1] - A[p];
				R += A[p + 1] - A[p];
				L = min(L, X);
				R = min(R, X);
				r = min(r, X - q);

			}
			else {
				L -= A[p + 1] - A[p];
				q -= A[p + 1] - A[p];
				R -= A[p + 1] - A[p];
				L = max(L, 0);
				R = max(R, 0);
				l = max(l, -q);
			}
		}
	}
	return 0;
}