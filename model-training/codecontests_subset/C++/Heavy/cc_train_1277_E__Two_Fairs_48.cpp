#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 200005;
long long n, m, a, b;
std::vector<long long> v[MAXN];
bool vis[MAXN];
long long novis;
long long cnt1, cnt2;
void dfs(long long p, bool now) {
  vis[p] = true;
  if (now)
    cnt1--;
  else
    cnt2--;
  for (long long i = 0; i < v[p].size(); i++) {
    long long u = v[p][i];
    if (!vis[u] && u != novis) {
      dfs(u, now);
    }
  }
}
signed main() {
  ios::sync_with_stdio(false);
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    cnt1 = cnt2 = n;
    for (long long i = 1; i <= n; i++) {
      v[i].clear();
      vis[i] = false;
    }
    for (long long i = 1; i <= m; i++) {
      long long x, y;
      cin >> x >> y;
      v[x].push_back(y);
      v[y].push_back(x);
    }
    novis = a;
    dfs(b, true);
    for (long long i = 1; i <= n; i++) vis[i] = false;
    novis = b;
    dfs(a, false);
    cnt1--;
    cnt2--;
    cout << cnt1 * cnt2 << endl;
  }
  return 0;
}
