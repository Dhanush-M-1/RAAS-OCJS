#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f, MOD = 1e9 + 7;
const int N = 1e3 + 1000, n_ = 2e3 + 3000;
long long gcd(long long a, long long b) { return (a ? gcd(b % a, a) : b); }
long long power(long long a, long long n) {
  long long p = 1;
  while (n > 0) {
    if (n % 2) {
      p = p * a;
    }
    n >>= 1;
    a *= a;
  }
  return p;
}
long long power(long long a, long long n, long long mod) {
  long long p = 1;
  while (n > 0) {
    if (n % 2) {
      p = p * a;
      p %= mod;
    }
    n >>= 1;
    a *= a;
    a %= mod;
  }
  return p % mod;
}
int n, m, q, par[n_];
vector<pair<pair<int, int>, pair<int, int> > > e;
void rm() {
  for (int i = 0; i < n_; i++) {
    par[i] = i;
  }
}
int find(int u) { return par[u] = (par[u] == u ? u : find(par[u])); }
int merge(int u, int v) {
  int fu = find(u), fv = find(v);
  if (fv == fu) return 0;
  par[fv] = find(u + N);
  par[fu] = find(v + N);
  return 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> q;
  for (int i = 0; i < m; i++) {
    int u, v, w;
    pair<pair<int, int>, pair<int, int> > tmp;
    cin >> u >> v >> w;
    u--, v--;
    tmp.second.first = u, tmp.second.second = v, tmp.first.first = w,
    tmp.first.second = i;
    e.push_back(tmp);
  }
  sort((e).begin(), (e).end());
  while (q--) {
    int l, r, ans = -1;
    cin >> l >> r;
    l--;
    rm();
    for (int i = m - 1; i >= 0; i--) {
      if (e[i].first.second >= l && e[i].first.second < r &&
          !merge(e[i].second.first, e[i].second.second)) {
        ans = e[i].first.first;
        break;
      }
    }
    cout << ans << "\n";
  }
  return 0;
}
