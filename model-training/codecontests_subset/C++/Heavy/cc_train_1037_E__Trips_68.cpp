#include <bits/stdc++.h>
using namespace std;
const int OO = 0x3f3f3f3f;
const double eps = (1e-10);
stringstream out;
int n, m, k, u, v, deg[200005];
bool isGood[200005];
vector<int> ans(200005);
set<pair<int, int> > good;
vector<pair<int, int> > edges(200005);
vector<vector<pair<int, int> > > adj(200005);
int main() {
  ios::sync_with_stdio(false);
  cout.precision(10);
  cin >> n >> m >> k;
  for (int i = 0; i < (int)(m); ++i) {
    cin >> u >> v;
    --u, --v;
    edges[i].first = u, edges[i].second = v;
    adj[u].push_back(make_pair(v, i)), adj[v].push_back(make_pair(u, i));
    ++deg[u], ++deg[v];
  }
  for (int i = 0; i < (int)(n); ++i)
    good.insert(make_pair(deg[i], i)), isGood[i] = true;
  while (!good.empty() && good.begin()->first < k) {
    u = good.begin()->second;
    for (auto p : adj[u]) {
      v = p.first;
      if (isGood[v]) {
        good.erase(make_pair(deg[v], v));
        --deg[v];
        good.insert(make_pair(deg[v], v));
      }
    }
    isGood[u] = false;
    good.erase(make_pair(deg[u], u));
  }
  for (int i = (m - 1); i >= (int)(0); --i) {
    ans[i] = ((int)((good).size()));
    u = edges[i].first, v = edges[i].second;
    if (isGood[u] && isGood[v]) {
      good.erase(make_pair(deg[u], u));
      --deg[u];
      good.insert(make_pair(deg[u], u));
      good.erase(make_pair(deg[v], v));
      --deg[v];
      good.insert(make_pair(deg[v], v));
      while (!good.empty() && good.begin()->first < k) {
        u = good.begin()->second;
        for (auto p : adj[u]) {
          if (p.second >= i) continue;
          v = p.first;
          if (isGood[v]) {
            good.erase(make_pair(deg[v], v));
            --deg[v];
            good.insert(make_pair(deg[v], v));
          }
        }
        isGood[u] = false;
        good.erase(make_pair(deg[u], u));
      }
    }
  }
  for (int i = 0; i < (int)(m); ++i) out << ans[i] << '\n';
  cout << out.str();
  return 0;
}
