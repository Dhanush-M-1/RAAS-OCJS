#include <bits/stdc++.h>
 
#define mp std::make_pair
#define pb push_back
#define eb emplace_back
#define fi first
#define se second
#define gc getchar
#define pc putchar
 
typedef unsigned char u8;
typedef unsigned short u16;
typedef unsigned int u32;
typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;
typedef std::pair <int, int> pii;
typedef std::pair <ll, ll> pll;
 
const int mod = 1000000007;
const int max_N = 107;
 
int n, B[max_N], C[max_N], dp[max_N][max_N * max_N];
 
int read_int() {
	char c = gc(); int ans = 0; bool neg = false;
	while (!isdigit(c)) neg |= (c == '-'), c = gc();
	while (isdigit(c)) ans = 10 * ans + c - '0', c = gc();
	return neg ? -ans : ans;
}
 
void write_int(int x) {
	if (x < 0) pc('-'), x = -x;
	if (x > 9) write_int(x / 10);
	pc(x % 10 + '0');
}
 
int min(int x, int y) {return x < y ? x : y;}
int max(int x, int y) {return x > y ? x : y;}
void _min(int &x, int y) {if (x > y) x = y;}
void _max(int &x, int y) {if (x < y) x = y;}
 
int plus(int x, int y) {return (x += y) >= mod ? x - mod : x;}
int minus(int x, int y) {return (x -= y) < 0 ? x + mod : x;}
int mul(int x, int y) {return (ll)x * y % mod;}
int fma(int x, int y, int z) {return (x + (ll)y * z) % mod;}
int fms(int x, int y, int z) {return (x + (ll)(mod - y) * z) % mod;}
int neg(int x) {return x == 0 ? 0 : mod - x;}
void _plus(int &x, int y) {if ((x += y) >= mod) x -= mod;}
void _minus(int &x, int y) {if ((x -= y) < 0) x += mod;}
void _mul(int &x, int y) {x = (ll)x * y % mod;}
void _fma(int &x, int y, int z) {x = (x + (ll)y * z) % mod;}
void _fms(int &x, int y, int z) {x = (x + (ll)(mod - y) * z) % mod;}
void _neg(int &x) {if (x) x = mod - x;}
 
int query(int x) {
	dp[0][0] = 1;
	for (int i = 1, sum = 0; i <= n; i++) {
		std::fill(dp[i], dp[i] + sum + C[i] + 1, 0);
		for (int j = 0; j <= sum; j++)
			for (int k = 0; k <= C[i]; k++)
				if (j + k - B[i] >= x * i) _plus(dp[i][j + k], dp[i - 1][j]);
		sum += C[i];
	}
	return std::accumulate(dp[n], dp[n] + C[0] + 1, 0ll) % mod;
}
 
int main() {
	n = read_int();
	for (int i = 1; i <= n; i++) C[i] = read_int();
	C[0] = std::accumulate(C + 1, C + n + 1, 0);
	for (int i = 2; i <= n; i++) B[i] = read_int();
	std::partial_sum(B + 2, B + n + 1, B + 2);
	std::partial_sum(B + 2, B + n + 1, B + 2);
	for (int i = read_int(); i; i--)
		write_int(query(read_int())), pc('\n');
	return 0;
}