#include <bits/stdc++.h>
using namespace std;
int n, k;
int p[1000001];
int dep[1000001];
int f[1000001];
int cyc[1000001];
int val[1000001];
vector<int> adj[1000001];
void dfs1(int cur) {
  for (auto e : adj[cur]) {
    f[e] = dep[e] = dep[cur] + 1;
    dfs1(e);
  }
}
set<int> dfs2(int cur) {
  set<int> ret = set<int>();
  for (auto e : adj[cur]) {
    auto V = dfs2(e);
    if (V.size() > ret.size()) ret.swap(V);
    for (auto u : V) ret.insert(u);
  }
  if (adj[cur].empty()) ret.insert(dep[cur]);
  f[cur] = min(f[cur], (*ret.begin()) - k);
  return ret;
}
void dfs3(int cur) {
  for (auto e : adj[cur]) {
    dfs3(e);
    if (f[e] <= dep[cur]) cyc[cur] += cyc[e];
  }
  if (adj[cur].empty()) cyc[cur] = 1;
}
void dfs4(int cur) {
  for (auto e : adj[cur]) {
    dfs4(e);
    if (f[e] > dep[cur])
      val[cur] = max(val[cur], val[e]);
    else
      val[cur] = max(val[cur], val[e] - cyc[e]);
  }
  val[cur] += cyc[cur];
}
int main() {
  cout << setprecision(10);
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    cin >> p[i];
    adj[p[i]].push_back(i);
  }
  dfs1(1);
  dfs2(1);
  dfs3(1);
  dfs4(1);
  cout << val[1] << '\n';
  return 0;
}
