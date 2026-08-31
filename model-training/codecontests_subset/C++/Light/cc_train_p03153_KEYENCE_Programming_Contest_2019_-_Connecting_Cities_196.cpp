#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define rep(i, n) for(int i = 0; i < (n); i++)
#define rep1(i, n) for(int i = 1; i <= (n); i++)
#define co(x) cout << (x) << "\n"
#define cosp(x) cout << (x) << " "
#define ce(x) cerr << (x) << "\n"
#define cesp(x) cerr << (x) << " "
#define pb push_back
#define mp make_pair
#define Would
#define you
#define please

const int cm = 1 << 17;
char cn[cm], *ci = cn + cm, ct;
inline char getcha() {
	if (ci - cn == cm) { fread_unlocked(cn, 1, cm, stdin); ci = cn; }
	return *ci++;
}
inline int getint() {
	int A = 0;
	if (ci - cn + 16 > cm) while ((ct = getcha()) >= '0') A = A * 10 + ct - '0';
	else while ((ct = *ci++) >= '0') A = A * 10 + ct - '0';
	return A;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);


	int N = getint();
	ll D = getint();
	ll kotae = (N - 1) * D;
	int A[200001];
	ll C[200001];
	C[0] = 1e18;
	rep1(i, N) {
		A[i] = getint();
		kotae += A[i];
		C[i] = min(C[i - 1] + D, (ll)A[i]);
	}
	ll mae = 1e18;
	for (int i = N - 1; i > 1; i--) {
		mae = min(mae + D, (ll)A[i + 1]);
		ll kari = min(mae, C[i - 1]) + D;
		kotae += min((ll)A[i], kari);
	}
	co(kotae);

	Would you please return 0;
}