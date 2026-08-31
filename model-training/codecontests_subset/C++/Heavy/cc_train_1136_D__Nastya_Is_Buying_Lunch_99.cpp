#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18;
const long long mod = 1e9 + 7, M = 2e6 + 7, INF = INT_MAX / 10;
long long powe(long long x, long long y) {
  x = x % mod, y = y % (mod - 1);
  long long ans = 1;
  while (y > 0) {
    if (y & 1) {
      ans = (1ll * x * ans) % mod;
    }
    y >>= 1;
    x = (1ll * x * x) % mod;
  }
  return ans;
}
void solve() {
  long long n, m, i, j, c = 0;
  cin >> n >> m;
  long long a[n];
  for (i = 0; i < n; i++) cin >> a[i];
  vector<long long> adj[n + 1];
  vector<bool> vis(n + 1, false);
  for (i = 0; i < m; i++) {
    long long x, b;
    cin >> x >> b;
    adj[x].push_back(b);
    if (b == a[n - 1]) {
      vis[x] = true;
    }
  }
  set<long long> s;
  s.insert(a[n - 1]);
  for (i = n - 2; i >= 0; i--) {
    bool ch = true;
    if (!vis[a[i]])
      s.insert(a[i]);
    else {
      long long k = 0;
      for (j = 0; j < adj[a[i]].size(); j++) {
        if (s.find(adj[a[i]][j]) != s.end()) {
          k++;
        }
      }
      if (k == s.size())
        c++;
      else
        s.insert(a[i]);
    }
  }
  cout << c << endl;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t = 1;
  for (int i = 1; i <= t; i++) {
    solve();
  }
  return 0;
}
