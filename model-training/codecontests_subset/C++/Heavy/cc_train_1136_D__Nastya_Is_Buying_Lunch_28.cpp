#include <bits/stdc++.h>
using namespace std;
void solve() {}
const long long MAXN = (long long)3e5 + 69;
vector<long long> G[MAXN];
long long p[MAXN];
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long n, m;
  cin >> n >> m;
  for (long long i = 1; i <= n; i++) {
    cin >> p[i];
  }
  for (long long i = 1; i <= m; i++) {
    long long u, v;
    cin >> u >> v;
    G[u].emplace_back(v);
  }
  long long ans = 0;
  set<long long> S = {p[n]};
  for (long long i = n - 1; i >= 1; i--) {
    long long s = 0;
    for (long long x : G[p[i]]) {
      if (S.count(x)) s++;
    }
    if (s == (long long)S.size()) {
      ans++;
    } else {
      S.emplace(p[i]);
    }
  }
  cout << ans << '\n';
}
