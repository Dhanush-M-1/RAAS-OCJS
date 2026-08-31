#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 105, MOD = 1e9 + 7;
int n, f[N * N], g[N * N], b[N], sb[N], c[N];
map<int, int> ans;
int Solve(int x)
{
	fill(g, g + N * N, 1);
	for(int i = 1, sumc = c[1], lim; i <= n; i++, sumc += c[i]) 
	{
		lim = i * x + sb[i]; memset(f, 0, sizeof(f));
		for(int j = max(0, lim); j < N * N; j++) f[j] = (g[j] - (j - c[i] - 1 >= 0 ? g[j - c[i] - 1] : 0) + MOD) % MOD;
		memset(g, 0, sizeof(g)); g[0] = f[0];
		for(int j = 1; j < N * N; j++) g[j] = (g[j - 1] + f[j]) % MOD;
	}
	return g[N * N - 1];
}
int main()
{
	ios::sync_with_stdio(false);
	cin >> n;
	int prod = 1;
	for(int i = 1; i <= n; i++) { cin >> c[i]; prod = (ll)prod * (c[i] + 1) % MOD; }
	for(int i = 1; i < n; i++) cin >> b[i];
	for(int i = 1; i <= n; i++) for(int j = 1; j < i; j++) sb[i] += (i - j) * b[j];
	int lb = 0, rb = INT_MAX, m = *max_element(c + 1, c + n + 1);
	for(int i = 1; i <= n; i++) lb = min(lb, -((sb[i] - 1) / i + 1)), rb = min(rb, (n * m - sb[i] - 1) / i + 1);
	for(int i = lb; i <= rb; i++) ans[i] = Solve(i);
	int q; cin >> q;
	while(q--)
	{
		int x; cin >> x;
		if(x >= lb && x <= rb) cout << ans[x] << endl;
		else if(x > rb) cout << 0 << endl;
		else if(x < lb) cout << prod << endl;
	}
	return 0;
}