#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
using namespace std;
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n, m, k;
  cin >> n >> m >> k;
  vector<set<long long>> g(n + 1);
  vector<long long> deg(n + 1, 0);
  vector<pair<long long, long long>> v(m);
  for (long long i = 0; i < m; i++) {
    long long a, b;
    cin >> a >> b;
    g[a].insert(b);
    g[b].insert(a);
    deg[a]++;
    deg[b]++;
    v[i].first = a;
    v[i].second = b;
  }
  long long ans = n;
  queue<long long> q;
  vector<long long> vis(n + 1, 0);
  for (long long i = 1; i <= n; i++) {
    if (deg[i] < k) {
      q.push(i);
      vis[i] = 1;
    }
  }
  while (!q.empty()) {
    long long d = q.front();
    q.pop();
    ans--;
    for (auto it : g[d]) {
      g[it].erase(d);
      deg[it]--;
      if (deg[it] == k - 1) q.push(it);
    }
    g[d].clear();
  }
  vector<long long> fans(m);
  for (long long i = m - 1; i >= 0; i--) {
    fans[i] = ans;
    long long a = v[i].first;
    long long b = v[i].second;
    if (g[a].find(b) != g[a].end()) {
      g[a].erase(b);
      deg[a]--;
      if (deg[a] == k - 1) q.push(a);
    }
    if (g[b].find(a) != g[b].end()) {
      g[b].erase(a);
      deg[b]--;
      if (deg[b] == k - 1) q.push(b);
    }
    while (!q.empty()) {
      long long d = q.front();
      q.pop();
      ans--;
      for (auto it : g[d]) {
        g[it].erase(d);
        deg[it]--;
        if (deg[it] == k - 1) q.push(it);
      }
      g[d].clear();
    }
  }
  for (long long i = 0; i < m; i++) {
    cout << fans[i] << "\n";
  }
  return 0;
}
