#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;
#define int long long
#define vel vector<long long>
#define vvel vector<vel>
#define vvvel vector<vvel>
void mmin(int &a, int b) { a = min(a, b); }
void mmax(int &a, int b) { a = max(a, b); }
void sor(vel &v) { sort(v.begin(), v.end()); }
void m1(int &a) { a = a % 10000; }
int sign(int n) {
	if (n == 0)return n;
	return n / abs(n);
}
int zero() { return 0; }
int zi(vel a, int mo, vel rui) {
	int ke = a.size();
	int ans = 9 / mo;
	if (ke == 0)return 0;
	if (ke == 1)return a[0]/mo;
	vvvel ze(2,vvel(10, vel(mo, 0)));
	vvvel dp0 = ze;
	vvvel dp1 = ze;
	for (int i = 0; i < 10; i++) {
		dp0[0][i][i%mo]++;
		if (i <= a[0])dp1[0][i][i%mo]++;
	}
	dp0[1] = dp0[0];
	dp1[1] = dp1[0];
	int di;
	di = 1;
	for (int k1 = 1; k1 < ke; k1++) {
		int r1 = rui[k1];
		vvvel odp0 = dp0;
		vvvel odp1 = dp1;
		dp0 = ze; dp1 = ze;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < mo; j++) {
				for (int k = 0; k < 10; k++) {
					int xx = (r1*k) % mo;
					xx = (xx + j) % mo;
					int ty = sign(i-k)*di;
					if (ty != 0) {
						ty = (ty + 1) / 2;
						dp0[ty][k][xx] += odp0[ty][i][j];
						m1(dp0[ty][k][xx]);
						if (k < a[k1]) {
							dp1[ty][k][xx] += odp0[ty][i][j];
							m1(dp0[ty][k][xx]);
						}
						else if (k == a[k1]) {
							dp1[ty][k][xx] += odp1[ty][i][j];
							m1(dp1[ty][k][xx]);
						}
					}
				}
			}
		}
		if (k1 + 1 < ke) {
			for (int i = 1; i < 10; i++) {
				ans += dp0[0][i][0] + dp0[1][i][0];
				m1(ans);
			}
		}
		else {
			for (int i = 1; i < 10; i++) {
				ans += dp1[0][i][0] + dp1[1][i][0];
				m1(ans);
			}
		}
		di *= -1;
	}
	return ans;
}
signed main() {
	string ka;
	string kb;
	cin >> ka >> kb;
	int m; cin >> m;
	int n = ka.size();
	vel a; int fl = 1;
	for (int i = 0; i < n; i++) {
		if ((i != 0 or ka[i] != '1') and (i == 0 or ka[i] == '0')) fl = 0;
	}
	if (fl == 1) { n--; a = vel(n, 9); }
	else {
		a = vel(n);
		for (int i = 0; i < n; i++) a[i] = ka[i] - 48;
		reverse(a.begin(), a.end());
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) { a[i] = 9; }
			else { a[i]--; break; }
		}
	}
	int si = kb.size();
	vel rui(si, 1); int sum = a[0];
	for (int i = 1; i < si; i++) {
		rui[i] = (rui[i - 1] * 10) % m;
	}
	vel b(si);
	for (int i = 0; i < si; i++) { b[i] = kb[si - i - 1] - 48; }
	cout << (zi(b, m, rui) - zi(a, m, rui)+10000)%10000 << endl;
	return 0;
}

