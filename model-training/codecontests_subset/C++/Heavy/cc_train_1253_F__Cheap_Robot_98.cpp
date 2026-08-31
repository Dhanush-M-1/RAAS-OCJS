#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18 + 100;
const int MAXP = 20;
int n, m, k, q;
vector<vector<pair<int, long long>>> g;
vector<pair<pair<int, int>, long long>> sg;
vector<pair<long long, pair<int, int>>> sg2;
vector<int> pp;
vector<vector<pair<int, long long>>> dp;
vector<int> tin;
vector<int> tout;
vector<vector<pair<int, long long>>> g2;
int ttm = 0;
void dfs(int v, int p, long long x) {
  tin[v] = ttm++;
  dp[v].resize(MAXP);
  dp[v][0] = make_pair((p), (x));
  for (int i = 1; i < MAXP; ++i) {
    dp[v][i].first = dp[dp[v][i - 1].first][i - 1].first;
    dp[v][i].second =
        max(dp[v][i - 1].second, dp[dp[v][i - 1].first][i - 1].second);
  }
  for (auto e : g2[v]) {
    if (e.first != p) {
      dfs(e.first, v, e.second);
    }
  }
  tout[v] = ttm++;
}
bool ok(int v, int u) { return ((tin[v] <= tin[u]) && (tout[u] <= tout[v])); }
long long dp_g(int v, int u) {
  if (ok(v, u)) return 0;
  long long ans = 0;
  for (int i = MAXP - 1; i >= 0; --i) {
    if (!ok(dp[v][i].first, u)) {
      ans = max(ans, dp[v][i].second);
      v = dp[v][i].first;
    }
  }
  return max(ans, dp[v][0].second);
}
long long dp_get(int v, int u) { return max(dp_g(v, u), dp_g(u, v)); }
void Init() {
  pp.resize(k);
  for (int i = 0; i < k; ++i) {
    pp[i] = i;
  }
}
int Get(int v) {
  if (pp[v] == v) {
    return v;
  } else {
    return (pp[v] = Get(pp[v]));
  }
}
void Union(int v, int u) {
  v = Get(v);
  u = Get(u);
  pp[u] = v;
}
int main() {
  ios::sync_with_stdio(false);
  cout.tie(0);
  cin.tie(0);
  cin >> n >> m >> k >> q;
  g.resize(n);
  for (int i = 0; i < m; ++i) {
    int v1, v2;
    long long x;
    cin >> v1 >> v2 >> x;
    v1--;
    v2--;
    g[v1].push_back(make_pair((v2), (x)));
    g[v2].push_back(make_pair((v1), (x)));
    sg.push_back(make_pair((make_pair((v1), (v2))), (x)));
  }
  set<pair<long long, int>> st;
  vector<long long> dist(n, INF);
  vector<int> p(n);
  for (int i = 0; i < k; ++i) {
    dist[i] = 0;
    p[i] = i;
    st.insert(make_pair((0), (i)));
  }
  while (!st.empty()) {
    int v = st.begin()->second;
    st.erase(st.begin());
    for (auto e : g[v]) {
      int to = e.first;
      long long w = e.second;
      if (dist[to] > dist[v] + w) {
        p[to] = p[v];
        st.erase(make_pair((dist[to]), (to)));
        dist[to] = dist[v] + w;
        st.insert(make_pair((dist[to]), (to)));
      }
    }
  }
  for (auto e : sg) {
    sg2.push_back(
        make_pair((dist[e.first.first] + dist[e.first.second] + e.second),
                  (make_pair((p[e.first.first]), (p[e.first.second])))));
  }
  sort(sg2.begin(), sg2.end());
  g2.resize(k);
  Init();
  for (auto e : sg2) {
    if (Get(e.second.first) != Get(e.second.second)) {
      g2[e.second.first].push_back(make_pair((e.second.second), (e.first)));
      g2[e.second.second].push_back(make_pair((e.second.first), (e.first)));
      Union(e.second.first, e.second.second);
    }
  }
  dp.resize(k);
  tin.resize(k);
  tout.resize(k);
  dfs(0, 0, 0);
  while (q--) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    cout << dp_get(a, b) << '\n';
  }
  return 0;
}
