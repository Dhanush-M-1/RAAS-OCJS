#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
const long long maxn = 2e5 + 10;
vector<long long> adj[maxn];
long long vis[maxn];
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout << fixed << setprecision(9);
  long long t;
  cin >> t;
  while (t--) {
    long long n, m, a, b;
    cin >> n >> m >> a >> b;
    for (long long i = 0; i <= n; ++i) {
      vis[i] = 0;
      adj[i].clear();
    }
    for (long long i = 1; i <= m; ++i) {
      long long u, v;
      cin >> u >> v;
      adj[u].push_back(v);
      adj[v].push_back(u);
    }
    vis[b] = 1;
    queue<long long> q;
    q.push(a);
    vis[a] = 1;
    while (!q.empty()) {
      long long v = q.front();
      q.pop();
      for (long long u : adj[v]) {
        if (vis[u] == 0) {
          vis[u] = 1;
          q.push(u);
        }
      }
    }
    long long cnt1 = 0;
    for (long long i = 0; i <= n; ++i) {
      if (vis[i] == 1) {
        ++cnt1;
      }
    }
    cnt1 = n - cnt1;
    for (long long i = 0; i <= n; ++i) {
      vis[i] = 0;
    }
    vis[a] = 1;
    q.push(b);
    vis[b] = 1;
    while (!q.empty()) {
      long long v = q.front();
      q.pop();
      for (long long u : adj[v]) {
        if (vis[u] == 0) {
          vis[u] = 1;
          q.push(u);
        }
      }
    }
    long long cnt2 = 0;
    for (long long i = 0; i <= n; ++i) {
      if (vis[i] == 1) ++cnt2;
    }
    cnt2 = n - cnt2;
    cout << cnt1 * cnt2 << '\n';
  }
  return 0;
}
