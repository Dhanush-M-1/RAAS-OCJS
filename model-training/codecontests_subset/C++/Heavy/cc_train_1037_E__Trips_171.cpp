#include <bits/stdc++.h>
using namespace std;
long long M = 2e5 + 10;
vector<long long> v[200009], deg(M), vis(M);
map<pair<long long, long long>, long long> ed;
void dfs(long long s, long long k, long long p, long long &ans) {
  vis[s] = 1;
  ans--;
  for (auto u : v[s]) {
    pair<long long, long long> p1;
    p1.first = u;
    p1.second = s;
    if (u != p && ed.find(p1) == ed.end()) {
      deg[u]--;
      deg[s]--;
      ed[make_pair(u, s)] = 1;
      ed[make_pair(s, u)] = 1;
    }
    if (vis[u] == 0 && deg[u] < k) {
      dfs(u, k, s, ans);
    }
  }
  return;
}
int main() {
  long long n, m, k;
  cin >> n >> m >> k;
  vector<pair<long long, long long> > edge;
  for (long long i = 0; i < m; i++) {
    long long a, b;
    scanf("%lld%lld", &a, &b);
    v[a].push_back(b);
    v[b].push_back(a);
    edge.push_back(make_pair(a, b));
    deg[a]++;
    deg[b]++;
  }
  long long ans = n;
  vector<long long> ans1(m);
  vis[0] = 1;
  for (long long i = 1; i <= n; i++) {
    if (deg[i] < k && vis[i] == 0) {
      dfs(i, k, 0, ans);
    }
  }
  for (long long i = m - 1; i >= 0; i--) {
    ans1[i] = ans;
    long long a = edge[i].first;
    long long b = edge[i].second;
    if (vis[a] == 0 && vis[b] == 0 && ed.find(make_pair(a, b)) == ed.end()) {
      deg[a]--;
      deg[b]--;
      ed[make_pair(a, b)] = 1;
      ed[make_pair(b, a)] = 1;
    }
    if (deg[a] < k && vis[a] == 0) {
      dfs(a, k, b, ans);
    }
    if (deg[b] < k && vis[b] == 0) {
      dfs(b, k, a, ans);
    }
  }
  for (long long i = 0; i < m; i++) {
    printf("%lld\n", ans1[i]);
  }
  return 0;
}
